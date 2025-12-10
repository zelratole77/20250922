package web.com.springweb.a03_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_DBController {
	@Autowired(required=false)
	private A02_DBService service;
	
	// http://localhost:5050/dbexp01
	@GetMapping("dbexp01")
	public String dbexp01() {
		return "a04_dbexp/a01_exp01";
	}
	
}
