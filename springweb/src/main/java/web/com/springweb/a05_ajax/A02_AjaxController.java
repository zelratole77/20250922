package web.com.springweb.a05_ajax;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.com.springweb.z01_dto.Person;
import web.com.springweb.z01_dto.Student;

@Controller
public class A02_AjaxController {

	// http://localhost:5050/callReqInit
	@GetMapping("callReqInit")
	public String callReqInit() {
		return "a08_ajax\\a02_ajaxReqView";
	}
	// http://localhost:5050/callReqAjax01?name=홍길동
	@GetMapping("callReqAjax01")
	@ResponseBody
	public String callReqAjax01(@RequestParam("name") String name) {
		String msg=name+" 안녕하세요!!";
		return msg;
	}
	// http://localhost:5050/callReqAjax02?price=3000&cnt=5
	@GetMapping("callReqAjax02")
	@ResponseBody
	public String callReqAjax02(@RequestParam("price") int price, @RequestParam("cnt") int cnt ) {
		String msg="구매 가격은 "+price+"원 이고, 구매 갯수는 "+cnt+"개, 총계는 "+(price*cnt)+"원 입니다.";
		return msg;
	}	
	// class형 객체를 json형태로 처리하기
	// http://localhost:5050/callObjAjax01
	@GetMapping("callObjAjax01")
	public ResponseEntity<?> callObjAjax01(){
		return ResponseEntity.ok(new Person("홍길동",25,"수원"));
	}
	// http://localhost:5050/callObjAjax02
	// Student 설정  {"name":"홍길동", "kor":70,"eng":80,"math":50}
	@GetMapping("callObjAjax02")
	public ResponseEntity<?> callObjAjax02(){
		return ResponseEntity.ok(new Student("홍길동",70,80,50));
		// ResponseEntity.ok(java객체) ==> json 문자열로 변환..
		// [{},{},....]
		// ResponseEntity<Student> : ok 매개변수에 특정한 객체 유형을 지정하거나, 
		// ResponseEntity<?> :  또는 각 객체유형에 따라 적절하게 처리 하는 것(?)을 의미한다.
	}
	
	
	
	
	
	
	
}
