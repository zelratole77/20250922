package web.com.springweb.a07_fullcalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// http://localhost:5050/insertCalendar
	@PostMapping("insertCalendar")
	public ResponseEntity<?> insertCalendar(Calendar ins) {
		return ResponseEntity.ok(service.insertCalendar(ins));
	}
	
	// http://localhost:5050/updateCalendar
	@PutMapping("updateCalendar")	
	public ResponseEntity<?>  updateCalendar(@RequestBody Calendar upt) {
		
		return ResponseEntity.ok(service.updateCalendar(upt));
	}
	// http://localhost:5050/deleteCalendar
	@DeleteMapping("deleteCalendar")	
	public ResponseEntity<?> deleteCalendar(@RequestParam("id") int id) {
		
		return ResponseEntity.ok(service.deleteCalendar(id));
	}
		
}
