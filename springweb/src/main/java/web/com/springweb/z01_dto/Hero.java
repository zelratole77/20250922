package web.com.springweb.z01_dto;

public class Hero {
	private int heroCode;
	private String heroName;
	private String email;
	private int age;
	public Hero() {
		// TODO Auto-generated constructor stub
	}
	
	public Hero(String heroName, int age) {
		this.heroName = heroName;
		this.age = age;
	}

	public Hero(int heroCode, String heroName, String email, int age) {
		this.heroCode = heroCode;
		this.heroName = heroName;
		this.email = email;
		this.age = age;
	}

	public int getHeroCode() {
		return heroCode;
	}

	public void setHeroCode(int heroCode) {
		this.heroCode = heroCode;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
