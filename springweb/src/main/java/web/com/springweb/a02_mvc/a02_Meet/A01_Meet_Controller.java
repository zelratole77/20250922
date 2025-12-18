package web.com.springweb.a02_mvc.a02_Meet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_Meet_Controller {
	@Autowired(required=false)
	private A02_Meet_Service service;

	// parnterName  location 
	// mlist dateNo parnterName partnerAge  location meetDate
	// http://localhost:5050/meetList
	@RequestMapping("meetList")
	public String meetList(A04Meet sch, Model d) {
		
		d.addAttribute("mlist", service.getBlindDate(sch));
		
		return "a06_meet\\a01_meetList";
	}
	
}
