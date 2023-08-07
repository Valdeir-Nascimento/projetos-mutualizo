package br.com.mutualizo.desafio.config;

import br.com.mutualizo.desafio.dto.ProdutoInput;
import br.com.mutualizo.desafio.listener.ProdutoJobExecutionNotificationListener;
import br.com.mutualizo.desafio.listener.ProdutoStepCompleteNotificationListener;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.processor.ProdutoProcessor;
import br.com.mutualizo.desafio.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ProdutoRepository produtoRepository;
    private final ProdutoJobExecutionNotificationListener produtoJobExecutionNotificationListener;
    private final ProdutoStepCompleteNotificationListener produtoStepCompleteNotificationListener;


    @Bean
    public FlatFileItemReader<ProdutoInput> reader() {
        FlatFileItemReader<ProdutoInput> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/produtos.csv"));
        itemReader.setName("produtos");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    @Bean
    public ProdutoProcessor processar() {
        return new ProdutoProcessor();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

    @Bean
    public RepositoryItemWriter<Produto> writer() {
        RepositoryItemWriter<Produto> writer = new RepositoryItemWriter<>();
        writer.setRepository(produtoRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("csv-step").<ProdutoInput, Produto>chunk(10)
                .reader(reader())
                .processor(processar())
                .writer(writer())
                .listener(produtoJobExecutionNotificationListener)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("processar-arquivo")
                .listener(produtoStepCompleteNotificationListener)
                .flow(step1()).end().build();

    }

    private LineMapper<ProdutoInput> lineMapper() {
        DefaultLineMapper<ProdutoInput> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(
                "id", "nome", "preco"
        );
        BeanWrapperFieldSetMapper<ProdutoInput> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(ProdutoInput.class);
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

}
