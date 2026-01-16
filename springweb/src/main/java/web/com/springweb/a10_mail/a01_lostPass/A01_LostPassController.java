package web.com.springweb.a10_mail.a01_lostPass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A01_LostPassController {
	
	
	@Autowired(required=false)
	private A02_LostPassService service;
	
	// http://localhost:5050/lostPassLogin
	@GetMapping("lostPassLogin")
	public String lostPassLogin() {
		return "a10_email\\a02_login";
	}
	
	// ajax 처리..
	// http://localhost:5050/lostPassProc?id=himan
	@GetMapping("lostPassProc")
	public ResponseEntity<?> lostPassProc(@RequestParam("id") String id){
		
		return ResponseEntity.ok(service.lostPass(id));
	}

}
