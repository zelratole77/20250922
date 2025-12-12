package web.com.springweb.z01_dto;

public class Hero {
	private int id;
	private String name;
	private int power;
	private String city;
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	public Hero(int id, String name, int power, String city) {
		this.id = id;
		this.name = name;
		this.power = power;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
