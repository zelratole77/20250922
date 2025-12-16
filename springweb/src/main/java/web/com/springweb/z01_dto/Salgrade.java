package web.com.springweb.z01_dto;

public class Salgrade {
	private int grade;
	private int losal;
	private int hisal;
	
	public Salgrade() {
		// TODO Auto-generated constructor stub
	}
	public Salgrade(int grade, int losal, int hisal) {
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLosal() {
		return losal;
	}
	public void setLosal(int losal) {
		this.losal = losal;
	}
	public int getHisal() {
		return hisal;
	}
	public void setHisal(int hisal) {
		this.hisal = hisal;
	}
	
}
