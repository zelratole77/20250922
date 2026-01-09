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
		insert into board values(board_seq.nextval,0,'첫번째글','내용없음','himan',0,sysdate, sysdate);
		commit;
		
		
SELECT * FROM BOARD;		