package web.com.springweb.a05_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A03_AjaxDBController {
	
	@Autowired(required=false)
	private A04_AjaxDBService service;

	// http://localhost:5050/deptAjaxCallView
	@GetMapping("deptAjaxCallView")
	public String deptAjaxCallView() {
		return "a08_ajax\\a03_deptView";
	}
	// http://localhost:5050/deptAjax?deptno=10
	@GetMapping("deptAjax")
	public ResponseEntity<?> deptAjax(@RequestParam("deptno") int deptno){
		return ResponseEntity.ok(service.getDept(deptno));
	}
	// http://localhost:5050/registerMemberView
	@GetMapping("registerMemberView")
	public String registerMemberView() {
		return "a08_ajax\\a04_registerMember";
	}
	
	
}
