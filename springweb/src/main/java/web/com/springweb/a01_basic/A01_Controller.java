package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



// ctrl + shift + o : import
@Controller
public class A01_Controller {

	// MVC : 개발 패턴...(Model/Controller/View)
	// Controller/View 
	// http://localhost:5050/start
	// url을 통해서 controller에 특정한 view(jsp-화면단)를 호출하게
	@GetMapping("start")
	public String start() {
		
		return "call.jsp";
	}
	//ex) A02_Controller.java
	///  http://localhost:5050/second
	//
	// webapp/call02.jsp 두번째 스프링..
	
	
	
	
}
