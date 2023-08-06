package br.com.mutualizo.desafio.processor;

import br.com.mutualizo.desafio.dto.ProdutoInput;
import br.com.mutualizo.desafio.model.Produto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProcessor implements ItemProcessor<ProdutoInput, Produto> {
    @Override
    public Produto process(ProdutoInput item) throws Exception {
        Produto produto = new Produto();
        produto.setId(item.getId());
        produto.setNome(item.getNome());
        produto.setPreco(item.getPreco());
        return produto;
    }

}
