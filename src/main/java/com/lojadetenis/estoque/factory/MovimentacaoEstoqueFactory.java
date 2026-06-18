package com.lojadetenis.estoque.factory;

import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.MovimentacaoEstoque;
import com.lojadetenis.estoque.model.TipoMovimentacao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MovimentacaoEstoqueFactory {

    public MovimentacaoEstoque criar(TipoMovimentacao tipo, EstoqueItem item, Integer quantidade) {
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setTenis(item.getTenis());
        movimentacao.setNumero(item.getNumero());
        movimentacao.setQuantidade(quantidade);
        movimentacao.setTipo(tipo);
        movimentacao.setDataHora(LocalDateTime.now());
        return movimentacao;
    }
}
