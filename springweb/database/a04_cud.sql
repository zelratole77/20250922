SELECT * FROM dept01;
ALTER TABLE dept01
 MODIFY (dname varchar2(50), loc varchar2(50) );
-- 등록 처리
INSERT INTO dept01 values(50,'회계','수원');
-- 등록 /수정/삭제는  처리된 데이터 건수를 정수로 리턴한다..
-- 입력 데이터 매개변수만 처리..
/*
@Insert("INSERT INTO dept01 values(#{deptno},#{dname},#{loc})")
int insertDept01(Emp ins);
 * */

SELECT * FROM idols;
INSERT INTO idols values(109,'갓세븐', 2020, 5, null);
/*
110,"강다니엘",2019,6,null
class Idol{
	private int idolid;
	private int name;
	private int debutyear;
	private int groupid;
	private int sunbaeid;
}
입력: Idol
리턴값 : 등록건수 int
@Insert("INSERT INTO idols values(#{idolid}, #{name}, #{debutyear}, #{groupid}, #{sunbaeid})")
int insertIdol(Idol ins);


*
**/
SELECT * FROM DEPT01;
UPDATE DEPT01 
   SET DNAME = '회계2',
       LOC = '수원2'
 WHERE DEPTNO = 50;
/*
입력매개변수 : String dname, String loc, int deptno ==> Dept
리턴유형 : 등록/수정/삭제 처리된 데이터 return int
UPDATE DEPT01 
   SET DNAME = #{dname},
       LOC = #{loc}
 WHERE DEPTNO = #{deptno}
@Update("")
int updateDept01(Dept upt);

 * */
SELECT * FROM EMP01;
UPDATE EMP01
   SET SAL = 3000,
       COMM = 100
 WHERE DEPTNO = 30; 
ALTER TABLE EMP01 
RENAME COLUMN salary TO sal;
/*
DAO 메서드 선언..
UPDATE EMP01
   SET SAL = #{sal},
       COMM = #{comm}
 WHERE DEPTNO = #{deptno}
 
@Update("")
int updateEmp01(Emp upt);
 


SERVICE 처리 
결과확인..
 * */
SELECT * FROM EMP01;
WHERE EMPNO = 7521;
//DELETE FROM EMP01 WHERE EMPNO = #{empno};
/*
@Delete("DELETE FROM EMP01 WHERE EMPNO = #{empno}")
int deleteEmp01(@Param("empno") int empno);


EX) 부서번호로 부서정보 삭제 DAO SERVICE 처리..
@Delete("DELETE FROM DEPT01 WHERE DEPTNO = #{deptno}")
int deleteDept01(@Param("deptno") int deptno);

 * */
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO = 60;

       






