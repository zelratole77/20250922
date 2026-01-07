package web.com.springweb.a07_fullcalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_CalendarController {
	@Autowired(required=false)
	private A02_CalendarService service;
	

	// http://localhost:5050/calendar
	@GetMapping("calendar")
	public String getCalendar() {
		return "a08_ajax\\a08_calendar";
	}
	// http://localhost:5050/calendarList
	@GetMapping("calendarList")
	public ResponseEntity<?> calendarList(){
		return ResponseEntity.ok(service.calendarList());
	}
	
	
	
}
