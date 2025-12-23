

package web.com.springweb.a02_mvc.a01_idol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	// http://localhost:5050/idolGrpDetail GET방식으로 처리
	// 모델이름은 group로 설정..  a03_groupDetail.jsp 화면 호출..
	// http://localhost:5050/idolGrpDetail?groupNo=70
	@GetMapping("idolGrpDetail")
	public String idolGrpDetail(@RequestParam("groupNo") int groupNo, Model d) {
		d.addAttribute("group", service.getIdolGrop(groupNo));
		// ${group.groupNo} ${group.groupName}  ${group.debutDate} ${group.fandomName}
		return "a05_idol\\a03_groupDetail";
	}
	// idolGrpUpdate idolGrpDelete
	// http://localhost:5050/idolGrpUpdate  POST방식으로 처리
	@PostMapping("idolGrpUpdate")
	public String updateGroup(A04Group upt, Model d) {
		d.addAttribute("msg", service.updateGroup(upt));
		// 수정된 이후 내용을 상세화면에서 확인..
		d.addAttribute("group", service.getIdolGrop(upt.getGroupNo()));
		return "a05_idol\\a03_groupDetail";
	}  
	
	// http://localhost:5050/idolGrpDelete  POST방식으로 처리
	@PostMapping("idolGrpDelete")
	public String deleteGroup(@RequestParam("groupNo") int groupNo, Model d) {
		d.addAttribute("msg", service.deleteGroup(groupNo));
		return "a05_idol\\a03_groupDetail";
	}
		

}
