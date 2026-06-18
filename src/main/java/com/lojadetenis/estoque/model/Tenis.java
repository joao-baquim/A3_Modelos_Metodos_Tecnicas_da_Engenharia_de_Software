package com.lojadetenis.estoque.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tenis")
public class Tenis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String modelo;

    @Column(nullable = false, length = 120)
    private String marca;

    @Column(nullable = false, length = 60)
    private String cor;

    @OneToMany(mappedBy = "tenis", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EstoqueItem> itensEstoque = new ArrayList<>();

    public Tenis() {
    }

    public Tenis(String modelo, String marca, String cor) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
    }

    public void adicionarItemEstoque(EstoqueItem item) {
        item.setTenis(this);
        this.itensEstoque.add(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<EstoqueItem> getItensEstoque() {
        return itensEstoque;
    }

    public void setItensEstoque(List<EstoqueItem> itensEstoque) {
        this.itensEstoque = itensEstoque;
    }
}
