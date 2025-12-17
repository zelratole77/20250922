package web.com.springweb.a03_database;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import web.com.springweb.a02_mvc.Dept;
import web.com.springweb.z01_dto.Emp;
import web.com.springweb.z01_dto.Idol;

@Mapper
public interface A04_CUDDao {

	@Insert("INSERT INTO dept01 values(#{deptno},#{dname},#{loc})")
	int insertDept01(Dept ins);
	
	@Insert("INSERT INTO idols values(#{idolid}, #{name}, #{debutyear}, "
			+ "                       #{groupid}, #{sunbaeid})")
	int insertIdol(Idol ins);
	
	@Update("UPDATE DEPT01 \r\n"
			+ "   SET DNAME = #{dname},\r\n"
			+ "       LOC = #{loc}\r\n"
			+ " WHERE DEPTNO = #{deptno}")
	int updateDept01(Dept upt);	
	
	@Update("UPDATE EMP01\r\n"
			+ "   SET SAL = #{sal},\r\n"
			+ "       COMM = #{comm}\r\n"
			+ " WHERE DEPTNO = #{deptno}")
	int updateEmp01(Emp upt);
	
	@Delete("DELETE FROM EMP01 WHERE EMPNO = #{empno}")
	int deleteEmp01(@Param("empno") int empno);	
	
	@Delete("DELETE FROM DEPT01 WHERE DEPTNO = #{deptno}")
	int deleteDept01(@Param("deptno") int deptno);
	
	
	
}
