package a01_diexp.vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Pet {
	
	private String name;
	
	// 같은 컨테이너에 객체가 있으면 자동으로 할당처리, 
	// 만약 객체가 없으면 에러는 발생하지 않게..
	// 컨테이너 안에 객체가 없더라도 에러발생 방지..
	@Autowired(required=false)  
	private PetOwner petOwner;
	
	public Pet() {
		// TODO Auto-generated constructor stub
	}
	
	public Pet(String name) {
		this.name = name;
	}

	public Pet(String name, PetOwner petOwner) {
		this.name = name;
		this.petOwner = petOwner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetOwner getPetOwner() {
		return petOwner;
	}
	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}
	
}
