package a01_diexp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import a01_diexp.vo.Pet;
import a01_diexp.vo.PetOwner;

@Configuration
public class Config13 {
//컨테이너를 만든 스프링을 웹에서 계속 수행 작업을 하는 것을
// 가상으로 만들어 테스트 환경을 설정...
// 여기에 선언된 객체들은 호출하는 컨테이너에 할당이 되어 사용되어 진다.
	// 컨터에너 안에 하나의 객체 할당.
	@Bean    // 기본적으로 메서드 이름으로 bean이름이 default 설정이 된다.
	public Object obj() {
		return new Object();
	}
	
	@Bean("pet01")
	public Pet getPet() {
		return new Pet("멍멍이");
	}
	
	@Bean
	public PetOwner getPetOwner() {
		return new PetOwner("홍길동", 25);
	}	
	
}
