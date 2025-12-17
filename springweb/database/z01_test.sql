/* 소개팅 관리 테이블 */
CREATE TABLE BLIND_DATE (
    DATE_NO     NUMBER PRIMARY KEY,       -- 번호
    PARTNER_NAME VARCHAR2(50) NOT NULL,   -- 상대방 이름 (혹은 주선자)
    PARTNER_AGE NUMBER,                   -- 상대방 나이
    JOB         VARCHAR2(50),             -- 직업
    LOCATION    VARCHAR2(100),            -- 만남 장소
    MEET_DATE   DATE,                     -- 만나는 날짜 (시간 포함)
    STATUS      VARCHAR2(20) DEFAULT 'WAITING', -- 상태 (WAITING:대기, ING:연락중, FAIL:망함, SUCCESS:커플)
    SCORE       NUMBER(2,1) DEFAULT 0,    -- 내 마음 속 별점 (5.0 만점)
    REVIEW      VARCHAR2(500)             -- 한줄 후기 (팩트 폭격)
);

CREATE SEQUENCE SEQ_DATE_NO NOCACHE;

/* 1. 이미 지나간 소개팅 (실패 사례들) */

-- 사진과 실물이 달랐던 경우
INSERT INTO BLIND_DATE 
VALUES (SEQ_DATE_NO.NEXTVAL, '김포샵', 29, '웹디자이너', '강남역 11번출구', 
        TO_DATE('2023-12-01 19:00', 'YYYY-MM-DD HH24:MI'), 
        'FAIL', 1.5, '사진이랑 너무 다름... 주선자 멱살 잡을 예정.');

-- 말은 잘 통했으나 연락이 두절된 경우 (잠수 이별)
INSERT INTO BLIND_DATE 
VALUES (SEQ_DATE_NO.NEXTVAL, '이잠수', 31, '개발자', '판교 아브뉴프랑', 
        TO_DATE('2024-01-15 12:30', 'YYYY-MM-DD HH24:MI'), 
        'FAIL', 4.0, '대화 잘 통했는데 집 가서 카톡하니 1이 안 사라짐.');

-- 직업은 좋으나 성격이 안 맞음
INSERT INTO BLIND_DATE 
VALUES (SEQ_DATE_NO.NEXTVAL, '박사자', 33, '변호사', '서초동 법원 앞', 
        TO_DATE('2024-02-20 18:00', 'YYYY-MM-DD HH24:MI'), 
        'FAIL', 2.0, '자기 자랑만 2시간 하다가 감. 밥값은 내가 냄.');

/* 2. 현재 진행 중인 소개팅 (희망 편) */

-- 이번 주말 약속 (기대 중)
INSERT INTO BLIND_DATE 
VALUES (SEQ_DATE_NO.NEXTVAL, '최존잘', 28, '헬스 트레이너', '홍대 입구', 
        SYSDATE + 3, -- 3일 뒤 만남
        'WAITING', 0, '프로필 사진 대박임. 살 빼고 나가야 함.');

-- 애프터 신청 받은 상태 (썸 타는 중)
INSERT INTO BLIND_DATE 
VALUES (SEQ_DATE_NO.NEXTVAL, '정다정', 30, '공무원', '한강 공원', 
        SYSDATE - 1, -- 어제 만남
        'ING', 4.5, '매너 좋고 웃는 게 예쁨. 이번 주말에 영화 보기로 함!');

/* 3. 성공 사례 (전설의 레전드) */
INSERT INTO BLIND_DATE 
VALUES (SEQ_DATE_NO.NEXTVAL, '내사랑', 29, '건물주', '남산 타워', 
        TO_DATE('2024-05-05 14:00', 'YYYY-MM-DD HH24:MI'), 
        'SUCCESS', 5.0, '오늘부터 1일. 어플 삭제합니다~');

COMMIT;

/* 조회 확인: 별점 높은 순으로 정렬해서 보기 */
SELECT * FROM BLIND_DATE ORDER BY SCORE DESC, MEET_DATE DESC;
