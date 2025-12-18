package web.com.springweb.a02_mvc.a01_idol;

import java.util.Date;
// groupNo groupName debutDate fandomName
public class A04Group {
	private int groupNo;
	private String groupName;
	private Date debutDate;  // <input type="date" name="debutDate" 요청처리하더라도 문자열로 전달되어 Date 형식과
							// 맞지 않다.. 그래서, 전역적으로 spring 자동으로 yyyy-MM-dd형식의 문자열 Date로 변환 처리
							// 속성 설정을 할 수 있다. 
	private String fandomName;
	
	public A04Group() {
		// TODO Auto-generated constructor stub
	}
	
	public A04Group(int groupNo, String groupName, Date debutDate, String fandomName) {
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.debutDate = debutDate;
		this.fandomName = fandomName;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Date getDebutDate() {
		return debutDate;
	}
	public void setDebutDate(Date debutDate) {
		this.debutDate = debutDate;
	}
	public String getFandomName() {
		return fandomName;
	}
	public void setFandomName(String fandomName) {
		this.fandomName = fandomName;
	}
	
	
	
}
