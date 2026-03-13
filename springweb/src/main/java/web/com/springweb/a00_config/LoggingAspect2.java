package web.com.springweb.a00_config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterThrowing(
			pointcut="execution(* web.com.springweb.a06_ajax_mvc.a01_controller..*(..) ) )", throwing="ex")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("## 예외 발생[controller단] ###");
		System.out.println("클래스/메서드:"+joinPoint.getSignature());
		System.out.println("예외 타입:"+ex.getClass().getName());
		System.out.println("예외 메시지:"+ex.getMessage());
	}
	
}

