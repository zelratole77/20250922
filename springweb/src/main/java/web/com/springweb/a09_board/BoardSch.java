package web.com.springweb.a09_board;

// a09_board.BoardSch 페이징 처리 및 검색을 위한 DTO
public class BoardSch {
	
	// 기본 검색 조건
	private String schSubject;
	private String schWriter;  
	// 검색을 위한 데이터와  상세화면에 나타나는 데이터 동일하면 충돌
	// 페이징 처리를 위한 속성
	private int count; // 검색된 데이터의 총건수.[DB처리]
	private int pageSize; // 한번에 보일 데이터 건수[요청값]
	private int curPage; // 클릭한 현재 페이지 번호[요청값]
	private int pageCount; // 전체 페이지 건수[계산 알고리즘]
	// DB에 조건으로 넘길 속성
	private int start;  //시작번호 [계산 알고리즘]
	private int end; 	// 마지막번호 [계산 알고리즘]
	
	// 페이지 블럭을 위한 속성..
	private int blockSize; // 페이지 블럭의 크기[설정]
	private int startBlock; // 페이지 블럭의 시작번호 [계산알고리즘]
	private int endBlock;   // 페이지 블럭의 마지막번호 [계산 알고리즘]
	public BoardSch() {
		// service단에서 if null 에 대한 조건을 아래 생성자를 통해서 처리하면 생략 가능..
		schSubject="";
		schWriter="";
	}

	

	public String getSchSubject() {
		return schSubject;
	}



	public void setSchSubject(String schSubject) {
		this.schSubject = schSubject;
	}



	public String getSchWriter() {
		return schWriter;
	}



	public void setSchWriter(String schWriter) {
		this.schWriter = schWriter;
	}



	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	
	
	
}
