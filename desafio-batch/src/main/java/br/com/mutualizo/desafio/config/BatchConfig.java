package br.com.mutualizo.desafio.config;

import br.com.mutualizo.desafio.dto.ProdutoInput;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.processor.ProdutoItemProcessor;
import br.com.mutualizo.desafio.reader.ProdutoItemReader;
import br.com.mutualizo.desafio.writer.ProdutoItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ProdutoItemReader produtoItemReader;
    private final ProdutoItemProcessor produtoItemProcessor;
    private final ProdutoItemWriter produtoItemWriter;

    @Bean
    public Step step() {
        return stepBuilderFactory.get("processCsvStep")
                .<ProdutoInput, Produto>chunk(10)
                .reader(produtoItemReader.itemReader())
                .processor(produtoItemProcessor)
                .writer(produtoItemWriter)
                .build();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step())
                .end()
                .build();
    }

}
