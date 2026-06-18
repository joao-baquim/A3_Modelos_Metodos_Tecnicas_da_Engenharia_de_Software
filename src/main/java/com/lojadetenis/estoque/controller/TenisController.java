package com.lojadetenis.estoque.controller;

import com.lojadetenis.estoque.dto.TenisRequestDTO;
import com.lojadetenis.estoque.dto.TenisResponseDTO;
import com.lojadetenis.estoque.service.TenisServicePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tenis")
public class TenisController {

    private final TenisServicePort tenisService;

    public TenisController(TenisServicePort tenisService) {
        this.tenisService = tenisService;
    }

    @PostMapping
    public ResponseEntity<TenisResponseDTO> cadastrar(@Valid @RequestBody TenisRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tenisService.cadastrar(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TenisResponseDTO>> listarTodos() {
        return ResponseEntity.ok(tenisService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenisResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tenisService.buscarPorId(id));
    }
}
