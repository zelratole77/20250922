package web.com.springweb.a02_mvc.a02_Meet;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_Meet_Dao {

	@Select("SELECT * FROM BLIND_DATE \r\n"
			+ "WHERE partner_name LIKE #{partnerName} \r\n"
			+ "AND location LIKE #{location}")
	List<A04Meet> getBlindDate(A04Meet sch);
	
	
	@Select("SELECT * FROM BLIND_DATE WHERE date_no = #{dateNo}")
	A04Meet getMeet(@Param("dateNo") int dateNo);
	
}
