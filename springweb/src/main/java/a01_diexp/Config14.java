package a01_diexp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// 특정한 패키지 기준으로 하위에 있는 모든 annotation 객체를 인식하게 설정..
// 아래 패키지에 있는 모든 클래스는 @Component, @Controller, @Service, @Mapper 포함
// 컨테이나 안에 객체로 생성 ( tomcat이 실행되고 처름 초기 화면이 로딩될 때, 처리된다.)
@Configuration
@ComponentScan(basePackages =  "a01_diexp.vo2")
public class Config14 {
//컨테이너를 만든 스프링을 웹에서 계속 수행 작업을 하는 것을
// 가상으로 만들어 테스트 환경을 설정...
// 여기에 선언된 객체들은 호출하는 컨테이너에 할당이 되어 사용되어 진다.
	// 컨터에너 안에 하나의 객체 할당.
	@Bean    // 기본적으로 메서드 이름으로 bean이름이 default 설정이 된다.
	public Object obj() {
		return new Object();
	}
	// 여기에 설정하지 않더라도, 컨테이너 안에 객체가 생성됨..
	
}
