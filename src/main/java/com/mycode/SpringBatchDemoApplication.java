package com.mycode;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchDemoApplication implements CommandLineRunner {
	
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    @Qualifier("tradeExpiryCheck")
    Job tradeExpiryCheckJob;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	private static int runId = 0;
	
	@Scheduled(cron = "*/2 * * * * *")
	public void perform() throws Exception {
		
		System.out.println("Job invoked");

		 JobParameters jobParameters = new JobParametersBuilder()
					.addString("source", "Spring Boot-"+ runId)
					.toJobParameters();
			jobLauncher.run(tradeExpiryCheckJob, jobParameters);
			runId++;
			
		//	return "Batch job has been invoked";
	}
}
