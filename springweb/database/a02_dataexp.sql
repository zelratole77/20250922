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
/*
SELECT EMPNO FROM EMP WHERE JOB='SALESMAN' 직책별로 사원번호를 검색..
 * */
SELECT EMPNO FROM EMP WHERE JOB='SALESMAN';
/*
입력 : SALESMAN ==> 문자열  ==> 매개변수 처리 : @Param("job") String job
출력 : int 배열 ==> List<Integer> ==> 리턴값 처리

@Select("SELECT EMPNO FROM EMP WHERE JOB=#{job}")
List<Integer> getEmpnosByJob(Param("job") String job);


**/

/*
# 단일 데이터 요청으로 여러 개의 다른 속성의 값을 처리
1. 부서번호 10으로 여러가지 다양한 속성명과 데이터 유형을 가진 데이터를 열단위로 출력
2. 입력과 리턴값을 정리
	1) 입력 : 10 ==>  int ==> 매개변수 : @Param("deptno") int deptno
	2) 리턴값 : 10 ACCOUNTING  NEW YORK ==> 다른 이름에 다른 유형으로 3가지 데이터를 담을 수 있는 데이터?
		==> 객체( class 선으로 해당 이름과 유형에 맞게 선언 )
		class Dept{
			private int deptno;  // 유형 컬럼명에 맞게 선
			private String dname;
			private String loc;
		}
	3) 메서드 선언
@Select("SELECT * FROM DEPT WHERE DEPTNO = #{deptno}")
Dept getDept(@Param("deptno") int deptno);		
 * */
SELECT * FROM DEPT WHERE DEPTNO = 10;



