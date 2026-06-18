package com.lojadetenis.estoque.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MovimentacaoEstoqueDTO {

    @NotNull(message = "O ID do tênis é obrigatório.")
    private Long tenisId;

    @NotNull(message = "A numeração é obrigatória.")
    private Integer numero;

    @NotNull(message = "A quantidade é obrigatória.")
    @Min(value = 1, message = "A quantidade deve ser maior que zero.")
    private Integer quantidade;

    public Long getTenisId() {
        return tenisId;
    }

    public void setTenisId(Long tenisId) {
        this.tenisId = tenisId;
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
