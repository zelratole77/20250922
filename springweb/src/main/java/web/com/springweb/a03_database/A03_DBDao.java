package web.com.springweb.a03_database;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
	
	
}
