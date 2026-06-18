package com.lojadetenis.estoque.service;

import com.lojadetenis.estoque.dto.EstoqueBaixoDTO;
import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.dto.MovimentacaoEstoqueDTO;

import java.util.List;

public interface EstoqueServicePort {

    EstoquePorNumeracaoDTO registrarEntrada(MovimentacaoEstoqueDTO dto);

    EstoquePorNumeracaoDTO registrarSaida(MovimentacaoEstoqueDTO dto);

    EstoquePorNumeracaoDTO consultarPorNumeracao(Long tenisId, Integer numero);

    List<EstoqueBaixoDTO> listarEstoqueBaixo(Integer limite);
}
