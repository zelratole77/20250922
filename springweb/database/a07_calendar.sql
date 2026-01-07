DROP TABLE CALENDAR;
create table CALENDAR(
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
DROP SEQUENCE cal_seq;
create sequence cal_seq;
insert into CALENDAR values(cal_seq.nextval, '첫번째 일정', '2026-01-07','2026-01-08',
	'#009933','#ffff99',1,'http://www.naver.com','홍길동','일정 등록 연습' );

SELECT * FROM CALENDAR;
SELECT ID, TITLE, START1 "START", END1 "END", BACKGROUND_COLOR,
		TEXT_COLOR, ALL_DAY, URL_LINK, WRITER, CONTENT
FROM CALENDAR;
/*
SELECT ID, TITLE, START1 "START", END1 "END", BACKGROUND_COLOR,
		TEXT_COLOR, ALL_DAY, URL_LINK, WRITER, CONTENT
FROM CALENDAR
@Select("")
List<Calendar> calendarList();

 * */



-- 테이블 생성
CREATE TABLE calendar_room (
    id NUMBER PRIMARY KEY,
    title VARCHAR2(100) NOT NULL, -- 예약명 (예: 주간 회의)
    start1 VARCHAR2(50) NOT NULL, -- 예약 시작 일시
    end1 VARCHAR2(50),            -- 예약 종료 일시
    background_color VARCHAR2(20),
    text_color VARCHAR2(20),
    all_day NUMBER(1),            -- 0: false, 1: true
    room_name VARCHAR2(50),       -- 회의실 이름 (A회의실, B회의실 등)    
    writer VARCHAR2(50),          -- 예약자
    content VARCHAR2(500),         -- 회의 안건 및 상세 내용
    members VARCHAR2(200)          -- 참석예정자명단   
);
SELECT * FROM calendar_room;
/*

SELECT ID, TITLE, START1 "START", END1 "END", BACKGROUND_COLOR,
TEXT_COLOR, ALL_DAY,ROOM_NAME, WRITER, CONTENT, MEMBERS
FROM CALENDAR_ROOM
			
 * */

-- 시퀀스 생성
CREATE SEQUENCE cal_room_seq;

-- 샘플 데이터 입력
INSERT INTO calendar_room VALUES(
    cal_room_seq.nextval, 
    '프로젝트 기획 회의', 
    '2026-01-07T10:00:00', 
    '2026-01-07T12:00:00',
    '#3788d8', 
    '#ffffff', 
    0, 
    '제1 회의실',
    '마길동', 
    '신규 프로젝트 방향성 논의',
    '홍길동, 김길동, 마길동'
);

SELECT * FROM calendar_room;