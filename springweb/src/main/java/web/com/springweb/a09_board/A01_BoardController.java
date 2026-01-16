package web.com.springweb.a09_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import web.com.springweb.z01_dto.Member;
@Controller
public class A01_BoardController {
	@ModelAttribute("sch")
	public BoardSch setCommonBoardSch(BoardSch sch) {
	    return sch; // 여기서 바인딩된 객체가 모델에 "sch"라는 이름으로 자동 저장됨
	}	
	
	
	
	@Autowired(required=false)
	private A02_BoardService service;
	
	// http://localhost:5050/login
	@RequestMapping("login")
	public String login(Member mem, HttpSession session, Model d) {
		
		// 로그아웃에서 오면..
		if(session.getAttribute("mem")!=null) {
			session.removeAttribute("mem");
		}
		// 1. 초기화면 아닐 때..(입력으로 id, pwd 값이 들어 왔을 때..
		if(mem.getId()!=null) {
			Member dbMem = service.login(mem);
			// DB에 데이터가 없을 때, 있을 때 구분
			if(dbMem!=null) {
				session.setAttribute("mem", dbMem); // 세션 처리
				d.addAttribute("msg", "로그인 성공");
			}else {
				d.addAttribute("msg", "로그인 실패");
			}
		}
		return "a09_board\\a00_login";
	}

	
	
	// [   ] 
	// http://localhost:5050/boardList
	@RequestMapping("boardList")   // get/post
	public String boardList(BoardSch sch, Model d) { //boardSch ==> sch
		// BoardSch 요청데이터로 처리 모델속성을 가지고 있기에 service 단에서 처리된 내용이 화단에서 영향받아 처리할 수 있다.
		d.addAttribute("boardList", service.boardList(sch));
		
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
	@PostMapping("boardDetail")
	public String boardDetail(@RequestParam("no") int no, Model d) {
		// 기본 정보	
		d.addAttribute("board", service.boardDetail(no));
		d.addAttribute("bfiles", service.getFile(no));
		
		
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
	    // 삭제 후에는 상세화면이 없으므로 리스트로 이동
		return "a09_board\\a03_boardDetail";
	}	
	// 	http://localhost:5050/boardReply
	@PostMapping("boardReply")
	public String boardReply(Board board) { // 요청값 + 모델 (모델 어트리뷰터) ${board.no}으로 처리가 가능..
		// 답글은 기본 데이터 설정.
		// 1. 답글 번호는 현재 상세화면의 글번호
		board.setRefno(board.getNo());
		board.setSubject("RE:"+board.getSubject());
		board.setContent("\n\n\n\n\n=========== 이전글 ==========\n"+board.getContent());
		
		return "a09_board\\a02_boardInsert";
	}
	
	
	// http://localhost:5050/boardMng
	@GetMapping("boardMng")   // get
	public String boardMng() {
		return "a09_board\\b01_boardMng";
	}
	// http://localhost:5050/boardListAjax  ?writer=홍&subject=공지
	@GetMapping("/boardListAjax")   // get/post
	public ResponseEntity<?> boardListAjax(BoardSch sch) {
		
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
