package com.lojadetenis.estoque.controller;

import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.service.EstoqueServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstoqueController.class)
class EstoqueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstoqueServicePort estoqueService;

    @Test
    void deveConsultarEstoquePorNumeracao() throws Exception {
        when(estoqueService.consultarPorNumeracao(1L, 39))
                .thenReturn(new EstoquePorNumeracaoDTO(1L, "Air Zoom", 39, 5));

        mockMvc.perform(get("/api/estoque/1/numeracao/39"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tenisId").value(1L))
                .andExpect(jsonPath("$.numero").value(39))
                .andExpect(jsonPath("$.quantidade").value(5));
    }
}
