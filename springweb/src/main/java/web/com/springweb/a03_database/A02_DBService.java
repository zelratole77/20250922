package web.com.springweb.a03_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_DBService {

	// 객체끼리 자동으로 연관관계롤 1:1로 할당 처리..
	@Autowired(required=false)
	private A03_DBDao dao;
	
}
