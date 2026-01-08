package web.com.springweb.a08_fullcalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	// http://localhost:5050/insertCalendarRoom
	@PostMapping("insertCalendarRoom")
	public ResponseEntity<?> insertCalendarRoom(CalendarRoom ins) {
		
		return ResponseEntity.ok(service.insertCalendarRoom(ins));
	}
	// http://localhost:5050/updateCalendarRoom
	@PutMapping("updateCalendarRoom")
	public ResponseEntity<?> updateCalendarRoom(@RequestBody CalendarRoom upt) {
		
		return ResponseEntity.ok(service.updateCalendarRoom(upt));
	}
	// http://localhost:5050/deleteCalendarRoom
	@PostMapping("deleteCalendarRoom")
	public ResponseEntity<?> deleteCalendarRoom(@RequestParam("id") int id) {
		
		return ResponseEntity.ok(service.deleteCalendarRoom(id));
	}	
	
	
}
