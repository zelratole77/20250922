package web.com.springweb.a02_mvc.a01_idol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_Idol_Controller {
	
	@Autowired(required=false)
	private A02_Idol_Service service;
	
	// http://localhost:5050/idolGrpList  요청값 아에 없는 것(초기화면 - get방식으로 처리될 때)
	//       	A04Group가 생성될 때.  groupName fandomName ?  null, null
	// http://localhost:5050/idolGrpList?
	//      groupName=A&fandomName=B      요청값 form의 의해서 전달될 - post방식으로 처리될 때
	//          	               groupName A  fandomName B
	@RequestMapping("idolGrpList")
	public String idolGrpList(A04Group sch, Model d) {
		// 화면에 전달할 핵심 데이터 모델데이터는 요청값을 던지고(sch), 리턴값으로 DB처리된 결과 객체를 설정되어 있음..
		d.addAttribute("grpList", service.getIdolGrpList(sch));
		
		return "a05_idol/a01_groupList";
	}
	// http://localhost:5050/idolGrpInsert   GET 방식으로 등록 화면 로딩
	@GetMapping("idolGrpInsert")
	public String idolGrpInsertGet() {
		return "a05_idol\\a02_groupInsert";
	}
	
	@PostMapping("idolGrpInsert")
	public String idolGrpInsertPost(A04Group ins, Model d) {
		
		d.addAttribute("msg", service.insertIdoGrp(ins));
		
		return "a05_idol\\a02_groupInsert";
	}	

}
