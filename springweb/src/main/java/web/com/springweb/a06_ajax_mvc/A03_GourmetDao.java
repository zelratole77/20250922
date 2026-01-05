package web.com.springweb.a06_ajax_mvc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_GourmetDao {
	@Select("	SELECT id, name, category,  keyword, rating \r\n"
			+ "	FROM GOURMET_STORE WHERE name LIKE #{name} and keyword LIKE #{keyword}")
	List<GourmetStore> getGourmetList(GourmetStore sch);
}
