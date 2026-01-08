package web.com.springweb.a08_fullcalendar;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



@Mapper
public interface A03_FullCanlendarDao {
	@Select("SELECT ID, TITLE, START1 \"START\", END1 \"END\", BACKGROUND_COLOR,\r\n"
			+ "TEXT_COLOR, ALL_DAY,ROOM_NAME, WRITER, CONTENT, MEMBERS\r\n"
			+ "FROM CALENDAR_ROOM")
	List<CalendarRoom> calendarList();

	@Insert("insert into CALENDAR_ROOM values(cal_seq.nextval, #{title},#{start},#{end},\r\n"
			+ "	#{backgroundColor},#{textColor},#{allDay},#{roomName},#{writer},#{content},#{members} )")
	int insertCalendarRoom(CalendarRoom ins);		

	@Update("	UPDATE calendar_room \r\n"
			+ "	   SET TITLE=#{title},\r\n"
			+ "	       START1 = #{start},\r\n"
			+ "	       END1 = #{end},\r\n"
			+ "	       BACKGROUND_COLOR = #{backgroundColor},\r\n"
			+ "	       TEXT_COLOR = #{textColor},\r\n"
			+ "	       ALL_DAY = #{allDay},\r\n"
			+ "	       WRITER = #{writer},\r\n"
			+ "	       CONTENT = #{content},\r\n"
			+ "	       ROOM_NAME = #{roomName},\r\n"
			+ "	       members = #{members}\r\n"
			+ "	 WHERE ID = #{id}")
	int updateCalendarRoom( CalendarRoom upt);
	
	@Delete("DELETE FROM calendar_room WHERE ID = #{id}")
	int deleteCalendarRoom(@Param("id") int id);

	
}
