package web.com.springweb.a05_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/*
			/isValidId?id=himan
			isValidId()
	*/
	// http://localhost:5050/isValidId?id=himan
	@GetMapping("isValidId")
	@ResponseBody
	public String isValidId(@RequestParam("id") String id ){
		System.out.println("id:"+id);
		
		return service.isValidId(id);
	}
//	http://localhost:5050/idoleView  초기 화면 ( a05_idoleInfo.jsp )
	@GetMapping("idoleView")
	public String idoleView() {
		return "a08_ajax\\a05_idoleInfo";
	}
//	http://localhost:5050/idoleInfo?groupId=101
//	 	idolInfo()
	@GetMapping("idoleInfo")
	public ResponseEntity<?> idolInfo(@RequestParam("groupId") int groupId){
		return ResponseEntity.ok(service.idolInfo(groupId));
	}	
	

}
