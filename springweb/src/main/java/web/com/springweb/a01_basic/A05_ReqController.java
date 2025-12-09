package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A05_ReqController {
	// get/post방식 둘다 처리하는 요청 처리 메서드 선언
	// http://localhost:5050/reqGetPost
	@RequestMapping("reqGetPost")
	public String reqGetPost() {
		System.out.println("요청처리 get/post 둘다 한꺼번에 처리");
		return "a02_req/a04_requestGetPost";
	}
	// http://localhost:5050/reqGetPost2
	// a02_req/a05_requestGetPost.jsp 처리 해주세요..
	@RequestMapping("reqGetPost2")
	public String reqGetPost2() {
		return "a02_req/a05_requestGetPost";
	}
	// 요청값을 받을 때, 요청값이 없을 처리되는 메서드 선언..
	// http://localhost:5050/reqParamOpt  	
	// http://localhost:5050/reqParamOpt?product=사과&price=4000
	// 요청값이 없을 때나 있을 때, 둘다 처리.. 요청값이 없으면 공백으로 처리..
	// RequestParam("name") RequestParam(name="name")  ==> name=홍길동  즉 요청 키가 name인 것을 말한다.
	@RequestMapping("reqParamOpt")
	public String reqParamOpt(@RequestParam(name = "product", defaultValue = "") String product,
							  @RequestParam(name = "price", defaultValue = "0") int price	
			                  ) {
		System.out.println("구매할 물건 :"+product);
		System.out.println("구매할 물건 가격 :"+price);
		return "a02_req/a06_reqParamOpt";
	}	
	// http://localhost:5050/calSalary  
	// a02_req/a07_calcuSalary.jsp
	// 알바 급여 계산기
	// 이름 :[   ] 시급:[    ] 근무 시간:[    ] [계산]
	// @@@는 시간당 @@@원, 근무시간은 @@시간 총급여 @@@원 입니다. 출력..
	@RequestMapping("calSalary")
	public String calSalary(@RequestParam(name="name", defaultValue = "") String name,
							@RequestParam(name="pay", defaultValue = "0") int pay,
							@RequestParam(name="whour", defaultValue = "0") int whour ) {
		System.out.println("근무자 명:"+name);
		System.out.println("급여:"+pay);
		System.out.println("근무시작:"+whour);
		return "a02_req/a07_calcuSalary";
	}
	
	
	
}
