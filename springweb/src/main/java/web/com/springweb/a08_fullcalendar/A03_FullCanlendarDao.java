package web.com.springweb.a08_fullcalendar;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import web.com.springweb.a07_fullcalendar.Calendar;

@Mapper
public interface A03_FullCanlendarDao {
	@Select("SELECT ID, TITLE, START1 \"START\", END1 \"END\", BACKGROUND_COLOR,\r\n"
			+ "TEXT_COLOR, ALL_DAY,ROOM_NAME, WRITER, CONTENT, MEMBERS\r\n"
			+ "FROM CALENDAR_ROOM")
	List<CalendarRoom> calendarList();

	@Insert("insert into CALENDAR_ROOM values(cal_seq.nextval, #{title},#{start},#{end},\r\n"
			+ "	#{backgroundColor},#{textColor},#{allDay},#{roomName},#{writer},#{content},#{members} )")
	int insertCalendar(CalendarRoom ins);		
}
