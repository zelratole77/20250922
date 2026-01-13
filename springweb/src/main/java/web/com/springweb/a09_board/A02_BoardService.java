package web.com.springweb.a09_board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
	// 공통 업로드할 경로명..
	@Value("${user.upload}")
	private String path;
	
	public String boardInsert(Board ins) {
		// 1. 기본 정보 저장
		String msg = "";
		msg = "[기본정보]"+(dao.boardInsert(ins)>0?"등록 성공\\n":"등록실패\\n");
		// 2. 파일 업로드
		try {
			int cnt = 0; //등록한 파일 갯수..
			for(MultipartFile mf:ins.getReports()) {
				String fname = mf.getOriginalFilename();
				if( !fname.equals("") ) { // 첨부파일이 있으면..
					File file = new File(path,fname);
					// stream 메모리 ==> file 물리실제 파일로 저장..
					// 3. 파일 정보 저장.
					mf.transferTo(file); // 물리적 파일 서버에 업로그..
					// 등록된 파일 갯수를 반복문에 의해서 누적 처리..		
					cnt+=dao.boardInsertFile(new FileDto(fname,"게시판 파일업로드:"+ins.getSubject()));
				}
			}
			msg+="[파일정보]"+cnt+"건 파일 등록 성공";
		} catch (IllegalStateException e) {
			msg+="[상태정보 예외]"+e.getMessage();
		} catch (IOException e) {
			msg+="[파일처리 예외]"+e.getMessage();
		} catch (Exception e) {
			msg+="[기타처리 예외]"+e.getMessage();
		}
		return msg;
	}
	
	public Board boardDetail(int no) {
		// 상세조회시, 조회수 카운트 업
		dao.uptReadCnt(no);
		return dao.getBoard(no);
	}
	
	public Board getBoard(int no) {
		// 수정시는 해당 상세 데이터만 가져오게 처리
		return dao.getBoard(no);
	}		

	public String boardUpdate(Board upt) {
		return dao.boardUpdate(upt)>0?"수정성공":"수정실패";
	}
	public String boardDelete(int no) {
		return dao.boardDelete(no)>0?"삭제성공":"삭제실패";
	}	
	
}
