package br.com.mutualizo.desafio.writer;

import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoItemWriter implements ItemWriter<Produto> {

    private final ProdutoRepository produtoRepository;

    @Override
    public void write(List<? extends Produto> produtos) throws Exception {
        produtoRepository.saveAll(produtos);
    }

}
