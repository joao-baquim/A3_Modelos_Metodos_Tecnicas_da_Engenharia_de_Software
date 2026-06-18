package com.lojadetenis.estoque.strategy;

import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.TipoMovimentacao;
import org.springframework.stereotype.Component;

@Component
public class EntradaEstoqueStrategy implements EstoqueOperationStrategy {

    @Override
    public TipoMovimentacao getTipo() {
        return TipoMovimentacao.ENTRADA;
    }

    @Override
    public void aplicar(EstoqueItem item, int quantidade) {
        item.setQuantidade(item.getQuantidade() + quantidade);
    }
}
