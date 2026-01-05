
-- 미식 테이블 생성
CREATE TABLE LUNCH_MENU (
    menu_id    NUMBER PRIMARY KEY,      -- 메뉴 번호
    category   VARCHAR2(50),            -- 한식, 중식, 일식, 양식 등
    menu_name  VARCHAR2(100) NOT NULL,  -- 음식 이름
    price_tag  VARCHAR2(20),            -- 가성비, 적당함, Flex
    comment_msg VARCHAR2(500)           -- 추천 사유
);

CREATE SEQUENCE LUNCH_SEQ
START WITH 1          -- 1부터 시작해라!
INCREMENT BY 1        -- 1씩 증가해라!
NOCACHE;              -- 번호 건너뛰기 방지 (연습용)
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


