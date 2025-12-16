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
SELECT * FROM EMP;
-- 부서번호와 직책을 기준으로 검색 처리하는 형태
SELECT * 
FROM EMP 
WHERE JOB = 'SALESMAN' 
OR DEPTNO = 20;
/*
입력값(파라미터) : 문자열 job, 정수형 deptno ==> set/get job, deptno ==> class Emp
출력값(리턴값) : 사원정보 전체(Emp)  ==> 다중행 List ==> List<Emp>

@Select("SELECT * 
FROM EMP 
WHERE JOB = #{job} 
OR DEPTNO = #{deptno}")   
List<Emp> getEmpList10(Emp sch);  
#{job}, #{deptno}  ==> Emp객체의 getJob(), getDeptno() 호출하여 처리되는 형식..



SELECT * 
FROM EMP 
WHERE JOB = #{job} 
OR DEPTNO = #{deptno}


SELECT * 
FROM EMP 
WHERE JOB = #{job} 
OR DEPTNO = #{deptno}
 * */
SELECT * FROM DEPT;
-- *EX1) 부서번호 또는 부서명으로 검색되는 부서정보 리스트 DAO 메서드 선언..
/*
입력값: DEPTNO, DNAME ==> Dept
리턴값 : Dept ==> List ==> List<Dept>
SELECT * 
FROM DEPT 
WHERE DEPTNO = #{deptno} 
OR DNAME = #{dname}


@Select("")
List<Dept> getDeptList(Dept sch);
 *  * */
SELECT * FROM DEPT WHERE DEPTNO = 10 OR DNAME = 'SALES';


	@Select("	SELECT * \r\n"
			+ "	FROM DEPT \r\n"
			+ "	WHERE DEPTNO = #{deptno} \r\n"
			+ "	OR DNAME = #{dname}")
	List<Dept> getDeptList(Dept sch);
/*
	@Select("	SELECT * \r\n"
			+ "	FROM DEPT \r\n"
			+ "	WHERE DEPTNO = #{deptno} \r\n"
			+ "	OR DNAME = #{dname}")
	List<Dept> getDeptList(Dept sch);
**/	
-- EX2) 히로우 코드 또는 나이로 검색되는 히로우정보 리스트 DAO 메서드 선언(dto 추가..)
SELECT * FROM HERO WHERE AGE = 40 OR HERO_NAME='트로우';
/*
@Select("
SELECT * FROM HERO 
WHERE AGE = #{age} OR HERO_NAME=#{heroName}
")
List<Hero> getHeros(Hero sch);
class Hero{
	private int heroCode;
	private String heroName;
	private String email;
	private int age;
	
}
 * */
-- EX3) SALGRADE 테이블의 최저금액과 최고금액을 통한 SALGRADE단일 행 정보 가져오는 DAO메서드 선언.(dto 추가..)


SELECT * FROM HERO;
SELECT * FROM SALGRADE;
SELECT * FROM ORDERS;
/*
impdp system/1111@//localhost:1521/XEPDB1 DIRECTORY=DATA_PUMP_DIR DUMPFILE=scott_backup.dmp LOGFILE=scott_import.log SCHEMAS=SCOTT TABLE_EXISTS_ACTION=REPLACE

 * */






