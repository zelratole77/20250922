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
}
