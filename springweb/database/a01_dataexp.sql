SELECT COUNT(*) FROM EMP;
/*
==> 메서드를 생성..
출력결과 14 ==> 데이터 int ==> 메서드의 리턴유형으로 설정..
이름은 중복되지 않게 적절한 이름으로 선언 후, dao인터페이스에 처리
int getCountEmp();    
==> sql 처리 내용과 설정 ;(세미콜론은 빼기)
@Select("SELECT COUNT(*) FROM EMP")
int getCountEmp(); 

ex) 부서정보의 갯수를 sql로 처리하고 dao단에 처리한 코드를 정리해보세요..
4 ==> int ==> 리턴유형
@Select("SELECT COUNT(*) FROM DEPT")
int getDeptCount();

 * */
SELECT COUNT(*) FROM DEPT;
/*
* ex1) 사원정보에서 최고급여를 출력
@Select("SELECT MAX(SAL) FROM EMP")
double getMaxSal();

ex2) 사원정보에서 사원번호가 7369인 사원명
@Select("SELECT ENAME FROM EMP WHERE EMPNO = 7369")
String getEnameByEmpno();
* ex3) 사원정보에서 입사일이 가장 빠른 입사일.
@Select("SELECT MIN(HIREDATE) FROM EMP")
Date getInitHiredate();


*ex4) ename이 'SMITH'인 사원의 직책(job) 
@Select("SELECT JOB FROM EMP WHERE ENAME = 'SMITH'")
String getEnameByJob();

ex5) ename이 'WARD'인 사원번호
@Select("SELECT EMPNO FROM EMP WHERE ENAME='WARD'")
int getEmpnoByEname();

 * */
SELECT EMPNO FROM EMP WHERE ENAME='WARD';
SELECT JOB FROM EMP WHERE ENAME = 'SMITH';
SELECT MIN(HIREDATE) FROM EMP;
SELECT MAX(SAL) FROM EMP; -- 리턴유형 실수 ==> double
SELECT ENAME FROM EMP WHERE EMPNO = 7369;

SELECT * FROM EMP;

--- 리스트 형 데이터 처리 : 컬럼은 1개, 행단위 데이터가 나오는 내용
-- 리턴할 데이터 List<String>
/*
@Select("SELECT ENAME FROM EMP")
List<String> getEnames();

service단에서 확인하는데까지(반복문)
*ex1) 급여가 2000~5000사이의 사원명 처리
ex2) 직책(job)이 SALESMAN인 사원의 입사일 처리
ex3) 관리자번호(mgr)이 7698인 사원의 사원번호(empno) 처리
ex4) 부서번호가 30인 사원의 급여 처리
 * */
SELECT * FROM EMP;








