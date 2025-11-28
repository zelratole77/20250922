package web.com.springweb.a02_mvc;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface A03_MVC_Dao {
	
	@Select("SELECT * FROM DEPT")
	List<Dept> getDeptList();
	

}
