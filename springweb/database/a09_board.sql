

DROP TABLE BOARD CASCADE CONSTRAINTS;
		create table board(
			no number primary key,
			refno number,
			subject varchar2(100),
			content varchar2(1000),
			writer varchar2(50),
			readcnt number,
			regdte date,
			uptdte date
		);
		-- 하나의 게시물관 연관관계를 설정할려면 no와 동일해 아래 no값을 1:다로 입력처리하여야 한다..
		create table boardfile(
			no number,
			fname varchar2(100),
			etc varchar2(500),
			regdte date,
			uptdte date
		);
		SELECT * FROM board;
		create sequence board_seq;
		--insert into board values(board_seq.nextval  게시물 등록시 바로 처리하기에  board_seq.currval 로 설정 처리)
		insert into board values(board_seq.nextval,0,'첨부파일 게시물','내용','첨부자',0,sysdate, sysdate);

		INSERT INTO boardfile values(board_seq.currval, '파일명.txt', '게시물 정보 간단하게 정리', sysdate, sysdate);

		INSERT INTO boardfile values(41, '파일명.txt', '게시물 정보 간단하게 정리', sysdate, sysdate);
		
		SELECT * FROM boardfile;
		SELECT * FROM boardfile WHERE NO = 84;
		
/*
@Select("SELECT * FROM boardfile WHERE NO = #{no}")
List<FileDto> getFile(@Param("no") int no);





@Insert("INSERT INTO boardfile values(board_seq.currval, #{fname}, #{etc}, sysdate, sysdate)")
int boardInsertFile(FileDto ins);

class FileDto{
	private int no;
	private String fname;
	private String etc;
	private Date regdte;
	private Date uptdte;
	

}


 * */
		
		
		
		-- 샘플 데이터
/*
dao
	insert into board values(board_seq.nextval,#{refno},#{subject},#{content},#{writer},0,sysdate, sysdate)
	
	@Insert("insert into board values(board_seq.nextval,#{refno},#{subject},#{content},#{writer},0,sysdate, sysdate)")
	int boardInsert(Board ins);
	

	insert into board values(board_seq.nextval,0,'첫번째글','내용없음','himan',0,sysdate, sysdate)

-------------------------------
service
controller
 * */
		insert into board values(board_seq.nextval,0,'첫번째글','내용없음','himan',0,sysdate, sysdate);



		commit;
		
		
SELECT * FROM BOARD WHERE SUBJECT LIKE '%공%' AND WRITER LIKE '%%';	

SELECT * FROM BOARD WHERE NO = 1;
/*
입력 값 ?  1 ==> int no  ==> 매개변수 선언
출력 값 ? 1 0 첫번째글 내용없음 홍길동...==> 객체가 필요
class Board{
	int no;
	int refno;
	String subject;
	String content;
}
Dao 만드는 방법
@Select("SELECT * FROM BOARD WHERE NO = #{no}")
Board selectBoard(@Param("no") int no);

 * */
SELECT * FROM MEMBER WHERE id='himan' AND pwd='7777';
/*
@Select("SELECT * FROM MEMBER WHERE id=#{id} AND pwd=#{pwd}")
Member login(Member sch);
 * */
SELECT * FROM MEMBER;
INSERT INTO MEMBER values('higirl','7777','김정희',1000,'user1');





