package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A04_ReqValController {
	// http://localhost:5050/req10
	@GetMapping("req10")
	public String getSh() {
		return "a02_req\\a01_req_one";  // a01_req_one.jsp
	}
	// http://localhost:5050/req10_one
	// name홍길동으로 처리 요청 형식(client에서)
	// 1) http://localhost:5050/req10_one?name=홍길동
	// 2) <form action값 ="req10_one"/method 생략
	//      	<input name="name">
	// 3) <form action값 ="req10_one"/method ="get"명시
	//      	<input name="name">	
	@GetMapping("req10_one")
	public String getShow(@RequestParam("name") String name) {
		System.out.println("이름:"+name);
		return "a02_req\\a01_req_one";  // a01_req_one.jsp
		
	}
	// req11 ==> 초기 페이지 a02_req\\a02_req_one.jsp
	// http://localhost:5050/req11
	@GetMapping("req11")
	public String req11() {
		return "a02_req\\a02_req_one";
	}
	// req11_one ==> prodName=사과 전송해서 get방식으로 요청하고 출력되게 하세요..
	// url이나 client에서 결국은 처리해주는 내용
	// http://localhost:5050/req11_one ==> 안된다(x)  왜?
	// http://localhost:5050/req11_one?prodName=사과
	@GetMapping("req11_one")
	public String req11_one(@RequestParam("prodName") String prodName) { // 요청key=val형태가 필수..
		System.out.println("get방식으로  받은 물건명:"+prodName);
		
		return "a02_req\\a02_req_one";
	}
	
	
	
}
