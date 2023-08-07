package br.com.mutualizo.desafio.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProdutoJobExecutionNotificationListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("ProdutoJobExecutionNotificationListener | BeforeJob | Executing Id: " + jobExecution.getJobId());
        super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("ProdutoJobExecutionNotificationListener | AfterJob | Executing job id : " + jobExecution.getJobId());
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Job Completed");
        }
    }

}
