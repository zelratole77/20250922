package web.com.springweb.a00_config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	// 특정 시점에 수행할 Advice 객체 선언 내용
	// 특정한 서버스패키지하위 수행되는 객체의 메서드가 수행되면 수행될 시간을 출력
	// * 접근 제어자 상관없이
	// web.com.springweb.a06_ajax_mvc.a02_service : 해당 패키지
	// .*.*(..) : 하위있는 객체만 있는 메서드 - 해당 이름 상관없이
	// (..) : 매개변수 상관없이..  --시점을 지정 Pointcut
	@Around("execution(* web.com.springweb.a06_ajax_mvc.a02_service.*.*(..))")
	public Object loginTimming(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();// 해당 시간의 1/1000초 단위 시간
		
		Object proceed = joinPoint.proceed();  // 실행되는 시점에 정보를 가져오는 객체
		
		long end = System.currentTimeMillis();
		System.out.println(joinPoint.getSignature()+
				" 수행시간:"+(end-start)+"밀리 세컨드(ms- 1/1000초)");
		return proceed;
	}

}
