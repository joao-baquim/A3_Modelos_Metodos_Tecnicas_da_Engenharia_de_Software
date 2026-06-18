package com.lojadetenis.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TenisRequestDTO {

    @NotBlank(message = "O modelo é obrigatório.")
    private String modelo;

    @NotBlank(message = "A marca é obrigatória.")
    private String marca;

    @NotBlank(message = "A cor é obrigatória.")
    private String cor;

    @NotEmpty(message = "Informe ao menos uma numeração.")
    @Size(max = 20, message = "Informe no máximo 20 numerações por cadastro.")
    private List<@NotNull(message = "A numeração não pode ser nula.") Integer> numeracoes;

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

    public List<Integer> getNumeracoes() {
        return numeracoes;
    }

    public void setNumeracoes(List<Integer> numeracoes) {
        this.numeracoes = numeracoes;
    }
}
