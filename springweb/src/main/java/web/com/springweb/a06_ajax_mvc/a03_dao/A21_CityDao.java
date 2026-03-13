package web.com.springweb.a06_ajax_mvc.a03_dao;

import org.apache.ibatis.annotations.*;
import web.com.springweb.a06_ajax_mvc.dto.City;

import java.util.List;

@Mapper
public interface A21_CityDao {
	@Select("SELECT * FROM city WHERE CITY_NAME LIKE #{cityName} AND COUNTRY LIKE #{country} "
			+ "ORDER BY CITY_ID DESC")
	List<City> getCityList(City sch);
	
	@Insert("INSERT INTO city VALUES (CITY_SEQ.NEXTVAL,#{cityName}, #{country}, #{population}, #{area}, #{foundedDate} )")
	int insertCity( City ins);
	
	@Select("SELECT * FROM city WHERE CITY_ID = #{cityId}")
	City getCity(@Param("cityId") int cityId);

	@Update("	UPDATE city\r\n"
			+ "	   SET CITY_NAME=#{cityName},\r\n"
			+ "	       COUNTRY = #{country},\r\n"
			+ "	       POPULATION = #{population},\r\n"
			+ "	       AREA = #{area},\r\n"
			+ "	       FOUNDED_DATE = #{foundedDate}\r\n"
			+ "	  WHERE CITY_ID = #{cityId}")
	int updateCity(City upt);
	
	@Delete("DELETE FROM city WHERE CITY_ID = #{cityId}")
	int deleteCity( @Param("cityId") int cityId );
}
