package web.com.springweb.a06_ajax_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.com.springweb.a06_ajax_mvc.a02_service.A02_GourmetService;
import web.com.springweb.a06_ajax_mvc.dto.GourmetStore;

@Controller
public class A01_GourmetController {
	@Autowired(required=false)
	private A02_GourmetService service;
	
	//	http://localhost:5050/gourmetMngView (초기view단 호출)
	@GetMapping("gourmetMngView")
	public String gourmetMngView() {
		return "a08_ajax\\a06_gourmetMng";
	}
	
	//	http://localhost:5050/gourmetList  (ajax)
	@GetMapping("gourmetList")
	public ResponseEntity<?> gourmetList(GourmetStore sch){
		return ResponseEntity.ok(service.getGourmetList(sch));
	}	
}
