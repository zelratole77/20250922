package web.com.springweb.a03_database;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import web.com.springweb.a02_mvc.Dept;
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
	
}
