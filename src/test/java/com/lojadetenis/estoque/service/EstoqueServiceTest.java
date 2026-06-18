package com.lojadetenis.estoque.service;

import com.lojadetenis.estoque.dto.EstoqueBaixoDTO;
import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.dto.MovimentacaoEstoqueDTO;
import com.lojadetenis.estoque.exception.BusinessException;
import com.lojadetenis.estoque.factory.MovimentacaoEstoqueFactory;
import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.MovimentacaoEstoque;
import com.lojadetenis.estoque.model.Tenis;
import com.lojadetenis.estoque.repository.EstoqueItemRepository;
import com.lojadetenis.estoque.repository.MovimentacaoEstoqueRepository;
import com.lojadetenis.estoque.repository.TenisRepository;
import com.lojadetenis.estoque.strategy.EntradaEstoqueStrategy;
import com.lojadetenis.estoque.strategy.EstoqueOperationStrategy;
import com.lojadetenis.estoque.strategy.SaidaEstoqueStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstoqueServiceTest {

    @Mock
    private TenisRepository tenisRepository;

    @Mock
    private EstoqueItemRepository estoqueItemRepository;

    @Mock
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Mock
    private MovimentacaoEstoqueFactory movimentacaoEstoqueFactory;

    private EstoqueService estoqueService;

    private Tenis tenis;
    private EstoqueItem item38;

    @BeforeEach
    void setup() {
        EstoqueOperationStrategy entrada = new EntradaEstoqueStrategy();
        EstoqueOperationStrategy saida = new SaidaEstoqueStrategy();
        estoqueService = new EstoqueService(
                tenisRepository,
                estoqueItemRepository,
                movimentacaoEstoqueRepository,
                movimentacaoEstoqueFactory,
                List.of(entrada, saida)
        );

        tenis = new Tenis("Air Zoom", "Nike", "Preto");
        tenis.setId(1L);

        item38 = new EstoqueItem(38, 5);
        item38.setId(10L);
        item38.setTenis(tenis);
    }

    @Test
    void deveRegistrarEntradaDeEstoque() {
        MovimentacaoEstoqueDTO dto = criarMovimentacao(1L, 38, 3);

        when(tenisRepository.findById(1L)).thenReturn(Optional.of(tenis));
        when(estoqueItemRepository.findByTenisIdAndNumero(1L, 38)).thenReturn(Optional.of(item38));
        when(estoqueItemRepository.save(any(EstoqueItem.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(movimentacaoEstoqueFactory.criar(any(), any(), any())).thenReturn(new MovimentacaoEstoque());

        EstoquePorNumeracaoDTO response = estoqueService.registrarEntrada(dto);

        assertEquals(8, response.getQuantidade());
    }

    @Test
    void deveRegistrarSaidaComQuantidadeValida() {
        MovimentacaoEstoqueDTO dto = criarMovimentacao(1L, 38, 2);

        when(tenisRepository.findById(1L)).thenReturn(Optional.of(tenis));
        when(estoqueItemRepository.findByTenisIdAndNumero(1L, 38)).thenReturn(Optional.of(item38));
        when(estoqueItemRepository.save(any(EstoqueItem.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(movimentacaoEstoqueFactory.criar(any(), any(), any())).thenReturn(new MovimentacaoEstoque());

        EstoquePorNumeracaoDTO response = estoqueService.registrarSaida(dto);

        assertEquals(3, response.getQuantidade());
    }

    @Test
    void deveImpedirSaidaMaiorQueEstoqueDisponivel() {
        MovimentacaoEstoqueDTO dto = criarMovimentacao(1L, 38, 6);

        when(tenisRepository.findById(1L)).thenReturn(Optional.of(tenis));
        when(estoqueItemRepository.findByTenisIdAndNumero(1L, 38)).thenReturn(Optional.of(item38));

        BusinessException exception = assertThrows(BusinessException.class, () -> estoqueService.registrarSaida(dto));

        assertEquals("Saída não permitida: quantidade solicitada é maior que o estoque disponível.", exception.getMessage());
    }

    @Test
    void deveIdentificarEstoqueBaixo() {
        EstoqueItem itemBaixo = new EstoqueItem(40, 2);
        itemBaixo.setTenis(tenis);

        when(estoqueItemRepository.findByQuantidadeLessThanEqual(3)).thenReturn(List.of(itemBaixo));

        List<EstoqueBaixoDTO> response = estoqueService.listarEstoqueBaixo(3);

        assertEquals(1, response.size());
        assertEquals(40, response.get(0).getNumero());
        assertEquals(2, response.get(0).getQuantidade());
    }

    @Test
    void deveConsultarEstoquePorNumeracao() {
        when(estoqueItemRepository.findByTenisIdAndNumero(1L, 38)).thenReturn(Optional.of(item38));

        EstoquePorNumeracaoDTO response = estoqueService.consultarPorNumeracao(1L, 38);

        assertEquals(1L, response.getTenisId());
        assertEquals(38, response.getNumero());
        assertEquals(5, response.getQuantidade());
    }

    private MovimentacaoEstoqueDTO criarMovimentacao(Long tenisId, Integer numero, Integer quantidade) {
        MovimentacaoEstoqueDTO dto = new MovimentacaoEstoqueDTO();
        dto.setTenisId(tenisId);
        dto.setNumero(numero);
        dto.setQuantidade(quantidade);
        return dto;
    }
}
