package web.com.springweb.a07_fullcalendar;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface A03_CalendarDao {

	@Select("	SELECT ID, TITLE, START1 \"START\", END1 \"END\", BACKGROUND_COLOR,\r\n"
			+ "	TEXT_COLOR, ALL_DAY, URL_LINK, WRITER, CONTENT\r\n"
			+ "	FROM CALENDAR")
	List<Calendar> calendarList();
	
	
	@Insert("insert into CALENDAR values(cal_seq.nextval, #{title},#{start},#{end},\r\n"
			+ "	#{backgroundColor},#{textColor},#{allDay},#{urlLink},#{writer},#{content} )")
	int insertCalendar(Calendar ins);		

	@Update("	UPDATE CALENDAR \r\n"
			+ "	   SET TITLE=#{title},\r\n"
			+ "	       START1 = #{start},\r\n"
			+ "	       END1 = #{end},\r\n"
			+ "	       BACKGROUND_COLOR = #{backgroundColor},\r\n"
			+ "	       TEXT_COLOR = #{textColor},\r\n"
			+ "	       ALL_DAY = #{allDay},\r\n"
			+ "	       URL_LINK = #{urlLink},\r\n"
			+ "	       WRITER = #{writer},\r\n"
			+ "	       CONTENT = #{content}\r\n"
			+ "	 WHERE ID = #{id}")
	int updateCalendar(Calendar upt);
	@Delete("DELETE FROM CALENDAR WHERE ID = #{id}")
	int deleteCalendar(@Param("id") int id);	
}
