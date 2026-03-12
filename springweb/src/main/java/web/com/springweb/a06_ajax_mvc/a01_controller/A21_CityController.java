package web.com.springweb.a06_ajax_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.com.springweb.a06_ajax_mvc.a02_service.A21_CityService;
import web.com.springweb.a06_ajax_mvc.dto.City;



@Controller
public class A21_CityController {
	@Autowired(required=false)
	private A21_CityService service;
	
	// http://localhost:5050/cityMng
	@GetMapping("cityMng")
	public String cityListVue() {
		return "forward:/vue02/a19_cityView.html";

	}	
	// a05_ajax\a01_controller\A21_CityController.java
	// /getCityList /insertCity  /getCity /updateCity /deleteCity
	// http://localhost:5050/getCityList
	@GetMapping("getCityList")
	public ResponseEntity<?> getCityList(City sch) {

		return ResponseEntity.ok(service.getCityList(sch));
	}
    @PostMapping("insertCity")
    public ResponseEntity<?> insertCity(@RequestBody City ins) {

        return ResponseEntity.ok(service.insertCity(ins)) ;
    }

    // http://localhost:5050/getCity
	@GetMapping("getCity")
	public ResponseEntity<?> getCity(int cityId) {
		return ResponseEntity.ok(service.getCity(cityId));
	}
	// http://localhost:5050/updateCity
	@PutMapping("updateCity")
	public ResponseEntity<?> updateCity(City upt) {
		return ResponseEntity.ok(service.updateCity(upt)) ;
	}
	// http://localhost:5050/updateCity
	@PutMapping("updateCityVue")
	public ResponseEntity<?> updateCityVue(@RequestBody City upt) {
		return ResponseEntity.ok(service.updateCity(upt)) ;
	}	
	// http://localhost:5050/deleteCity
	@DeleteMapping("deleteCity")
	public ResponseEntity<?> deleteCity(int cityId) {
		return ResponseEntity.ok(service.deleteCity(cityId));
	}	
}
