package web.com.springweb.a02_mvc.a01_idol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_Idol_Service {
	
	@Autowired(required=false)
	private A03_Idol_Dao dao;
	
	public List<A04Group> getIdolGrpList(A04Group sch){
		// 서비스단 처리..(전체리스트 키워드 검색)
		// null ==> "", %% 감싸기.
		// 초기화면에 전체 데이터가 검색되어 출력되게 한다.
		if(sch.getGroupName()==null) {
			sch.setGroupName("");
		}
		if(sch.getFandomName()==null) {
			sch.setFandomName("");
		}
		sch.setGroupName("%"+sch.getGroupName()+"%");
		sch.setFandomName("%"+sch.getFandomName()+"%");
		
		return dao.getIdolGrpList(sch);
	}
	public String insertIdoGrp(A04Group ins) {
		
		return dao.insertIdoGrp(ins)>0?"등록성공":"등록되지 않았습니다";
	}

}
