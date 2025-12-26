package a01_diexp.vo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private String model;
	@Autowired(required=false)
	private Engine engine;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
