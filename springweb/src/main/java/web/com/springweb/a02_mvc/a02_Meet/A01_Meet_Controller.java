package web.com.springweb.a02_mvc.a02_Meet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_Meet_Controller {

	// parnterName  location 
	// dateNo parnterName partnerAge  location meetDate
	// http://localhost:5050/meetList
	@RequestMapping("meetList")
	public String meetList(A04Meet sch, Model d) {
		
		return "a06_meet\\a01_meetList";
	}
	
}
