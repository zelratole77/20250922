create table calender(
	id number primary key,
	title varchar2(100),
	start1 varchar2(50), -- date의 ISO형식
	end1 varchar2(50),
	background_color varchar2(20),
	text_color varchar2(20),
	all_day number(1),  -- DB에서 0/1 ==> DTO false/true	
	url_link varchar2(200),
	writer varchar2(50),
	content varchar2(500)
);
create sequence cal_seq;
insert into calender values(cal_seq.nextval, '첫번째 일정', '2026-01-07','2026-01-08',
	'#009933','#ffff99',1,'http://www.naver.com','홍길동','일정 등록 연습' );
SELECT * FROM calender;
