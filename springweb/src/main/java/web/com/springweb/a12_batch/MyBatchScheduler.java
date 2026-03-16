package web.com.springweb.a12_batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "my.scheduler.enabled", havingValue = "true", matchIfMissing = true)
public class MyBatchScheduler {

    private final JobLauncher jobLauncher;
    private final Job simpleJob;


	public MyBatchScheduler(JobLauncher jobLauncher, Job simpleJob) {
        this.jobLauncher = jobLauncher;
        this.simpleJob = simpleJob;
    }

    // fixedDelay = 5000: 이전 작업 종료 후 5초 뒤 실행
    // cron = "*/5 * * * * *": 5초 주기(0초, 5초, 10초...) 실행
    @Scheduled(fixedDelay = 5000)
    public void runJob() {
        try {
            // [중요] 배치는 동일 파라미터로 성공하면 재실행되지 않음. 
            // 현재 시간을 파라미터로 넣어 매번 새로운 작업으로 인식하게 함.
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(simpleJob, params);
            
        } catch (Exception e) {
            System.out.println("배치 실행 중 에러 발생: " + e.getMessage());
        }
    }
}