package atwom.work.receive_ms_kafka.config.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("Executing job id " + jobExecution.getId());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED ");
		}
	}
}
