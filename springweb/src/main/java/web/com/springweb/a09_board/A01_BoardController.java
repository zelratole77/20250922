package web.com.springweb.a09_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class A01_BoardController {
	
	@Autowired(required=false)
	private A02_BoardService service;
	
	
	
	// http://localhost:5050/boardList
	@RequestMapping("boardList")   // get/post
	public String boardList(Board sch, Model d) {
		d.addAttribute("boardList", service.boardList(sch));
		return "a09_board\\a01_boardList";
	}


}
