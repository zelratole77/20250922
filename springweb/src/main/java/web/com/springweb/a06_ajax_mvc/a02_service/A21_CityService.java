package web.com.springweb.a06_ajax_mvc.a02_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.com.springweb.a06_ajax_mvc.a03_dao.A21_CityDao;
import web.com.springweb.a06_ajax_mvc.dto.City;

import java.util.List;

@Service
public class A21_CityService {
	@Autowired(required = false)
	private A21_CityDao dao;

	public List<City> getCityList(City sch) {
		if (sch.getCityName() == null)
			sch.setCityName("");
		if (sch.getCountry() == null)
			sch.setCountry("");
		// 키워드 검색될 수 있게 처리 %%
		sch.setCityName("%" + sch.getCityName() + "%");
		sch.setCountry("%" + sch.getCountry() + "%");
		return dao.getCityList(sch);
	}
	public String insertCity(City ins) {
		return dao.insertCity(ins) > 0 ? "등록성공" : "등록실패";
	}

	public City getCity(int cityId) {
		return dao.getCity(cityId);
	}

	public String updateCity(City upt) {
		return dao.updateCity(upt) > 0 ? "수정성공" : "수정실패";
	}

	public String deleteCity(int cityId) {
		return dao.deleteCity(cityId) > 0 ? "삭제성공" : "삭제실패";
	}
}
