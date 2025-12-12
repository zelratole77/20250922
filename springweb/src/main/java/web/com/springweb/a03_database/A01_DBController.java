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
		return "a04_dbexp/a03_getEnamesByDeptno1";
	}
	// http://localhost:5050/getEmpnosByJob?job=SALESMAN
	@GetMapping("getEmpnosByJob")
	public String getEmpnosByJob(@RequestParam(name="job", defaultValue = "") String job,
			 							Model d) {
		d.addAttribute("empnos", service.getEmpnosByJob(job));
		return "a04_dbexp/a04_getEmpnosByJob";
	}	
	// http://localhost:5050/getDept?deptno=10
	@GetMapping("getDept")
	public String getDept(@RequestParam(name="deptno", defaultValue = "0") int deptno,
			 							Model d) {
		d.addAttribute("dept", service.getDept(deptno));
		// 모델명 객체 dept로 설정  new Dept(10,"인사","수원"))
		// view ${dept.deptno} 		${dept.dname} ${dept.loc} 
		//             getDeptno()        .getDname()    .getLoc()
		return "a04_dbexp/a05_getDept";
	}		
	// http://localhost:5050/getHeroList
	@GetMapping("getHeroList")
	public String getHero(@RequestParam(name="name", defaultValue = "") String name,
			 							Model d) {
		d.addAttribute("heros", service.getHero(name)); // 객체형 배열 저장. 모델 ${heros}
		return "a04_dbexp/a06_getHeroList";
	}	
}
