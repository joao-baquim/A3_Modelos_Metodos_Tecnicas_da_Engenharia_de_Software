package com.lojadetenis.estoque.dto;

public class EstoqueBaixoDTO {

    private Long tenisId;
    private String modelo;
    private String marca;
    private String cor;
    private Integer numero;
    private Integer quantidade;

    public EstoqueBaixoDTO() {
    }

    public EstoqueBaixoDTO(Long tenisId, String modelo, String marca, String cor, Integer numero, Integer quantidade) {
        this.tenisId = tenisId;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
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
