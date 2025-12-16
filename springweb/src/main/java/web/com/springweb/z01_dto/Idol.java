package web.com.springweb.z01_dto;

public class Idol {
	private int idolid;
	private String name;
	private int debutyear;
	private int groupid;
	private int sunbaeid;
	public Idol() {
		// TODO Auto-generated constructor stub
	}
	public Idol(int idolid, String name, int debutyear, int groupid, int sunbaeid) {
		this.idolid = idolid;
		this.name = name;
		this.debutyear = debutyear;
		this.groupid = groupid;
		this.sunbaeid = sunbaeid;
	}
	public int getIdolid() {
		return idolid;
	}
	public void setIdolid(int idolid) {
		this.idolid = idolid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDebutyear() {
		return debutyear;
	}
	public void setDebutyear(int debutyear) {
		this.debutyear = debutyear;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getSunbaeid() {
		return sunbaeid;
	}
	public void setSunbaeid(int sunbaeid) {
		this.sunbaeid = sunbaeid;
	}
	
}
