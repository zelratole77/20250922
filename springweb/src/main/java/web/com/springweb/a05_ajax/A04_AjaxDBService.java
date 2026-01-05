package web.com.springweb.a05_ajax;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.springweb.z01_dto.Dept;
import web.com.springweb.z01_dto.IdoleGroup;

@Service
public class A04_AjaxDBService {
	@Autowired(required=false)
	private A05_AjaxDBDao dao;
	
	public Dept getDept(int deptno) {
		return dao.getDept(deptno);
	}
	// dao에 해당 데이터가 0초과가일 때는 문자열로 등록한 아이디가 있습니다. 그외
	// 등록가능한 아이디 입니다. 출력되게 메서드 선언..
	public String isValidId(String id) {
		return dao.isValidId(id)>0?"등록된 아이디가 있습니다":"등록 가능한 아이디입니다.";
	}
	
	public IdoleGroup idolInfo(int groupId) {
		return dao.idolInfo(groupId);
	}
}
