/* 1. 그룹 데이터 생성 (3개 그룹) */
INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (10, '방탄조끼소년단', '2013-06-13', '아미');

INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (20, '뉴진스', '2022-07-22', '버니즈');

INSERT INTO TBL_GROUP (GROUP_NO, GROUP_NAME, DEBUT_DATE, FANDOM_NAME) 
VALUES (30, '아이브', '2021-12-01', '다이브');

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


