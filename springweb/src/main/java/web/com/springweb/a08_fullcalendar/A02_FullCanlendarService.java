package web.com.springweb.a08_fullcalendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.springweb.a07_fullcalendar.Calendar;

@Service
public class A02_FullCanlendarService {
	@Autowired(required=false)
	private A03_FullCanlendarDao dao;
	public List<CalendarRoom> calendarList(){
		return dao.calendarList();
	}
	
	public String insertCalendarRoom(CalendarRoom ins) {
		return dao.insertCalendarRoom(ins)>0?"회의실예약성공":"회의실예약실패";
	}
	public String updateCalendarRoom(CalendarRoom upt) {
		return dao.updateCalendarRoom(upt)>0?"회의실예약 수정성공":"회의실예약 수정실패";
	}
	public String deleteCalendarRoom(int id) {
		return dao.deleteCalendarRoom(id)>0?"회의실예약 삭제성공":"회의실예약 삭제실패";
	}

	
	
}
