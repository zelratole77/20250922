-- 1. 재고 테이블 생성 (냉장고)
CREATE TABLE tbl_store (
    pno NUMBER PRIMARY KEY,         -- 상품 번호 (바코드)
    pname VARCHAR2(100) NOT NULL,   -- 상품 이름
    price NUMBER DEFAULT 0          -- 가격
);

-- 2. 번호표 기계 (시퀀스)
CREATE SEQUENCE seq_store;

-- 3. [초기 데이터] 진열대에 물건 미리 채워두기 (이게 있어야 조회할 맛이 납니다)
INSERT INTO tbl_store (pno, pname, price) VALUES (seq_store.nextval, '포켓몬빵', 1500);
INSERT INTO tbl_store (pno, pname, price) VALUES (seq_store.nextval, '바나나우유', 1700);
INSERT INTO tbl_store (pno, pname, price) VALUES (seq_store.nextval, '삼각김밥', 1200);
COMMIT;

SELECT * FROM TBL_STORE;
