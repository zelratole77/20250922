package web.com.springweb.a10_mail.a01_lostPass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_LostPassController {
	
	// http://localhost:5050/lostPassLogin
	@GetMapping("lostPassLogin")
	public String lostPassLogin() {
		return "a10_email\\a02_login";
	}

}
