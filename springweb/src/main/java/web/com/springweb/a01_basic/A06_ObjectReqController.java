package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import web.com.springweb.z01_dto.Person;

@Controller
public class A06_ObjectReqController {
	// http://localhost:5050/objectParam1
	// http://localhost:5050/objectParam1?name=홍길동
	// http://localhost:5050/objectParam1?age=25
	// http://localhost:5050/objectParam1?name=마길동&age=27&loc=서울 (o)
	// "27" ==> 27 ==> setAge(int age)
	// http://localhost:5050/objectParam1?name=마길동&age=&loc=서울 (x)
	// ""  ==> setAge(int age)   int age = "";(x)
	// http://localhost:5050/objectParam1?name=25&age=25&loc=서울 (o)
	// "25" ==> setName(String name) String name="25";
	@GetMapping("objectParam1")
	public String objectParam1(Person p) {
		System.out.println("# controller 요청 데이터 #");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getLoc());
		
		return "a02_req/a08_ObjectParam";
	}
	// http://localhost:5050/neonSign 
	// 웹 페이지의 글자 색상과 배경 색상을 사용하여 화면에 반영하는 내용을 처리하세요
	// 입력항목 : 문구(어서오세요?반값습니다),  글자 색상(색상명), 글자 크기(숫자만 입력)
	// a02_req/a09_neonSign.jsp;   // 요청값을 입력하고, 모델 데이터로 출력하게 하세요..
	
}


/*
# 객체로 요청값 처리
1. 스프링에서는 미리 요청값을 처리한 속성과 데이터 유형을 정리하여, 상자(객체DTO)를 
	준비해놓으면, 해당 요청값과 타입이 맞으로 알아서 해당 데이터를 저장하여 전달하고,
	해당 데이터를 backend단에서 처리하여 활용할 수 있다.
	- 스프링의 방식(객체 바인딩) : 미리 회원정보라는 상자(객체DTO)를 준비해 둡니다.
	스프링이라는 유능한 이사짐 센터 직원은 밖에서 들어오는 짐(요청 파라미터)의 이름표를
	보고, 알아서 딱 맞는 상자에 쏙쏙 정리해 담아줍니다. 사장님!! 회원정보 상자에 다
	담아놨으니 이 상자 하나만 가져다 쓰세요!!
2. 핵심 개념 : 요청 파라미터(name, age)의 이름과, 자바 객체(DTO)의 필드 이름과
	같으면 스프링이 Setter 메서드를 사용해 자동으로 값을 채워주는 기능입니다. 이를 
	커맨더 객체(Command Object)라고 부릅니다.
3. S.P.A원칙
	1) S - Setter(세터)
		상자에 구멍이 뚫려 있어야 물건을 넣죠? 객체에 값을 넣으려면 setXXXX()
		메서드가 반드시 있어야 한디다.
	2) P - Parameter Name(파라미터 이름)
		html form의 name="id"와 DTO 객체의 메서드의 setXXX()의 property가 같아야 합니다.
		ps) set property   public void setId(String id) 의 property는 id이죠... 
		이 form의 name에 있는 id와 set property의 id가 동일해야 합니다..
	3) A - Automatic(자동 할당 처리)
		스프링은 이 객체를 만들기 위해 기본 생성자를 사용해서 빈 깡통 객체를 먼저 만들고 시작합니다.
		(기본 생성자가 없으면 에러 날 수 있으니 주의)..
4. 장점
	1) 많은 요청 매개변수를 선언하지 않아도 된다. 객체 하나로 많을 요청값을 받은 객체로 전달 된다.
	2) 만일 요청값 없더라도 default로 처리된다. 단, 요청값이 선언되면 유형을 맞춰서 전달 하여야 한다.
		?age=25  (o)
		?age=0   (o)
		?name=홍길동 (o)
		?age=이십오 (x)
		public void setAge(int age)
	3) 객체로 받은 모델데이터까지 자동을 설정된다..
		?name=홍길동&age=25&loc=수원
		getPerson(Person p){  // 요청값 Person객체에 데이터를 할당할 뿐아니라, 모델데이터가 자동 처리되어
			// Model d   d.addAttribute("person", p) Person==> person 자동으로 모델객체 설정..(이 코드가 생략)
		}`
		view단에서 ${person.name}${person.age}${person.loc} 로 출력할 수 있다.
		
*/
