package web.com.springweb.a03_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A02_DBService {

	// 객체끼리 자동으로 연관관계롤 1:1로 할당 처리..
	@Autowired(required=false)
	private A03_DBDao dao;
	
	// mybatis에서 인터페이스를 상속받은 실제 객체의 기능메서드에 의해
	// sql의 결과 데이터를 리턴하는 메서드 처리..
	public int getCountEmp() {
		
		return dao.getCountEmp();
	}
	public void dbexp() {
		//System.out.println("사원건수:"+dao.getCountEmp());
		//System.out.println("사원의 최고급여:"+dao.getMaxSal());
		//System.out.println("사원명 확인:"+dao.getEnameByJob());
		///System.out.println("최초입사일:"+dao.getInitHiredate());
		
		for(String ename:dao.getEnames()) {
			System.out.println(ename);
		}
	}
	
}
