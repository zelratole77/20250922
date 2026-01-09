-- 추가 데이터 20건 (IT기술, 에러질문, 스터디, 일상 등)

INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'GitHub Merge 충돌 해결 도와주세요', '같은 파일을 수정했더니 충돌이 났습니다.', 'git초보', 3, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '주말 자바 스터디원 모집합니다', '강남역 토즈, 매주 토요일 오전 10시', '스터디장', 45, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '[필독] 서버 정기 점검 안내', '금일 밤 12시부터 2시간 동안 접속이 제한됩니다.', '관리자', 250, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'CSS Flexbox 정렬이 안 먹혀요', 'justify-content: center 했는데 그대로입니다.', '퍼블리셔', 11, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '중고 모니터 팝니다 (24인치)', '상태 깨끗합니다. 쪽지 주세요.', '판매왕', 8, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'ORA-00904 에러 원인이 뭘까요?', '부적합한 식별자라고 뜨는데 컬럼명은 맞거든요.', 'DB새싹', 17, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'JSP에서 EL태그가 적용이 안됩니다', 'isELIgnored 설정 확인해야 하나요?', '웹개발자', 5, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '오늘의 야식 추천 받음', '치킨 vs 피자 vs 족발', '배고파', 33, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'IntelliJ vs Eclipse 논쟁', '현업에서는 무엇을 더 많이 쓰나요?', '취준생', 88, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'AWS EC2 배포 성공했습니다!', '리눅스 명령어 때문에 고생 좀 했네요.', '클라우드', 21, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'NullPointerException 지긋지긋하네요', '객체 null 체크 꼼꼼히 합시다.', '자바킹', 40, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'React랑 Vue 중에 뭐부터 배울까요?', '프론트엔드 입문자입니다.', '고민중', 19, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '분실물 습득: 에어팟 케이스', '302호 강의실 책상 위에 있었습니다.', '착한사람', 6, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'SQL 튜닝 관련 좋은 강의 있나요?', '대용량 데이터 처리가 느려서요.', 'DBA지망', 14, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '다들 키보드 뭐 쓰세요?', '기계식 키보드 입문하려고 합니다.', '장비욕심', 52, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '비밀번호 변경 캠페인', '3개월 이상 변경하지 않은 분들은 변경 바랍니다.', '보안팀', 99, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '알고리즘 코딩테스트 준비 팁', '백준 vs 프로그래머스 어디가 좋나요?', '코테광탈', 27, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '리눅스 vi 에디터 종료하는 법 ㅠㅠ', '저장이 안되고 못 나가고 있어요.', '리눅스1일', 105, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, 'Spring Security 설정 너무 복잡해요', '로그인 기능 구현 중인데 막히네요.', '시큐리티', 9, SYSDATE, SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 0, '팀 프로젝트 주제 선정 투표', '1.쇼핑몰 2.커뮤니티 3.예약시스템', '팀장', 30, SYSDATE, SYSDATE);

-- 트랜잭션 확정
COMMIT;


-- 번호 제목 작성자 작성일 조회수
-- 작성자와 제목을 기준으로 검색..
-- sql ==> dto 
/*
no refno subject... ==> Dto  하나의 행
class Board{
	private int no;
	private int refno;
	private String subject;
	private String content;
	private String writer;
	private int readcnt;
	private Date regdte;
	private Date uptdte;
}
==> 여러개의 행  List
@Select("SELECT * FROM BOARD WHERE WRITER LIKE #{writer} AND SUBJECT LIKE #{subject}")
List<Board> boardList(Board sch);

검색에 필요한 key subject, writer => Dto

 * */
-- dao
-- 
--------------------------------------
-- service
-- controller
-- 뷰단 처리..
SELECT * FROM BOARD WHERE WRITER LIKE '%%' AND SUBJECT LIKE '%%';



