package com.lojadetenis.estoque.dto;

public class EstoquePorNumeracaoDTO {

    private Long tenisId;
    private String modelo;
    private Integer numero;
    private Integer quantidade;

    public EstoquePorNumeracaoDTO() {
    }

    public EstoquePorNumeracaoDTO(Long tenisId, String modelo, Integer numero, Integer quantidade) {
        this.tenisId = tenisId;
        this.modelo = modelo;
        this.numero = numero;
        this.quantidade = quantidade;
    }

    public Long getTenisId() {
        return tenisId;
    }

    public void setTenisId(Long tenisId) {
        this.tenisId = tenisId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
