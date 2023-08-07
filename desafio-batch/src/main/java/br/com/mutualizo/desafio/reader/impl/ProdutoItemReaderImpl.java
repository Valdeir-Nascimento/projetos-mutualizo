package br.com.mutualizo.desafio.reader.impl;

import br.com.mutualizo.desafio.dto.ProdutoInput;
import br.com.mutualizo.desafio.reader.ProdutoItemReader;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class ProdutoItemReaderImpl implements ProdutoItemReader {

    @Override
    public ItemReader<ProdutoInput> itemReader() {
        FlatFileItemReader<ProdutoInput> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("produtos.csv"));
        reader.setLineMapper(new DefaultLineMapper<>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames("id", "nome", "preco");
                        setDelimiter(",");
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<ProdutoInput>() {
                    {
                        setTargetType(ProdutoInput.class);
                    }
                });
            }
        });
        return reader;
    }

}
