

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
		create table boardfile(
			no number,
			fname varchar2(100),
			etc varchar2(500),
			regdte date,
			uptdte date
		);
		create sequence board_seq;
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






