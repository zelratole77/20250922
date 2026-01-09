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
	
	
	
}
