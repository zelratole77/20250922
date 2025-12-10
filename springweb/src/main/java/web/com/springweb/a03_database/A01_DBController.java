package web.com.springweb.a03_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_DBController {
	@Autowired(required=false)
	private A02_DBService service;
	
	// http://localhost:5050/dbexp01
	@GetMapping("dbexp01")
	public String dbexp01(Model d) {
		// 서비스단을 호출하여 해당 메서드에서 리턴한 결과를 모델 데이터로
		// 저장.
		d.addAttribute("empCnt", service.getCountEmp());
		
		return "a04_dbexp/a01_exp01";
	}
	
}
