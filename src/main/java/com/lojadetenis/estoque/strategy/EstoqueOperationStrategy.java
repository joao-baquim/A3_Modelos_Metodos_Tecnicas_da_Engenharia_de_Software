package com.lojadetenis.estoque.strategy;

import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.TipoMovimentacao;

public interface EstoqueOperationStrategy {

    TipoMovimentacao getTipo();

    void aplicar(EstoqueItem item, int quantidade);
}
