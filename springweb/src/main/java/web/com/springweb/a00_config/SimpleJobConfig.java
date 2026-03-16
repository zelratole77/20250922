package web.com.springweb.a00_config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import web.com.springweb.a02_mvc.a01_idol.A02_Idol_Service;
import web.com.springweb.a02_mvc.a01_idol.A04Group;

@Configuration
public class SimpleJobConfig {
	@Autowired(required=false)
	private A02_Idol_Service service;
    @Bean
    public Job simpleJob(JobRepository jobRepository, Step simpleStep) {
        return new JobBuilder("simpleJob", jobRepository)
                .start(simpleStep)
                .build();
    }

    @Bean
    public Step simpleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("simpleStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println(">>>>> [예제 1] 배치 작업 실행 성공!");
                    System.out.print("서비스 처리 결과:"+service.getIdolGrpList(new A04Group()).size()+"건 ####");
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }
}