package web.com.springweb.a05_ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.springweb.z01_dto.Dept;

@Service
public class A04_AjaxDBService {
	@Autowired(required=false)
	private A05_AjaxDBDao dao;
	
	public Dept getDept(int deptno) {
		return dao.getDept(deptno);
	}
}
