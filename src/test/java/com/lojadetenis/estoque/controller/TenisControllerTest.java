package com.lojadetenis.estoque.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.dto.TenisRequestDTO;
import com.lojadetenis.estoque.dto.TenisResponseDTO;
import com.lojadetenis.estoque.service.TenisServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TenisController.class)
class TenisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TenisServicePort tenisService;

    @Test
    void deveRetornarCreatedAoCadastrarTenis() throws Exception {
        TenisRequestDTO request = new TenisRequestDTO();
        request.setModelo("Classic 574");
        request.setMarca("New Balance");
        request.setCor("Cinza");
        request.setNumeracoes(List.of(39, 40, 41));

        TenisResponseDTO response = new TenisResponseDTO();
        response.setId(1L);
        response.setModelo("Classic 574");
        response.setMarca("New Balance");
        response.setCor("Cinza");
        response.setEstoquePorNumeracao(List.of(
                new EstoquePorNumeracaoDTO(1L, "Classic 574", 39, 0)
        ));

        when(tenisService.cadastrar(any(TenisRequestDTO.class))).thenReturn(response);

        mockMvc.perform(post("/api/tenis")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.modelo").value("Classic 574"));
    }
}
