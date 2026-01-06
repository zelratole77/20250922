package web.com.springweb.a06_ajax_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.com.springweb.a06_ajax_mvc.a02_service.A02_LunchMenuService;
import web.com.springweb.a06_ajax_mvc.dto.GourmetStore;
import web.com.springweb.a06_ajax_mvc.dto.LunchMenu;

@Controller
public class A02_LunchMenuController {

	@Autowired(required=false)
	private A02_LunchMenuService service;
	
	// http://localhost:5050/lunchView
	@GetMapping("lunchView")
	public String lunchView() {
		return "a08_ajax\\a07_lunchMng";
	}
	// http://localhost:5050/lunchMenuList
	@GetMapping("lunchMenuList")
	public ResponseEntity<?> lunchMenuList(LunchMenu sch){
		
		return ResponseEntity.ok(service.lunchMenuList(sch));
	}
	
	// http://localhost:5050/insertLunchMenu
	@PostMapping("insertLunchMenu")
	@ResponseBody
	public String insertGourmet(LunchMenu ins) {
		return service.insertLunchMenu(ins);
	}	
	// http://localhost:5050/getLunchMenu?menuId=1
	@GetMapping("getLunchMenu")
	public ResponseEntity<?> getLunchMenu(@RequestParam("menuId") int menuId){
		return ResponseEntity.ok(service.getLunchMenu(menuId));
	}			
	// 	http://localhost:5050/updateLunchMenu
	@PutMapping("updateLunchMenu")
	@ResponseBody
	public String updateLunchMenu(@RequestBody LunchMenu upt ) { // json 문자열을 요청값으로 처리할 때,
		return service.updateLunchMenu(upt);
	}
	
	//  http://localhost:5050/deleteLunchMenu
	@DeleteMapping("deleteLunchMenu")
	@ResponseBody
	public String deleteLunchMenu(@RequestParam("menuId") int menuId) { // json 문자열을 요청값으로 처리할 때,
		return service.deleteLunchMenu(menuId);
	}				
}
