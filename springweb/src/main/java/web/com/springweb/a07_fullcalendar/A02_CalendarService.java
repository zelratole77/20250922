package web.com.springweb.a07_fullcalendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_CalendarService {
	
	@Autowired(required=false)
	private A03_CalendarDao dao;
	
	public List<Calendar> calendarList(){
		
		return dao.calendarList();
	}
	public String insertCalendar(Calendar ins) {
		
		return dao.insertCalendar(ins)>0?"등록 성공":"등록 실패";
	}
}
