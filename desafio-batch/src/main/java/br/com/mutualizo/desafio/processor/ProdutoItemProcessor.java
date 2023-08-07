package br.com.mutualizo.desafio.processor;

import br.com.mutualizo.desafio.dto.ProdutoInput;
import br.com.mutualizo.desafio.model.Produto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class ProdutoItemProcessor implements ItemProcessor<ProdutoInput, Produto> {

    @Override
    public Produto process(ProdutoInput input) throws Exception {
        Produto produto = new Produto();
        produto.setId(input.getId());
        produto.setNome(input.getNome());
        produto.setPreco(input.getPreco());
        return produto;
    }

}
