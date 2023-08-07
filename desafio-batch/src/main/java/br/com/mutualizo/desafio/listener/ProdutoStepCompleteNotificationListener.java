package br.com.mutualizo.desafio.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProdutoStepCompleteNotificationListener extends StepExecutionListenerSupport {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("ProdutoStepCompleteNotificationListener | BeforeStep | StepExecution job id : " + stepExecution.getId());
        super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("ProdutoStepCompleteNotificationListener | AfterStep | StepExecution job id : " + stepExecution.getId());
        return super.afterStep(stepExecution);
    }

}
