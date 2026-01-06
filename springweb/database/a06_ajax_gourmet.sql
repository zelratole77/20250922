-- 2. 시퀀스 생성 (ID 자동 증가용)
CREATE SEQUENCE GOURMET_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

-- 3. 테이블 생성
CREATE TABLE GOURMET_STORE (
    ID          NUMBER(10) PRIMARY KEY,        -- 고유 번호
    NAME        VARCHAR2(100) NOT NULL,        -- 맛집 이름
    CATEGORY    VARCHAR2(50),                  -- 카테고리 (한식, 일식 등)
    KEYWORD     VARCHAR2(200),                 -- 검색 키워드 (쉼표 구분 등)
    DESCRIPTION CLOB,                          -- 상세 설명 (긴 문장 대비)
    RATING      NUMBER(1) DEFAULT 5,           -- 별점 (1~5)
    CREATED_AT  DATE DEFAULT SYSDATE           -- 등록일
);
/*
private int id;
private String name;
private String category;
private String keyword;
private int rating;
private Date createdAt;


# 등록 처리 dao..
INSERT INTO GOURMET_STORE VALUES (GOURMET_SEQ.NEXTVAL, #{name}, #{category}, #{keyword}, 
	#{description}, #{rating}, SYSDATE)

@Select("")	
int insertGourmet(GourmetStore ins);			
	



@Select("SELECT * FROM GOURMET_STORE WHERE ID=#{id}")
GourmetStore getGourmet(@Param("id") int id);


 * */
SELECT * FROM GOURMET_STORE ; 
SELECT * FROM GOURMET_STORE WHERE ID=1; 



-- 4. 제약 조건 추가 (별점 1~5점 제한)
ALTER TABLE GOURMET_STORE ADD CONSTRAINT CHK_RATING CHECK (RATING BETWEEN 1 AND 5);

-- 5. 코멘트 추가 (관리 용이성)
COMMENT ON COLUMN GOURMET_STORE.NAME IS '맛집 명칭';
COMMENT ON COLUMN GOURMET_STORE.KEYWORD IS '검색용 해시태그';


-- 데이터 삽입
INSERT INTO GOURMET_STORE (ID, NAME, CATEGORY, KEYWORD, DESCRIPTION, RATING)
VALUES (GOURMET_SEQ.NEXTVAL, '자바반점', '중식', '짜장면,탕수육,코딩맛집', '코딩하다 막힐 때 먹으면 풀리는 전설의 짜장면', 5);

INSERT INTO GOURMET_STORE (ID, NAME, CATEGORY, KEYWORD, DESCRIPTION, RATING)
VALUES (GOURMET_SEQ.NEXTVAL, '스프링카페', '카페', '아메리카노,조용한,공부하기좋은', '테이블마다 콘센트가 있고 라떼가 일품입니다.', 4);

INSERT INTO GOURMET_STORE (ID, NAME, CATEGORY, KEYWORD, DESCRIPTION, RATING)
VALUES (GOURMET_SEQ.NEXTVAL, '쿼리집', '한식', '김치찌개,집밥,오라클', '어머니가 해주신 든든한 찌개 맛을 느낄 수 있는 곳', 5);

INSERT INTO GOURMET_STORE (ID, NAME, CATEGORY, KEYWORD, DESCRIPTION, RATING)
VALUES (GOURMET_SEQ.NEXTVAL, '마이바티스 초밥', '일식', '스시,깔끔한,데이트', '비싸지만 그만큼 값어치를 하는 정통 스시집', 4);

INSERT INTO GOURMET_STORE (ID, NAME, CATEGORY, KEYWORD, DESCRIPTION, RATING)
VALUES (GOURMET_SEQ.NEXTVAL, 'AJAX 샐러드', '샐러드', '비건,건강,다이어트', '신속하게 서빙되는 신선한 샐러드 전문점', 3);

-- 확정
COMMIT;
-- 메인 리스트 화면..
SELECT id, name, category,  keyword, rating 
FROM GOURMET_STORE WHERE name LIKE '%%' and keyword LIKE '%%';
SELECT *
FROM GOURMET_STORE WHERE name LIKE '%%' and keyword LIKE '%%';
/*
sql
dto(GourmetStore.java)
dao

	

service
controller
	/gourmetMngView (초기view단 호출)
	/gourmetList  (ajax)
	 
view(jsp)


 * */

SELECT * FROM LUNCH_MENU;

SELECT menu_id, category, menu_name FROM LUNCH_MENU
WHERE menu_name LIKE '%%' AND category LIKE '%%';
/*
SELECT menu_id, category, menu_name FROM LUNCH_MENU
WHERE menu_name LIKE #{menuName} AND category LIKE #{category}
@Select("")
LunchMenu lunchMenuList(LunchMenu sch);

 * 
 * */
