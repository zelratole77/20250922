package web.com.springweb.a00_config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect2 {
	@Around("execution(* web.com.springweb.a07_fullcalendar.*Controller.*(..))")
	public Object loginTimming(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();// 해당 시간의 1/1000초 단위 시간
		
		Object proceed = joinPoint.proceed();  // 실행되는 시점에 정보를 가져오는 객체
		
		long end = System.currentTimeMillis();
		System.out.println(joinPoint.getSignature()+
				" 수행시간:"+(end-start)+"밀리 세컨드(ms- 1/1000초)");
		return proceed;
	}

}
// ex) LoggingAspect2,    web.com.springweb.a07_fullcalendar 
// 패키지에 Controller단 처리 수행 시간 처리 확인..
