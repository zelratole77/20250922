package web.com.springweb.a08_fullcalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class A01_FullCalenderController {
	@Autowired(required=false)
	private A02_FullCanlendarService service;
	
	
	// 초기화면 로딩
	// http://localhost:5050/fullCalendarRoom
	@GetMapping("fullCalendarRoom")
	public String fullCalendarList() {
		
		return "a08_ajax\\a09_calendar";
	}
	// http://localhost:5050/fullCalendarRoomList
	@GetMapping("fullCalendarRoomList")
	public ResponseEntity<?> fullCalendarRoomList() {
		
		return ResponseEntity.ok(service.calendarList());
	}	
	// http://localhost:5050/insertCalendar
	@PostMapping("insertCalendar")
	public ResponseEntity<?> insertCalendar(CalendarRoom ins) {
		
		return ResponseEntity.ok(service.insertCalendar(ins));
	}
	
}
