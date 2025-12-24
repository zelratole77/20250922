package a01_diexp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import a01_diexp.vo.Person;
import a01_diexp.vo.Product;

@Configuration
public class Config11 {
//컨테이너를 만든 스프링을 웹에서 계속 수행 작업을 하는 것을
// 가상으로 만들어 테스트 환경을 설정...
// 여기에 선언된 객체들은 호출하는 컨테이너에 할당이 되어 사용되어 진다.
	// 컨터에너 안에 하나의 객체 할당.
	@Bean    // 기본적으로 메서드 이름으로 bean이름이 default 설정이 된다.
	public Object obj() {
		return new Object();
	}
	
	@Bean
	public Person p01() {   // 메서드명 bean으로 설정   p01
		return new Person("홍길동",25,"수원");
	}
	// vo Product 물건명/가격/갯수 설정하고, prod01로 선언하고 
	// Diexp11애서 호출 처리..
	@Bean
	public Product pro01() {
		return new Product("사과",3000,2);
	}
}
