package web.com.springweb.a02_mvc.a01_idol;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_Idol_Controller {
	
	
	// http://localhost:5050/idolGrpList  요청값 아에 없는 것(초기화면 - get방식으로 처리될 때)
	//       	A04Group가 생성될 때.  groupName fandomName ?  null, null
	// http://localhost:5050/idolGrpList?
	//      groupName=A&fandomName=B      요청값 form의 의해서 전달될 - post방식으로 처리될 때
	//          	               groupName A  fandomName B
	@RequestMapping("idolGrpList")
	public String idolGrpList(A04Group sch, Model d) {
		
		
		
		return "a05_idol/a01_groupList";
	}

}
