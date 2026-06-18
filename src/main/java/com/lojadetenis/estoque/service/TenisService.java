package com.lojadetenis.estoque.service;

import com.lojadetenis.estoque.dto.EstoquePorNumeracaoDTO;
import com.lojadetenis.estoque.dto.TenisRequestDTO;
import com.lojadetenis.estoque.dto.TenisResponseDTO;
import com.lojadetenis.estoque.exception.BusinessException;
import com.lojadetenis.estoque.exception.ResourceNotFoundException;
import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.Tenis;
import com.lojadetenis.estoque.repository.TenisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TenisService implements TenisServicePort {

    private final TenisRepository tenisRepository;

    public TenisService(TenisRepository tenisRepository) {
        this.tenisRepository = tenisRepository;
    }

    @Override
    @Transactional
    public TenisResponseDTO cadastrar(TenisRequestDTO requestDTO) {
        validarNumeracoes(requestDTO.getNumeracoes());

        Tenis tenis = new Tenis(requestDTO.getModelo(), requestDTO.getMarca(), requestDTO.getCor());
        requestDTO.getNumeracoes().stream()
                .sorted()
                .forEach(numero -> tenis.adicionarItemEstoque(new EstoqueItem(numero, 0)));

        Tenis salvo = tenisRepository.save(tenis);
        return toResponseDTO(salvo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TenisResponseDTO> listarTodos() {
        return tenisRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TenisResponseDTO buscarPorId(Long id) {
        Tenis tenis = tenisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tênis não encontrado para o ID informado."));
        return toResponseDTO(tenis);
    }

    private void validarNumeracoes(List<Integer> numeracoes) {
        Set<Integer> unicas = new HashSet<>(numeracoes);
        if (unicas.size() != numeracoes.size()) {
            throw new BusinessException("Existem numerações duplicadas no cadastro do tênis.");
        }
        boolean invalida = numeracoes.stream().anyMatch(numero -> numero < 10 || numero > 60);
        if (invalida) {
            throw new BusinessException("As numerações devem estar entre 10 e 60.");
        }
    }

    private TenisResponseDTO toResponseDTO(Tenis tenis) {
        TenisResponseDTO dto = new TenisResponseDTO();
        dto.setId(tenis.getId());
        dto.setModelo(tenis.getModelo());
        dto.setMarca(tenis.getMarca());
        dto.setCor(tenis.getCor());
        dto.setEstoquePorNumeracao(tenis.getItensEstoque().stream()
                .sorted((a, b) -> a.getNumero().compareTo(b.getNumero()))
                .map(item -> new EstoquePorNumeracaoDTO(tenis.getId(), tenis.getModelo(), item.getNumero(), item.getQuantidade()))
                .toList());
        return dto;
    }
}
