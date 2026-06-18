package com.lojadetenis.estoque.dto;

import java.util.ArrayList;
import java.util.List;

public class TenisResponseDTO {

    private Long id;
    private String modelo;
    private String marca;
    private String cor;
    private List<EstoquePorNumeracaoDTO> estoquePorNumeracao = new ArrayList<>();

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

    public List<EstoquePorNumeracaoDTO> getEstoquePorNumeracao() {
        return estoquePorNumeracao;
    }

    public void setEstoquePorNumeracao(List<EstoquePorNumeracaoDTO> estoquePorNumeracao) {
        this.estoquePorNumeracao = estoquePorNumeracao;
    }
}
