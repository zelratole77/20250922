package web.com.springweb.a02_mvc.a02_Meet;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface A03_Meet_Dao {

	@Select("SELECT * FROM BLIND_DATE \r\n"
			+ "WHERE partner_name LIKE #{partnerName} \r\n"
			+ "AND location LIKE #{location}")
	List<A04Meet> getBlindDate(A04Meet sch);
	
	
	@Select("SELECT * FROM BLIND_DATE WHERE date_no = #{dateNo}")
	A04Meet getMeet(@Param("dateNo") int dateNo);
	
		
	@Update("	UPDATE BLIND_DATE\r\n"
			+ "	   SET PARTNER_NAME=#{partnerName},\r\n"
			+ "	       PARTNER_AGE = #{partnerAge},\r\n"
			+ "	       LOCATION = #{location},\r\n"
			+ "	       MEET_DATE = #{meetDate},\r\n"
			+ "	       STATUS = #{status},\r\n"
			+ "	       SCORE = #{score},\r\n"
			+ "	       REVIEW = #{review}\r\n"
			+ "	 WHERE DATE_NO =#{dateNo}")
	int updateBlindDate(A04Meet upt); 
	
	 	

	@Delete("DELETE FROM BLIND_DATE WHERE  DATE_NO = #{dateNo}")
	int deleteBlindDate(@Param("dateNo") int dateNo); 	
	
}
