package web.com.springweb.a08_fullcalendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A01_FullCalenderController {
	// 초기화면 로딩
	// http://localhost:5050/calendarList
	@GetMapping("calendarList")
	public String calendarList() {
		
		return "a08_ajax\\a09_calendar";
	}
}
