package web.com.springweb.a05_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_AjaxController {
	// http://localhost:5050/startAjax
	@GetMapping("startAjax")
	public String startAjax() {
		return "a08_ajax/a01_ajaxView";
	}
}
