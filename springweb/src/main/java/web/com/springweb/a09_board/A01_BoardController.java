package web.com.springweb.a09_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// a09_board.A01_BoardController
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class A01_BoardController {
	
	@Autowired(required=false)
	private A02_BoardService service;
	
	
	
	// http://localhost:5050/boardList
	@GetMapping("boardList")
	public String boardList() {
		service.call();
		return "a09_board\\a01_boardList";
	}


}
