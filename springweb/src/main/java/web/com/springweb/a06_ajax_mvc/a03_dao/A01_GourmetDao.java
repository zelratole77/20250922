package web.com.springweb.a06_ajax_mvc.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.a06_ajax_mvc.dto.GourmetStore;

@Mapper
public interface A01_GourmetDao {
	@Select("	SELECT id, name, category,  keyword, rating \r\n"
			+ "	FROM GOURMET_STORE WHERE name LIKE #{name} and keyword LIKE #{keyword} "
			+ " ORDER BY ID DESC ")
	List<GourmetStore> getGourmetList(GourmetStore sch);

	@Insert("	INSERT INTO GOURMET_STORE VALUES (GOURMET_SEQ.NEXTVAL, #{name}, "
				+ "#{category}, #{keyword}, \r\n"
				+ "#{description}, #{rating}, SYSDATE)")	
	int insertGourmet(GourmetStore ins);	
}
