package web.com.springweb.a09_board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.com.springweb.z01_dto.Member;
// a09_board.A02_BoardService
@Service
public class A02_BoardService {
	@Autowired(required=false)
	private A03_BoardDao dao;
	
	public Member login(Member sch) {
		return dao.login(sch);
	}
	
	public List<Board> boardList(BoardSch sch){
		// 1. 기본 검색 내용
		if(sch.getSubject()==null) sch.setSubject("");
		if(sch.getWriter()==null) sch.setWriter("");
		sch.setSubject("%"+sch.getSubject()+"%");
		sch.setWriter("%"+sch.getWriter()+"%");
		// 1. 총건수 설정[DB]
		sch.setCount(dao.boardTot(sch));
		
		
		// 2. 한번에 보일 페이지(요청값)-초기화면을 위해서 기본 5로 설정.
		if(sch.getPageSize()==0)
			sch.setPageSize(5);
		// 3. 총페이지 수(총건수/한번에보일 페이지수 ==> 나머지값이 있을 때 하나더 ==> 올림)
		///   정수/정수 ==> 자바에서는 정수로 절삭 ==> promote로 실수값으로 변환 처리해서 나누어 주고, 
		///   Math.ceil()을 통해서 올림 처리한다. Math.ceil() 실수 타입이어서 int로 캐스팅 처리
		/*
		double pageSize = (double)sch.getPageSize();      소숫점이하 처리를 위해 실수 변환
		double pageCountDbl =  sch.getCount()/(double)sch.getPageSize(); 실수가 나온 페이지 크기
		double pageCountDblCeil = Math.ceil(pageCountDbl);  나머지값이 있을 때는 페이지 하나 더 올라가야 함으로 올림처리
		int pageCountCeilInt = (int)pageCountDblCeil;   정수형 페이지 갯수를 처리하기 위한 캐스팅 처리.
		sch.setPageCount(pageCountCeilInt);    총페이지 수 설정..
		*/
		sch.setPageCount(	(int)(Math.ceil(sch.getCount()/(double)sch.getPageSize())) );
		
		// 4. 현재페이지 기본 설정[요청값] - 초기 화면에서 0 ==> 1로 설정 필요
		if(sch.getCurPage()==0)
			sch.setCurPage(1);
		//  블럭단위 next를 누르더라도 총페이지보다는 더 이상 증가되지 않게..
		if(sch.getCurPage()>sch.getPageCount()) { 
			sch.setCurPage(sch.getCurPage());
		}
		
		// 5. 시작번호 : 시작번호..알고리즘 생각
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		/*
		시작번호 도출
			현재페이지번호	페이지크기	 	시작번호			
			1			5	10		1		1
			2			5	10		6		11
			3			5	10		11		21
			4			5	10		16		31
			5			5	10		21		41
		 * */
		// 6. 마지막번호
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		//    마지막번호를 총데이터 건수보다 작아야 한다. 이보다 크면 end를 총데이터 건수로 설정..
		if(sch.getEnd()>sch.getCount())
			sch.setEnd(sch.getCount());
		// -------------------
		// 7. 페이지 블럭(한번에 보일 블럭의 크기)
		// 8. 시작 블럭 번호
		// 9. 마지막 블럭 번호.
		
		
		
		
		return dao.boardList(sch);
	}
	// 공통 업로드할 경로명..
	@Value("${user.upload}")
	private String path;
	
	public String boardInsert(Board ins) {
		// 1. 기본 정보 저장
		String msg = "";
		msg = "[기본정보]"+(dao.boardInsert(ins)>0?"등록 성공\\n":"등록실패\\n"); // ins에 no값이 할당처리..
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
					cnt+=dao.boardInsertFile(new FileDto(ins.getNo(), fname,"게시판 파일업로드:"+ins.getSubject()));
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
	public List<FileDto> getFile(int no){
		return dao.getFile(no);
	}
	
}
