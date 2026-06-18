package com.lojadetenis.estoque.service;

import com.lojadetenis.estoque.dto.EstoqueBaixoDTO;
import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.dto.MovimentacaoEstoqueDTO;
import com.lojadetenis.estoque.exception.ResourceNotFoundException;
import com.lojadetenis.estoque.factory.MovimentacaoEstoqueFactory;
import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.Tenis;
import com.lojadetenis.estoque.model.TipoMovimentacao;
import com.lojadetenis.estoque.repository.EstoqueItemRepository;
import com.lojadetenis.estoque.repository.MovimentacaoEstoqueRepository;
import com.lojadetenis.estoque.repository.TenisRepository;
import com.lojadetenis.estoque.strategy.EstoqueOperationStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class EstoqueService implements EstoqueServicePort {

    private static final int LIMITE_ESTOQUE_BAIXO_PADRAO = 3;

    private final TenisRepository tenisRepository;
    private final EstoqueItemRepository estoqueItemRepository;
    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;
    private final MovimentacaoEstoqueFactory movimentacaoEstoqueFactory;
    private final Map<TipoMovimentacao, EstoqueOperationStrategy> strategyMap;

    public EstoqueService(TenisRepository tenisRepository,
                          EstoqueItemRepository estoqueItemRepository,
                          MovimentacaoEstoqueRepository movimentacaoEstoqueRepository,
                          MovimentacaoEstoqueFactory movimentacaoEstoqueFactory,
                          List<EstoqueOperationStrategy> strategies) {
        this.tenisRepository = tenisRepository;
        this.estoqueItemRepository = estoqueItemRepository;
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
        this.movimentacaoEstoqueFactory = movimentacaoEstoqueFactory;
        this.strategyMap = new EnumMap<>(TipoMovimentacao.class);
        strategies.forEach(strategy -> this.strategyMap.put(strategy.getTipo(), strategy));
    }

    @Override
    @Transactional
    public EstoquePorNumeracaoDTO registrarEntrada(MovimentacaoEstoqueDTO dto) {
        return movimentar(dto, TipoMovimentacao.ENTRADA);
    }

    @Override
    @Transactional
    public EstoquePorNumeracaoDTO registrarSaida(MovimentacaoEstoqueDTO dto) {
        return movimentar(dto, TipoMovimentacao.SAIDA);
    }

    @Override
    @Transactional(readOnly = true)
    public EstoquePorNumeracaoDTO consultarPorNumeracao(Long tenisId, Integer numero) {
        EstoqueItem item = estoqueItemRepository.findByTenisIdAndNumero(tenisId, numero)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o tênis e numeração informados."));
        return toEstoqueDTO(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstoqueBaixoDTO> listarEstoqueBaixo(Integer limite) {
        int limiteAplicado = limite == null ? LIMITE_ESTOQUE_BAIXO_PADRAO : limite;
        return estoqueItemRepository.findByQuantidadeLessThanEqual(limiteAplicado)
                .stream()
                .map(item -> new EstoqueBaixoDTO(
                        item.getTenis().getId(),
                        item.getTenis().getModelo(),
                        item.getTenis().getMarca(),
                        item.getTenis().getCor(),
                        item.getNumero(),
                        item.getQuantidade()))
                .toList();
    }

    private EstoquePorNumeracaoDTO movimentar(MovimentacaoEstoqueDTO dto, TipoMovimentacao tipo) {
        Tenis tenis = tenisRepository.findById(dto.getTenisId())
                .orElseThrow(() -> new ResourceNotFoundException("Tênis não encontrado para o ID informado."));

        EstoqueItem item = estoqueItemRepository.findByTenisIdAndNumero(dto.getTenisId(), dto.getNumero())
                .orElseGet(() -> criarVariacaoSeEntrada(tenis, dto.getNumero(), tipo));

        strategyMap.get(tipo).aplicar(item, dto.getQuantidade());
        EstoqueItem atualizado = estoqueItemRepository.save(item);
        movimentacaoEstoqueRepository.save(movimentacaoEstoqueFactory.criar(tipo, atualizado, dto.getQuantidade()));
        return toEstoqueDTO(atualizado);
    }

    private EstoqueItem criarVariacaoSeEntrada(Tenis tenis, Integer numero, TipoMovimentacao tipo) {
        if (tipo == TipoMovimentacao.SAIDA) {
            throw new ResourceNotFoundException("Não existe estoque cadastrado para essa numeração.");
        }
        EstoqueItem novo = new EstoqueItem(numero, 0);
        novo.setTenis(tenis);
        return novo;
    }

    private EstoquePorNumeracaoDTO toEstoqueDTO(EstoqueItem item) {
        return new EstoquePorNumeracaoDTO(item.getTenis().getId(), item.getTenis().getModelo(), item.getNumero(), item.getQuantidade());
    }
}
