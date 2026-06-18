package com.lojadetenis.estoque.controller;

import com.lojadetenis.estoque.dto.EstoqueBaixoDTO;
import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.dto.MovimentacaoEstoqueDTO;
import com.lojadetenis.estoque.service.EstoqueServicePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueServicePort estoqueService;

    public EstoqueController(EstoqueServicePort estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping("/entrada")
    public ResponseEntity<EstoquePorNumeracaoDTO> registrarEntrada(@Valid @RequestBody MovimentacaoEstoqueDTO dto) {
        return ResponseEntity.ok(estoqueService.registrarEntrada(dto));
    }

    @PostMapping("/saida")
    public ResponseEntity<EstoquePorNumeracaoDTO> registrarSaida(@Valid @RequestBody MovimentacaoEstoqueDTO dto) {
        return ResponseEntity.ok(estoqueService.registrarSaida(dto));
    }

    @GetMapping("/{tenisId}/numeracao/{numero}")
    public ResponseEntity<EstoquePorNumeracaoDTO> consultarPorNumeracao(@PathVariable Long tenisId, @PathVariable Integer numero) {
        return ResponseEntity.ok(estoqueService.consultarPorNumeracao(tenisId, numero));
    }

    @GetMapping("/baixo")
    public ResponseEntity<List<EstoqueBaixoDTO>> listarEstoqueBaixo(@RequestParam(required = false) Integer limite) {
        return ResponseEntity.ok(estoqueService.listarEstoqueBaixo(limite));
    }
}
