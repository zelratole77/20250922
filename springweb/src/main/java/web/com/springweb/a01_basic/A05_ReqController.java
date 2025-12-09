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
	@RequestMapping("reqParamOpt")
	public String reqParamOpt(@RequestParam(name = "product", defaultValue = "") String name,
							  @RequestParam(name = "price", defaultValue = "0") int price	
			                  ) {
		System.out.println("구매할 물건 :"+name);
		System.out.println("구매할 물건 가격 :"+price);
		return "a02_req/a06_reqParamOpt";
	}	
	
}
