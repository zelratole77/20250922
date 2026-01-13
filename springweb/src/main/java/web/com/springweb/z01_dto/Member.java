package web.com.springweb.z01_dto;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private int point;
	private String auth;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String pwd, String name, int point, String auth) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.point = point;
		this.auth = auth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
