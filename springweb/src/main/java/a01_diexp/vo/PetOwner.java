package a01_diexp.vo;
// 포함관계있는 VO객체(포함될 객체)
public class PetOwner {
	private String name;
	private int age;
	public PetOwner() {
		// TODO Auto-generated constructor stub
	}
	public PetOwner(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
