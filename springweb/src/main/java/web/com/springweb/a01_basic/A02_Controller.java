package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A02_Controller {

	//  http://localhost:5050/second
	@GetMapping("second")
	public String second() {
		return "call02.jsp";
	}
}
