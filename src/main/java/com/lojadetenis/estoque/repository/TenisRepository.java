package com.lojadetenis.estoque.repository;

import com.lojadetenis.estoque.model.Tenis;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TenisRepository extends JpaRepository<Tenis, Long> {

    @Override
    @EntityGraph(attributePaths = "itensEstoque")
    List<Tenis> findAll();

    @Override
    @EntityGraph(attributePaths = "itensEstoque")
    Optional<Tenis> findById(Long id);
}
