package a01_diexp.vo;

public class Student {
	private String name;
	private StudentCard card;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name) {
		this.name = name;
	}

	public Student(String name, StudentCard card) {
		this.name = name;
		this.card = card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentCard getCard() {
		return card;
	}
	public void setCard(StudentCard card) {
		this.card = card;
	}
	
}
