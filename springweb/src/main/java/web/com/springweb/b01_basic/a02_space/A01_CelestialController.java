package web.com.springweb.b01_basic.a02_space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A01_CelestialController {

	@Autowired(required=false)
	private A02_CelestialService service;
	
	@RequestMapping("celestialList")
	public String celestialList() {
		return "b01_basic\\a02_space\\a01_celestialList";
	}
	@RequestMapping("celestialInsert")
	public String celestialInsert() {
		return "b01_basic\\a02_space\\a02_celestialInsert";
	}
	
	@RequestMapping("celestialDatail")
	public String celestialDatail() {
		return "b01_basic\\a02_space\\a03_ceestaiDetail";
	}	
}
