package com.lojadetenis.estoque.repository;

import com.lojadetenis.estoque.model.EstoqueItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstoqueItemRepository extends JpaRepository<EstoqueItem, Long> {

    Optional<EstoqueItem> findByTenisIdAndNumero(Long tenisId, Integer numero);

    List<EstoqueItem> findByQuantidadeLessThanEqual(Integer limite);
}
