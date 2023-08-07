package br.com.mutualizo.desafio.reader;

import br.com.mutualizo.desafio.dto.ProdutoInput;
import org.springframework.batch.item.ItemReader;

public interface ProdutoItemReader {

    ItemReader<ProdutoInput> itemReader();

}
