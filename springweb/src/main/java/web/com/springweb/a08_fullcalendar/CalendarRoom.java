package web.com.springweb.a08_fullcalendar;

public class CalendarRoom {
	
    private int id;
    private String title;
    private String start;           // FullCalendar의 start 속성 대응
    private String end;             // FullCalendar의 end 속성 대응
    private String backgroundColor;
    private String textColor;
    private boolean allDay;         // DB의 0/1을 boolean으로 변환
    private String roomName;        // 회의실 구분
    private String writer;
    private String content;
    private String members;
	public CalendarRoom() {
		// TODO Auto-generated constructor stub
	}
	public CalendarRoom(int id, String title, String start, String end, String backgroundColor, String textColor,
			boolean allDay, String roomName, String writer, String content, String members) {
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.allDay = allDay;
		this.roomName = roomName;
		this.writer = writer;
		this.content = content;
		this.members = members;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public boolean isAllDay() {
		return allDay;
	}
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
    
}
