package web.com.springweb.a02_mvc.a02_Meet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_Meet_Service {
	@Autowired(required=false)
	private A03_Meet_Dao dao;
	
	public List<A04Meet> getBlindDate(A04Meet sch){
		if(sch.getPartnerName()==null) sch.setPartnerName("");
		if(sch.getLocation()==null) sch.setLocation("");
		
		sch.setPartnerName("%"+sch.getPartnerName()+"%");
		sch.setLocation("%"+sch.getLocation()+"%");
		
		return dao.getBlindDate(sch);
	}
}
