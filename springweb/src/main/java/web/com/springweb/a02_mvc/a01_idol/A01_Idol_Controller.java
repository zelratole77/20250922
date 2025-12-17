package web.com.springweb.a02_mvc.a01_idol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_Idol_Controller {
	
	
	// http://localhost:5050/idolGrpList  a01_groupList.jsp
	@RequestMapping("idolGrpList")
	public String idolGrpList() {
		return "a05_idol/a01_groupList";
	}

}
