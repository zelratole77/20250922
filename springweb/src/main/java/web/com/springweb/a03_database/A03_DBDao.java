package web.com.springweb.a03_database;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.a02_mvc.Dept;
import web.com.springweb.z01_dto.Emp;
import web.com.springweb.z01_dto.Hero;

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
	
	@Select("SELECT * FROM HERO_LIST WHERE NAME LIKE #{name} ")
	List<Hero> getHero(@Param("name") String name);	
	
	@Select("SELECT * FROM EMP WHERE SAL BETWEEN #{start} AND #{end}")
	List<Emp> empList(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT * FROM EMP WHERE SAL BETWEEN #{start} AND #{end}")
	List<Emp> empList4(Map map);
	// dao.empList(1000,3000);
	// dao.empList4(map1);
	// dao.getDept01(10,20);
	// dao.getDept02(map2); 

	@Select("SELECT * FROM DEPT WHERE DEPTNO IN(#{deptno1},#{deptno2})")
	List<Dept> getDept01(@Param("deptno1") int deptno1, @Param("deptno2") int deptno2);
	
	@Select("SELECT * FROM DEPT WHERE DEPTNO IN(#{deptno1},#{deptno2})")
	List<Dept> getDept02(Map map);	
	
	
	@Select("SELECT * FROM EMP WHERE EMPNO BETWEEN #{empno1} AND #{empno2}")
	List<Emp> empList2(	@Param("empno1") int empno1, @Param("empno2") int empno2 );
	// map형식으로  empList5
	@Select("SELECT * FROM EMP WHERE JOB = #{job} OR DEPTNO = #{deptno}")
	List<Emp> empList3(@Param("job") String job, @Param("deptno") int deptno);	
	// map형식으로  empList6
	// 서비스단 호출..
	
	
	
	
	
}
