package com.lojadetenis.estoque.config;

import com.lojadetenis.estoque.model.EstoqueItem;
import com.lojadetenis.estoque.model.Tenis;
import com.lojadetenis.estoque.repository.TenisRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner carregarDadosIniciais(TenisRepository tenisRepository) {
        return args -> {
            if (tenisRepository.count() > 0) {
                return;
            }

            Tenis tenis1 = new Tenis("Air Zoom", "Nike", "Preto");
            tenis1.adicionarItemEstoque(new EstoqueItem(38, 2));
            tenis1.adicionarItemEstoque(new EstoqueItem(39, 5));
            tenis1.adicionarItemEstoque(new EstoqueItem(40, 1));

            Tenis tenis2 = new Tenis("Ultraboost Light", "Adidas", "Branco");
            tenis2.adicionarItemEstoque(new EstoqueItem(41, 7));
            tenis2.adicionarItemEstoque(new EstoqueItem(42, 2));

            tenisRepository.save(tenis1);
            tenisRepository.save(tenis2);
        };
    }
}
