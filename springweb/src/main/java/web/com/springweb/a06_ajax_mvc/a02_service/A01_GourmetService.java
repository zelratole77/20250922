package web.com.springweb.a06_ajax_mvc.a02_service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.springweb.a06_ajax_mvc.a03_dao.A01_GourmetDao;
import web.com.springweb.a06_ajax_mvc.dto.GourmetStore;

@Service
public class A01_GourmetService {
	@Autowired(required=false)
	private A01_GourmetDao dao;
	public List<GourmetStore> getGourmetList(GourmetStore sch){
		if(sch.getName()==null) sch.setName("");
		if(sch.getKeyword()==null) sch.setKeyword("");
		sch.setName("%"+sch.getName()+"%");
		sch.setKeyword("%"+sch.getKeyword()+"%");
		return dao.getGourmetList(sch);
	}
	
	public String insertGourmet(GourmetStore ins) {
		return dao.insertGourmet(ins)>0 ?"등록성공":"등록되지 않았습니다";
	}
	
	public GourmetStore getGourmet(int id) {
		return dao.getGourmet(id);
	}	
	
}
