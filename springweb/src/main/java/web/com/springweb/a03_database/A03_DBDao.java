package web.com.springweb.a03_database;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_DBDao {
	// public 생략..
	@Select("SELECT COUNT(*) FROM EMP")
	int getCountEmp(); 
}
