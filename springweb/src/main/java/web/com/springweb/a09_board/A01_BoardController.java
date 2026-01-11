package web.com.springweb.a09_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class A01_BoardController {
	
	@Autowired(required=false)
	private A02_BoardService service;
	
	
	
	// http://localhost:5050/boardList?writer=홍&subject=공지
	@RequestMapping("boardList")   // get/post
	public String boardList(Board b01, Model d) {
		d.addAttribute("boardList", service.boardList(b01));
		return "a09_board\\a01_boardList";
	}
	// http://localhost:5050/boardInsert
	@RequestMapping("boardInsert")
	public String boardInsert(Board ins, Model d) {
		if(ins.getSubject()!=null) {
			d.addAttribute("msg", service.boardInsert(ins));
		}
		return "a09_board\\a02_boardInsert";
	}
	


}
