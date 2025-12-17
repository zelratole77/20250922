package web.com.springweb.a02_mvc.a01_idol;

public class A05Member {
	private int memberNo;
	private String realName;
	private String stageName;
	private String position;
	private double height;
	private int groupNo;
	public A05Member() {
		// TODO Auto-generated constructor stub
	}
	public A05Member(int memberNo, String realName, String stageName, String position, double height, int groupNo) {
		this.memberNo = memberNo;
		this.realName = realName;
		this.stageName = stageName;
		this.position = position;
		this.height = height;
		this.groupNo = groupNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getStageName() {
		return stageName;
	}
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	
	
}
