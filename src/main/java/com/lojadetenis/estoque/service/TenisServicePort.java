package com.lojadetenis.estoque.service;

import com.lojadetenis.estoque.dto.TenisRequestDTO;
import com.lojadetenis.estoque.dto.TenisResponseDTO;

import java.util.List;

public interface TenisServicePort {

    TenisResponseDTO cadastrar(TenisRequestDTO requestDTO);

    List<TenisResponseDTO> listarTodos();

    TenisResponseDTO buscarPorId(Long id);
}
