package web.com.springweb.a05_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A02_AjaxController {

	// http://localhost:5050/callReqInit
	@GetMapping("callReqInit")
	public String callReqInit() {
		return "a08_ajax\\a02_ajaxReqView";
	}
}
