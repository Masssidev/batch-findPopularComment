package com.comment.job.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class DecreaseEmpathyLauncher {

	@Autowired
	public JobLauncher jobLauncher;

	@Autowired
	public Job decreaseEmpathyJob;

	private Logger logger = LoggerFactory.getLogger(DecreaseEmpathyLauncher.class);

	@Scheduled (cron = "*/1 * * * * *")
	public void start() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();

		try {
			JobExecution jobExecution = jobLauncher.run(decreaseEmpathyJob, jobParameters);

			logger.info("###############  status: {}" ,jobExecution.getStatus());

		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			logger.error(e.toString() + "Fail to launch job");
		}
	}
}
