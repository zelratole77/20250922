package web.com.springweb.a03_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A01_DBController {
	@Autowired(required=false)
	private A02_DBService service;
	
	// http://localhost:5050/dbexp01
	@GetMapping("dbexp01")
	public String dbexp01(Model d) {
		// 서비스단을 호출하여 해당 메서드에서 리턴한 결과를 모델 데이터로
		// 저장.
		//d.addAttribute("empCnt", service.getCountEmp());
		service.dbexp();
		
		return "a04_dbexp/a01_exp01";
	}
	// http://localhost:5050/empCntBydeptno
	// http://localhost:5050/empCntBydeptno?deptno=10
	@GetMapping("empCntBydeptno")
	public String empCntBydeptno(@RequestParam(name="deptno", defaultValue = "0") int deptno,
								 Model d) {
		d.addAttribute("deptCnt", service.getCountByDeptno(deptno));
		
		return "a04_dbexp/a02_empCntBydeptno";
	}	
	// http://localhost:5050/getEnamesByDeptno1?deptno=10
	@GetMapping("getEnamesByDeptno1")
	public String getEnamesByDeptno1(@RequestParam(name="deptno", defaultValue = "0") int deptno,
			 							Model d) {
		d.addAttribute("dnames", service.getEnamesByDeptno1(deptno));
		return "a04_dbexp/a03getEnamesByDeptno1";
	}
	
}
