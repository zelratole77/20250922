package web.com.springweb.a03_database;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import web.com.springweb.a02_mvc.Dept;

@Mapper
public interface A04_CUDDao {

	@Insert("INSERT INTO dept01 values(#{deptno},#{dname},#{loc})")
	int insertDept01(Dept ins);
}
