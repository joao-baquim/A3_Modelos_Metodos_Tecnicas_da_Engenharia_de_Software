package com.lojadetenis.estoque.service;

import com.lojadetenis.estoque.dto.TenisRequestDTO;
import com.lojadetenis.estoque.dto.TenisResponseDTO;
import com.lojadetenis.estoque.model.Tenis;
import com.lojadetenis.estoque.repository.TenisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TenisServiceTest {

    @Mock
    private TenisRepository tenisRepository;

    @InjectMocks
    private TenisService tenisService;

    private TenisRequestDTO requestDTO;

    @BeforeEach
    void setup() {
        requestDTO = new TenisRequestDTO();
        requestDTO.setModelo("Air Max 90");
        requestDTO.setMarca("Nike");
        requestDTO.setCor("Azul");
        requestDTO.setNumeracoes(List.of(38, 39, 40));
    }

    @Test
    void deveCadastrarTenisComNumeracoes() {
        when(tenisRepository.save(any(Tenis.class))).thenAnswer(invocation -> {
            Tenis tenis = invocation.getArgument(0);
            tenis.setId(1L);
            return tenis;
        });

        TenisResponseDTO response = tenisService.cadastrar(requestDTO);

        ArgumentCaptor<Tenis> captor = ArgumentCaptor.forClass(Tenis.class);
        verify(tenisRepository).save(captor.capture());

        Tenis salvo = captor.getValue();
        assertEquals("Air Max 90", salvo.getModelo());
        assertEquals(3, salvo.getItensEstoque().size());
        assertNotNull(response.getId());
        assertEquals(3, response.getEstoquePorNumeracao().size());
        assertEquals(0, response.getEstoquePorNumeracao().get(0).getQuantidade());
    }
}
