package web.com.springweb.a03_database;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.a02_mvc.Dept;

@Mapper
public interface A03_DBDao {
	// public 생략..
	@Select("SELECT COUNT(*) FROM EMP")
	int getCountEmp();
	
	@Select("SELECT COUNT(*) FROM DEPT")
	int getDeptCount();	
	
	@Select("SELECT MAX(SAL) FROM EMP")
	double getMaxSal();	
	
	@Select("SELECT ENAME FROM EMP WHERE EMPNO = 7369")
	String getEnameByEmpno();

	@Select("SELECT MIN(HIREDATE) FROM EMP")
	Date getInitHiredate();
	
	@Select("SELECT JOB FROM EMP WHERE ENAME = 'SMITH'")
	String getEnameByJob();	

	@Select("SELECT EMPNO FROM EMP WHERE ENAME='WARD'")
	int getEmpnoByEname();
	
	@Select("SELECT ENAME FROM EMP")
	List<String> getEnames();

	@Select("SELECT ENAME FROM EMP WHERE SAL BETWEEN 2000 AND 5000")
	List<String> getEnamesBySal();
	
	@Select("SELECT HIREDATE FROM EMP WHERE JOB = 'SALESMAN'")
	List<Date> getHiredates();	
	
	@Select("SELECT EMPNO FROM EMP WHERE MGR = 7698")
	List<Integer> getEmpnoByMgr();
	
	@Select("SELECT SAL FROM EMP WHERE DEPTNO = 30")
	List<Double> getSalByDeptno();	

	@Select("SELECT COUNT(*) FROM EMP WHERE DEPTNO=#{deptno}")
	int getCountByDeptno(@Param("deptno") int deptno);	

	@Select("SELECT ENAME FROM EMP WHERE DEPTNO=#{deptno}")
	List<String> getEnamesByDeptno1(@Param("deptno") int deptno);
		
	@Select("SELECT EMPNO FROM EMP WHERE JOB=#{job}")
	List<Integer> getEmpnosByJob(@Param("job") String job);	

	@Select("SELECT * FROM DEPT WHERE DEPTNO = #{deptno}")
	Dept getDept(@Param("deptno") int deptno);		
	
}
