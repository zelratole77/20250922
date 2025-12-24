package a01_diexp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import a01_diexp.vo.Student;
import a01_diexp.vo.StudentCard;

@Configuration
public class Config12 {
//컨테이너를 만든 스프링을 웹에서 계속 수행 작업을 하는 것을
// 가상으로 만들어 테스트 환경을 설정...
// 여기에 선언된 객체들은 호출하는 컨테이너에 할당이 되어 사용되어 진다.
	// 컨터에너 안에 하나의 객체 할당.
	@Bean    // 기본적으로 메서드 이름으로 bean이름이 default 설정이 된다.
	public Object obj() {
		return new Object();
	}
	// 컨테이너 안에 bean 객체 생성
	@Bean    
	public StudentCard studentCard() {
		return new StudentCard("QA244211");
	}
	
	@Bean
	public Student student() {
		
		return new Student("홍길동 학생");
	}
	// 컨터이너 안에서 객체안에 객체가 할당되는 내용..
	@Bean
	public Student cardStudent() {
		Student stu = new Student("마길동");
		stu.setCard(new StudentCard("QB251224"));
		return stu;
	}
	
}
