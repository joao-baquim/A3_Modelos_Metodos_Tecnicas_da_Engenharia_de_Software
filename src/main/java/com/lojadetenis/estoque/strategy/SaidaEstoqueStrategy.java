package com.lojadetenis.estoque.strategy;

import com.lojadetenis.estoque.exception.BusinessException;
import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.TipoMovimentacao;
import org.springframework.stereotype.Component;

@Component
public class SaidaEstoqueStrategy implements EstoqueOperationStrategy {

    @Override
    public TipoMovimentacao getTipo() {
        return TipoMovimentacao.SAIDA;
    }

    @Override
    public void aplicar(EstoqueItem item, int quantidade) {
        if (quantidade > item.getQuantidade()) {
            throw new BusinessException("Saída não permitida: quantidade solicitada é maior que o estoque disponível.");
        }
        item.setQuantidade(item.getQuantidade() - quantidade);
    }
}
