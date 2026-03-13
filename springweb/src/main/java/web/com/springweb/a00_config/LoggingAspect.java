package web.com.springweb.a00_config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
	// 특정한 패키지의 하위에 있는 모든 메서드에서 에러가 발생시 처리할 내용을 구현
	// execution(* web.com.springweb..service..*(..))
	// execution(* web.com.springweb..*Dao..*(..))
	@AfterThrowing(
			pointcut="execution(* web.com.springweb..service..*(..) ) || "
					+ "execution(* web.com.springweb..*Dao..*(..) )", throwing="ex")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("## 예외 발생 ###");
		System.out.println("클래스/메서드:"+joinPoint.getSignature());
		System.out.println("예외 타입:"+ex.getClass().getName());
		System.out.println("예외 메시지:"+ex.getMessage());
	}
	@Around("execution(* web.com.springweb..service..*(..) ) || "
	        + "execution(* web.com.springweb..*Dao..*(..) )")
	public Object handleAndLogException(ProceedingJoinPoint joinPoint) throws Throwable {
	    try {
	        // 원래 메서드 실행
	        return joinPoint.proceed();
	    } catch (Throwable ex) {
	        // 1. 에러 로깅 (기존 @AfterThrowing 로직)
	        System.out.println("## 예외 발생 (가로채기 완료) ###");
	        System.out.println("클래스/메서드:" + joinPoint.getSignature());
	        System.out.println("예외 타입:" + ex.getClass().getName());
	        System.out.println("예외 메시지:" + ex.getMessage());

	        // 2. 정상적인 흐름으로 복구하기 위해 빈 데이터 반환
	        // 리턴 타입에 따라 적절한 값 반환 (List면 빈 리스트, 객체면 null 등)
	        return null; 
	    }
	}
	
	
	// ex) LoggingAspect2 클래스 안에
	//     web.com.springweb.a06_ajax_mvc.a01_controller 패키지 안에
	//     특정한 예외 사항이 발생하면 처리되게 하세요..
	
}




