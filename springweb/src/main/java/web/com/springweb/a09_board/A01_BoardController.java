package web.com.springweb.a09_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class A01_BoardController {
	
	@Autowired(required=false)
	private A02_BoardService service;
	
	
	

	
	
	
	// http://localhost:5050/boardList
	@RequestMapping("boardList")   // get/post
	public String boardList(Board b01, Model d) {
		d.addAttribute("boardList", service.boardList(b01));
		return "a09_board\\a01_boardList";
	}
	// http://localhost:5050/boardInsert
	// refno=0&subject=게시물등록&content=내용&writer=홍길동
	// RequestMapping : GET/POST
	@RequestMapping("boardInsert")
	public String boardInsert(Board ins, Model d) {
		if(ins.getSubject()!=null) { // 초기화면에서는 해당 프로세스 x
			d.addAttribute("msg", service.boardInsert(ins));
		}
		return "a09_board\\a02_boardInsert";
	}
	// http://localhost:5050/boardDetail?no=8
	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam("no") int no, Model d) {
		// 기본 정보	
		d.addAttribute("board", service.boardDetail(no));
		
		return "a09_board\\a03_boardDetail";
	}		
	// http://localhost:5050/boardUpdate
	@PostMapping("boardUpdate")
	public String boardUpdate(Board upt,  Model d) {
		d.addAttribute("msg", service.boardUpdate(upt)); // 세션을 통해 일회성으로 msg 전달
		d.addAttribute("board", service.getBoard(upt.getNo()));
		return "a09_board\\a03_boardDetail";
	}	
	// http://localhost:5050/boardDelete
	@PostMapping("boardDelete")
	public String boardDelete(@RequestParam("no") int no, Model d) {
		d.addAttribute("msg", service.boardDelete(no)); // 세션을 통해 일회성으로 msg 전달

		return "a09_board\\a03_boardDetail";
	}		
	// http://localhost:5050/boardMng
	@GetMapping("boardMng")   // get
	public String boardMng() {
		return "a09_board\\b01_boardMng";
	}
	// http://localhost:5050/boardListAjax  ?writer=홍&subject=공지
	@GetMapping("/boardListAjax")   // get/post
	public ResponseEntity<?> boardListAjax(Board sch) {
		
		return ResponseEntity.ok(service.boardList(sch));
	}	
	// http://localhost:5050/boardInsertAjax
	@PostMapping("/boardInsertAjax")
	public ResponseEntity<?> boardInsertAjax(Board ins) {
		return ResponseEntity.ok(service.boardInsert(ins)); // 
	}
	// http://localhost:5050/boardDetailAjax?no=82
	@GetMapping("/boardDetailAjax")
	public ResponseEntity<?> boardDetailAjax(@RequestParam("no") int no) {
		
		return ResponseEntity.ok(service.boardDetail(no));
	}		
	// http://localhost:5050/boardUpdate
	@PutMapping("boardUpdateAjax")
	public ResponseEntity<?>  boardUpdateAjax(@RequestBody Board upt) {

		return ResponseEntity.ok(service.boardUpdate(upt));  // Board => json
	}	
	// http://localhost:5050/boardDeleteAjax
	@DeleteMapping("boardDeleteAjax")
	public ResponseEntity<?>  boardDeleteAjax(@RequestParam("no") int no, Model d) {

		return ResponseEntity.ok(service.boardDelete(no));
	}		

}
