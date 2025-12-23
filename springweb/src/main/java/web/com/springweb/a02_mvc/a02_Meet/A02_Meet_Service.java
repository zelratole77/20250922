package web.com.springweb.a02_mvc.a02_Meet;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	// A04Meet getMeet(@Param("dateNo") int dateNo);
	public A04Meet getMeet(@Param("dateNo") int dateNo) {
		return dao.getMeet(dateNo);
	}
	public String updateBlindDate(A04Meet upt) {
		
		return dao.updateBlindDate(upt)>0?"수정 성공":"수정지 못 했습니다.";
	}
	public String deleteBlindDate( int dateNo) {
		
		return dao.deleteBlindDate(dateNo)>0?"삭제 성공":"삭제하지 못 했습니다.";
	}

	
}
