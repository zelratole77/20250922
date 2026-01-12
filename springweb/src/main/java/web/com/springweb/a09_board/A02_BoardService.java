package web.com.springweb.a09_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// a09_board.A02_BoardService
@Service
public class A02_BoardService {
	@Autowired(required=false)
	private A03_BoardDao dao;
	
	public List<Board> boardList(Board sch){
		if(sch.getSubject()==null) sch.setSubject("");
		if(sch.getWriter()==null) sch.setWriter("");
		sch.setSubject("%"+sch.getSubject()+"%");
		sch.setWriter("%"+sch.getWriter()+"%");
		return dao.boardList(sch);
	}
	
	public String boardInsert(Board ins) {
		return dao.boardInsert(ins)>0?"등록 성공":"등록실패";
	}
	
	public Board boardDetail(int no) {
		// 상세조회시, 조회수 카운트 업
		dao.uptReadCnt(no);
		return dao.getBoard(no);
	}		
	public Board getBoard(int no) {
		// 상세조회시, 조회수 카운트 업
		return dao.getBoard(no);
	}		

	public String boardUpdate(Board upt) {
		return dao.boardUpdate(upt)>0?"수정성공":"수정실패";
	}
	public String boardDelete(int no) {
		return dao.boardDelete(no)>0?"삭제성공":"삭제실패";
	}	
	
}
