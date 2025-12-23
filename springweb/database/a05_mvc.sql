/* 1. 그룹 데이터 생성 (3개 그룹) */
INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (10, '방탄조끼소년단', '2013-06-13', '아미');

INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (20, '뉴진스', '2022-07-22', '버니즈');

INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (30, '아이브', '2021-12-01', '다이브');

CREATE SEQUENCE idolgrp_seq
	START WITH 40
	INCREMENT BY 10;
INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (idolgrp_seq.nextval, '아이브2', '2021-12-01', '다이브2');

SELECT * FROM TBL_GROUP;
UPDATE TBL_GROUP
    SET GROUP_NAME='방탄소년',
        DEBUT_DATE = SYSDATE,
        FANDOM_NAME = '아미2'
  WHERE GROUP_NO = 10;    
/*
UPDATE TBL_GROUP
    SET GROUP_NAME=#{groupName},
        DEBUT_DATE = #{debutDate},
        FANDOM_NAME = #{fandomName}
  WHERE GROUP_NO = #{groupNo}
@Update("")
int updateGroup(A04Group upt);  

@Delete("DELETE FROM TBL_GROUP WHERE GROUP_NO = #{groupNo}")
int deleteGroup(@Param("groupNo") int groupNo);
EX) dao 메서드 선언..



 * 
 * */


-- foreign key 연결되어 있으면 하위 종속적인 데이터를 삭제해야지 main 데이터 삭제 가능..
ALTER TABLE TBL_MEMBER DROP CONSTRAINT FK_GROUP_MEMBER;







/* 2. 멤버 데이터 생성 */

-- 방탄조끼소년단 멤버 (그룹번호 10)
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '김남준', 'RM', '리더/래퍼', 181.0, 10);
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '전정국', '정국', '메인보컬', 178.5, 10);
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '김태형', 'V', '서브보컬', 179.0, 10);

-- 뉴진스 멤버 (그룹번호 20)
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '김민지', '민지', '리더/보컬', 169.0, 20);
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '팜하니', '하니', '메인댄서', 161.5, 20);
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '다니엘', '다니엘', '보컬', 165.0, 20);

-- 아이브 멤버 (그룹번호 30)
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '안유진', '유진', '리더', 172.0, 30);
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '장원영', '원영', '센터/보컬', 173.0, 30);

-- 솔로 연습생 (그룹이 아직 없는 경우 - NULL 테스트용)
INSERT INTO TBL_MEMBER VALUES (SEQ_MEMBER_NO.NEXTVAL, '나혼자', 'SOLO', '연습생', 160.0, NULL);

/* 저장 및 확인 */
COMMIT;

-- 조회: 그룹명과 멤버 이름을 같이 보기 (JOIN)
SELECT G.GROUP_NAME, M.STAGE_NAME, M.POSITION, M.HEIGHT
FROM TBL_GROUP G
JOIN TBL_MEMBER M ON G.GROUP_NO = M.GROUP_NO
ORDER BY G.GROUP_NO ASC;

-- TBL_GROUP TBL_MEMBER
-- 초기 그룹 조회 화면 구성
SELECT * FROM TBL_GROUP 
WHERE GROUP_NAME LIKE '%%' 
AND FANDOM_NAME LIKE '%%';
/*
EX) DAO 메서드 선언..
매개변수
리턴값선언
SELECT * FROM TBL_GROUP 
WHERE GROUP_NAME LIKE #{groupName} 
AND FANDOM_NAME LIKE #{fandomName}
@Select("")
List<A04Group> getIdolGrpList(A04Group sch);



 * 
 * */
/* 검색되는 값 
 * where 조건 ==> 요청값  groupName, fandomName  ==> DTO (A04Group) 
 * 		<input name="groupName"   <input name="fandomName"  
 * 출력하는 데이터 ==> 화면 테이블에 리스트 ==> DTO List
 * 		테이블의 타이틀명 : 그룹번호   그룹명  데뷰날짜 팬그룹이름
 *                
 * 
 * */
/*
private int groupNo;
private String groupName;
private Date debutDate;
private String fandomName;

private int memberNo;
private String realName;
private String stageName;
private String position;
private double height;
private int groupNo;

 * */
SELECT * FROM TBL_MEMBER;
SELECT * FROM TBL_MEMBER WHERE REAL;

SELECT * FROM BLIND_DATE;
SELECT * FROM BLIND_DATE WHERE partner_name LIKE '%%' AND location LIKE '%%';
/*
위 sql에 dao 메서드
입력 partnerName, location ==> A04Meet
리턴값 A04Meet

SELECT * FROM BLIND_DATE 
WHERE partner_name LIKE #{partnerName} 
AND location LIKE #{location}

@Select("")
List<A04Meet> getBlindDate(A04Meet sch);







parnterName  location

dateNo parnterName partnerAge  location meetDate

private int dateNo;
private String parnterName;
private int partnerAge;
private String job;
private String location;
private Date meetDate;
private String status;
private int score;
private String review;


 * */
/*
# 상세데이터 처리

 * */
SELECT * FROM TBL_GROUP WHERE GROUP_NO = 70;
/*
SELECT * FROM TBL_GROUP WHERE GROUP_NO = #{groupNo}
입력값 int ==> 매개변수 ==> @Param("groupNo") int groupNo
리턴값 A04Group ==> 
ex) dao 처리
@Select("SELECT * FROM TBL_GROUP WHERE GROUP_NO = #{groupNo}")
A04Group  getIdolGrop(@Param("groupNo") int groupNo);
 * */
-- 출력  group_no 70, group_name LIGHTSUM, debu_date 2025-12-10...  fandom_name SUMIT
-- ==> VO  groupNo int,  groupName String,  debuDate Date,  fandomName String
--     설정하는 Dto ==> A04Group   sql의 처리 결과를 setGrouNo(70), setGroupName('LIGHTSUM')..
---    데이터가 담긴 최종 결과값을 리턴객체로 설정한다.





/*
  
 * */
SELECT * FROM BLIND_DATE; WHERE date_no = 1;
/* 상세화면 처리..
1. sql
*2. dao 메서드 선언
@Select("SELECT * FROM BLIND_DATE WHERE date_no = #{dateNo}")
A04Meet getMeet(@Param("dateNo") int dateNo);


*
*
**
3. service
4. controller 모델 데이터 설정
5. jsp 화면 구성..
6. list 에서 더블클릭으로 상세화면 호출..




 * 
 * */









