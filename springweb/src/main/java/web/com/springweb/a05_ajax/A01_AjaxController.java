package web.com.springweb.a05_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class A01_AjaxController {
	// http://localhost:5050/startAjax
	@GetMapping("startAjax")
	public String startAjax() {
		return "a08_ajax/a01_ajaxView";
	}
	//  http://localhost:5050/callAjax01
	@GetMapping("callAjax01")
	@ResponseBody
	public String callAjax01() {
		return "안녕하세요!! 문자열 ajax 호출!!";
	}
	// http://localhost:5050/callAjax02
	@GetMapping("callAjax02")
	@ResponseBody
	public String callAjax02() {
		return "ajax 기초는 할만 한가요?";
	}
	
	
}
