package web.com.springweb.a06_ajax_mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.springweb.a06_ajax_mvc.a03_dao.A02_LunchMenuDao;
import web.com.springweb.a06_ajax_mvc.dto.LunchMenu;

@Service
public class A02_LunchMenuService {
	
	@Autowired(required=false)
	private A02_LunchMenuDao dao;
	
	public List<LunchMenu> lunchMenuList(LunchMenu sch) {
		if(sch.getMenuName()==null) sch.setMenuName("");
		if(sch.getCategory()==null) sch.setCategory("");
		
		sch.setMenuName("%"+sch.getMenuName()+"%");
		sch.setCategory("%"+sch.getCategory()+"%");
		
		return dao.lunchMenuList(sch);
	}
	
	
}
