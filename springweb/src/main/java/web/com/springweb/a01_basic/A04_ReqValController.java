package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A04_ReqValController {
	
	// http://localhost:5050/req10_one
	@GetMapping("req10_one")
	public String getShow() {
		return "a02_req\\a01_req_one";  // a01_req_one.jsp
		
	}
}
