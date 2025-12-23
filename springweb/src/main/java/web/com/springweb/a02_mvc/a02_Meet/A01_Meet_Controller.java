package web.com.springweb.a02_mvc.a02_Meet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	// http://localhost:5050/meet?dateNo=1
	@GetMapping("meet")
	public String getMeet(@RequestParam("dateNo") int dateNo, Model d) {
		d.addAttribute("meet", service.getMeet(dateNo));
		return "a06_meet\\a03_meetDetail";
	}
	// updateBlindDate deleteBlindDate
	// http://localhost:5050/updateBlindDate
	@PostMapping("updateBlindDate")
	public String updateBlindDate(A04Meet upt, Model d) {
		d.addAttribute("msg", service.updateBlindDate(upt));
		d.addAttribute("meet", service.getMeet(upt.getDateNo()));
		return "a06_meet\\a03_meetDetail";
	}
	// http://localhost:5050/deleteBlindDate?dateNo=1
	@PostMapping("deleteBlindDate")	
	public String deleteBlindDate( @RequestParam("dateNo") int dateNo, Model d) {
		d.addAttribute("msg", service.deleteBlindDate(dateNo));
		
		return "a06_meet\\a03_meetDetail";
	}	
	
}
