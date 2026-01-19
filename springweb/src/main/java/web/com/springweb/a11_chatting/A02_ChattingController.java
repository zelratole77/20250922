package web.com.springweb.a11_chatting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A02_ChattingController {
	
	// 접속정보 가져오기
	@Value("${socketServer}")
	private String socketServer;
	

	// http://localhost:5050/chatting
	@GetMapping("chatting")
	public String chatting(Model d) {
		d.addAttribute("socketServer", socketServer);
		
		return "a11_chatting/a01_chatting";
	}
}
