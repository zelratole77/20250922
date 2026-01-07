package web.com.springweb.a07_fullcalendar;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface A03_CalendarDao {

	@Select("	SELECT ID, TITLE, START1 \"START\", END1 \"END\", BACKGROUND_COLOR,\r\n"
			+ "	TEXT_COLOR, ALL_DAY, URL_LINK, WRITER, CONTENT\r\n"
			+ "	FROM CALENDAR")
	List<Calendar> calendarList();
	
}
