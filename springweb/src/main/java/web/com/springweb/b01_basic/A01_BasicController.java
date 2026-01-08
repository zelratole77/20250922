package web.com.springweb.b01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller   // 받으시 붙여야지 서버안에서 우리 친구야라 인식해서 실행..
public class A01_BasicController {
	// URL을 통한 요청 클라이언트가 서버에 특정 화면을 요청
	// 브라우저에 http://localhost:5050/basic01  
	// 서버단(controller) 안에 메서드 basic01 찾아서
	// 그와 함께 연결되어 있는 뷰단이 jsp를 호추라..
	@GetMapping("basic01")
	public String basic01() {
		return "b01_basic\\a01_basic01";
	}
	/*
	public : 외부어 어는 곳에서든지 이 메서드를 호출할 수 있습니다.
	String : 마지막에 이 함수를 return 곳에 데이터 유형을 문자열을 의미..
				return "";  현재 스프링에서는 주로 jsp를 호출해준다.
	basic01() : 사용자 정의 메서드 이름 - 마음대로 선언해도 된다.	
				하나의 controller 안에는 동일 메서드를 선언하면 안된다.
	return "" : 실제 호출할 화면을 처리..			
	 * 
	 * */
	// ex) http://localhost:5050/basic02
	// webapp\WEB-INF\views\b01_basic\a02_basic02.jsp  안녕하세요 두번째 화면입니다.
	
	
	
}
