package web.com.springweb.a02_mvc.a01_idol;

import java.util.Date;

public class A04Group {
	private int groupNo;
	private String groupName;
	private Date debutDate;
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
