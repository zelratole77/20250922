package web.com.springweb.a06_ajax_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.com.springweb.a06_ajax_mvc.a02_service.A01_GourmetService;
import web.com.springweb.a06_ajax_mvc.dto.GourmetStore;

@Controller
public class A01_GourmetController {
	@Autowired(required=false)
	private A01_GourmetService service;
	
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
	// http://localhost:5050/insertGourmet
	@PostMapping("insertGourmet")
	@ResponseBody
	public String insertGourmet(GourmetStore ins) {
		return service.insertGourmet(ins);
	}
	// http://localhost:5050/getGourmet?id=1
	@GetMapping("getGourmet")
	public ResponseEntity<?> getGourmet(@RequestParam("id") int id){
		return ResponseEntity.ok(service.getGourmet(id));
	}
	
	
	
}
