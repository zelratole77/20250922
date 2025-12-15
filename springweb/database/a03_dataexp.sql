SELECT * FROM EMP;
-- 여러가지 매개변수를 통해서 데이터 처리하기
-- 1) 각각의 매개변수
SELECT * FROM EMP WHERE SAL BETWEEN 1000 AND 2000;
/*
입력: 1000, 2000 ==> int, int ==> 매개변수 선언 @Param("start") int start, @Param("end") int end
리턴값: empno, ename, job, mgr, hiredate, sal.. ==> Emp ==> 여러행 ==> List<Emp>
==> dao단에 선언할 매서드 정의
@Select("SELECT * FROM EMP WHERE SAL BETWEEN #{start} AND #{end}")
List<Emp> empList(@Param("start") int start, @Param("end") int end);

*ex1) 부서번호 10, 30을 검색하는 부서정보 출력  SELECT * FROM DEPT WHERE DEPTNO IN(10,30)
입력 : 10, 30 ==> int, int ==> @Param("deptno1") int deptno1, @Param("deptno2") int deptno2)
리턴 : deptno, dname, loc, ==> Dept ==> List
@Select("SELECT * FROM DEPT WHERE DEPTNO IN(#{deptno1},#{deptno2})")
List<Dept> getDept01(@Param("deptno1") int deptno1, @Param("deptno2") int deptno2);
*
*ex2) 사원번호를 기준으로 7400~7600사이의 사원정보 출력  
		SELECT * FROM EMP WHERE EMPNO BETWEEN 7400 AND 7600
입력값 @Param("empno1") int empno1, @Param("empno2") int empno2
리턴값 List<Emp>

@Select("SELECT * FROM EMP WHERE EMPNO BETWEEN #{empno1} AND #{empno2}")
List<Emp> empList2(	@Param("empno1") int empno1, @Param("empno2") int empno2 );

ex3) 직책이 SALESMAN 이거나 부서번호가 10인 사원정보 출력..
==> 위 내용을 처리하는 매개변수가 다중인 MAPPER 메서드 선언..
@Select("SELECT * FROM EMP WHERE JOB = #{job} OR DEPTNO = #{deptno}")
List<Emp> empList3(@Param("job") String job, @Param("deptno") int deptno);

 * */
SELECT * FROM EMP WHERE JOB = 'SALESMAN' OR DEPTNO = 10;



SELECT * FROM EMP WHERE EMPNO BETWEEN 7400 AND 7600;

-- 2) Map형태 매개변수 처리



-- 3) Dto 객체를 통한 처리..