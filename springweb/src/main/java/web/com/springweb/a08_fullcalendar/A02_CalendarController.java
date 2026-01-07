package web.com.springweb.a08_fullcalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A02_CalendarController {

	
	// http://localhost:5050/fullcalendar
	@GetMapping("fullcalendar")
	public String fullcalendar() {
		return "a08_ajax\\a10_calendar";
	}
}
