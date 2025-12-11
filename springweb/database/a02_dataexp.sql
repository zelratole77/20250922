SELECT COUNT(*) FROM EMP WHERE DEPTNO=20;
/*
결과값 : 5 ==> 리턴타입으로 int 
입력값 : 10/20.. ==> 매개변수 int ==> int deptno(정수형 부서번호) ==> DB에
	sql mapping   @Param("deptno") int deptno

@Select("SELECT COUNT(*) FROM EMP WHERE DEPTNO=#{deptno}")
int getCountByDeptno(@Param("deptno") int deptno);




 * */

SELECT * FROM emp;
/*
# 단일 요청으로 리스트형 데이터 처리.
1. sql 작성
2. 요청값 결정(입력값 ==> 매개변수 처리)
	int ==> @Param("deptno") int deptno
3. 결과값 확인(리턴유형 결정)
	List<String>
4. mapper 인터페이스 설정..
	@Select("SELECT ENAME FROM EMP WHERE DEPTNO=#{deptno}")
	List<String> getEnamesByDeptno1(@Param("deptno") int deptno);
	
5. service ==> controller(모델설정) ==> 화면 호출 처리..
 * */
SELECT ENAME FROM EMP WHERE DEPTNO=10;






