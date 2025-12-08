package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class A03_ReqController {

	// http://localhost:5050/req01
	// get방식으로 특정한 jsp 호출
	@GetMapping("req01")
	public String req01() {
		
		return "a01_req\\a01_request";
	}
	// http://localhost:5050/req02
	@GetMapping("req02")
	public String req02() {
		return "a01_req\\a02_reqExp";
	}
	// http://localhost:5050/req03
	@GetMapping("req03")
	public String req03() {
		System.out.println("# get 방식 호출 #");
		return "a01_req\\a03_reqPost";
	}	
	// http://localhost:5050/req03
	@PostMapping("req03")
	public String req03Post() {
		
		System.out.println("# post 방식 호출 #");
		return "a01_req\\a03_reqPost";
	}		
	// ex) http://localhost:5050/req04
	//     get방식과 post 방식으로 a04_reqPost.jsp로 호출되게 하세요..
	// a01_req\a04_reqPost
	// http://localhost:5050/req04
	@GetMapping("req04")
	public String req04() {
		System.out.println("# get 방식 호출 a04_reqPost#");
		return "a01_req\\a04_reqPost";
	}	
	// http://localhost:5050/req04
	@PostMapping("req04")
	public String req04Post() {
		
		System.out.println("# post 방식 호출 a04_reqPost#");
		return "a01_req\\a04_reqPost";
	}	
	// http://localhost:5050/req05
	@PostMapping("req05")
	public String req05Post() {
		
		System.out.println("# post 방식 호출 action req05  a04_reqPost#");
		return "a01_req\\a04_reqPost";
	}		
	// http://localhost:5050/req06   - get 방식을 a05_reqPost.jsp
	// get방식 : url 주소  form method값이 없을 때, form method="get"
	@GetMapping("req06")
	public String req06Get() {
		System.out.println("req06으로 GET방식 호출");
		return "a01_req\\a06_req";
	}
	
	
	// http://localhost:5050/req06   - post 방식 a05_reqPost.jsp
	@PostMapping("req06")
	public String req06Post() {
		System.out.println("req06으로 Post방식 호출");
		return "a01_req\\a06_req";
	}	
	// http://localhost:5050/req07   - post 방식 a05_reqPost.jsp
	@PostMapping("req07")
	public String req07Post() {
		System.out.println("req07으로 Post방식 호출");
		return "a01_req\\a06_req";
	}		
	
}
