package web.com.springweb.a10_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_MailController {
	@Autowired(required=false)
	private A02_MailService service;
	
	// 발신자는 기본적으로 계정으로 처리..
	@Value("${spring.mail.username}")
	private String username;
	
	// http://localhost:5050/sendMail
	@RequestMapping("sendMail")
	public String sendMail(MailDto email, Model d) {
		if(email.getTitle()!=null) {
			d.addAttribute("msg", service.sendMail(email));
		}
		d.addAttribute("sender", username);
		return "a10_email/a01_sendMail";
	}
	
}
