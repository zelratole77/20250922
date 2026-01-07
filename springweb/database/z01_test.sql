
-- 미식 테이블 생성
CREATE TABLE LUNCH_MENU (
    menu_id    NUMBER PRIMARY KEY,      -- 메뉴 번호
    category   VARCHAR2(50),            -- 한식, 중식, 일식, 양식 등
    menu_name  VARCHAR2(100) NOT NULL,  -- 음식 이름
    price_tag  VARCHAR2(20),            -- 가성비, 적당함, Flex
    comment_msg VARCHAR2(500)           -- 추천 사유
);

DROP TABLE CALENDAR;


	CREATE TABLE CALENDAR(
			ID NUMBER PRIMARY KEY,
			TITLE VARCHAR2(100),
			WRITER VARCHAR2(50),
			START1 DATE,
			END1 DATE,
			CONTENT VARCHAR2(1000),
			BACKGROUND_COLOR VARCHAR2(50),
			TEXT_COLOR VARCHAR2(50),
			ALL_DAY NUMBER(1),
			URL_LINK VARCHAR2(50)
		);


CREATE SEQUENCE LUNCH_SEQ
START WITH 1          -- 1부터 시작해라!
INCREMENT BY 1        -- 1씩 증가해라!
NOCACHE;              -- 번호 건너뛰기 방지 (연습용)

SELECT CALENDAR_SEQ.NEXTVAL FROM  dual;
SELECT * FROM calendar;

INSERT INTO CALENDAR VALUES(CALENDAR_SEQ.NEXTVAL, '첫일정',
	'2025-07-11','2025-07-12','첫일정입니다.', 
'#0099CC', '#CCFFFF',1,'홍길동', '', 'http://www.nanver.com');
INSERT INTO CALENDAR VALUES(CALENDAR_SEQ.NEXTVAL, '두번일정','2025-07-14','2025-07-15','두일정입니다.','#0099CC', '#CCFFFF',1,'홍길동', '','http://www.nanver.com');
INSERT INTO CALENDAR VALUES(CALENDAR_SEQ.NEXTVAL, '세번일정','2025-07-15','2025-07-16','세번일정입니다.','#0099CC', '#CCFFFF',1, '홍길동','','http://www.nanver.com');

/*
등록 처리 dao..

INSERT INTO LUNCH_MENU (menu_id, category, menu_name, price_tag, comment_msg)
VALUES (LUNCH_SEQ.NEXTVAL, #{category}, #{menuName}, #{priceTag}, #{commentMsg})

@Insert("")
int insertLunchMenu(LunchMenu ins);


	// menuId category menuName priceTag commentMsg
	// 아이디   분뉴       메뉴명     가격태그   평가태그
 * */

SELECT * FROM LUNCH_MENU;
UPDATE LUNCH_MENU
   SET category = '일식',
       menu_name = '라멘',
       price_tag = '맛난 특별한',
       comment_msg = '이국적인 맛'
 WHERE MENU_ID = 4;

DELETE FROM LUNCH_MENU WHERE MENU_ID = 4;
/*
UPDATE LUNCH_MENU
   SET category = #{category},
       menu_name = #{menuName},
       price_tag = #{priceTag},
       comment_msg = #{commentMsg}
 WHERE MENU_ID = #{menuId}
@Update("")
int updateLunchMenu(LunchMenu upt);

@Delete("DELETE FROM LUNCH_MENU WHERE MENU_ID = #{menuId}")
int deleteLunchMenu(@Param("menuId") int menuId);
 
  
    
*/

-- 1번 손님: 한식
INSERT INTO LUNCH_MENU (menu_id, category, menu_name, price_tag, comment_msg)
VALUES (LUNCH_SEQ.NEXTVAL, '한식', '돼지국밥', '가성비', '전날 마신 술이 싹 씻겨 내려가는 국물!');




-- 2번 손님: 중식
INSERT INTO LUNCH_MENU (menu_id, category, menu_name, price_tag, comment_msg)
VALUES (LUNCH_SEQ.NEXTVAL, '중식', '간짜장', '적당함', '계란 후라이가 올라간 꾸덕한 짜장은 못 참지!');

-- 3번 손님: 일식 (Flex!)
INSERT INTO LUNCH_MENU (menu_id, category, menu_name, price_tag, comment_msg)
VALUES (LUNCH_SEQ.NEXTVAL, '일식', '사케동(연어덮밥)', 'Flex', '오늘 하루 고생한 나에게 주는 부드러운 선물.');

-- 저장 확정!
COMMIT;
SELECT * FROM LUNCH_MENU;
/*
class LunchMenu
private int menuId;
private String category;
private String menuName;
private String priceTag;
private String commentMsg;

 * */


