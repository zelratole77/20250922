package web.com.springweb.a06_ajax_mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_GourmetService {
	@Autowired(required=false)
	private A03_GourmetDao dao;
	public List<GourmetStore> getGourmetList(GourmetStore sch){
		if(sch.getName()==null) sch.setName("");
		if(sch.getKeyword()==null) sch.setKeyword("");
		sch.setName("%"+sch.getName()+"%");
		sch.setKeyword("%"+sch.getKeyword()+"%");
		return dao.getGourmetList(sch);
	}
}
