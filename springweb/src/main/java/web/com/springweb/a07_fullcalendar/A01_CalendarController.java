package web.com.springweb.a07_fullcalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_CalendarController {


	// http://localhost:5050/calendar
	@GetMapping("calendar")
	public String getCalendar() {
		return "a08_ajax\\a08_calendar";
	}
	
}
