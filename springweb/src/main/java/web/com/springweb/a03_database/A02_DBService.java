package web.com.springweb.a03_database;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.com.springweb.a02_mvc.Dept;
import web.com.springweb.z01_dto.Emp;
import web.com.springweb.z01_dto.Heroes;
import web.com.springweb.z01_dto.Salgrade;

@Service
public class A02_DBService {
	
	@Autowired(required = false)
    private A04_CUDDao dao2;

	// 객체끼리 자동으로 연관관계롤 1:1로 할당 처리..
	@Autowired(required=false)
	private A03_DBDao dao;
	
	// mybatis에서 인터페이스를 상속받은 실제 객체의 기능메서드에 의해
	// sql의 결과 데이터를 리턴하는 메서드 처리..
	public int getCountEmp() {
		
		return dao.getCountEmp();
	}
	public void dbexp() {
		// int updateEmp01(Emp upt);
		System.out.println("부서정보 수정:"+dao2.updateEmp01(new Emp(5000.0,350.0,20)));
		//System.out.println("부서정보 수정:"+dao2.updateDept01(new Dept(60,"기획","제주")));
		
		
		
		//System.out.println("아이돌 등록 건수:"+dao2.insertIdol(new Idol(110,"강다니엘",2019,6,0)));
		//System.out.println("등록 건수:"+dao2.insertDept01(new Dept(60,"재무","판교")));
		
		//System.out.println("사원건수:"+dao.getCountEmp());
		//System.out.println("사원의 최고급여:"+dao.getMaxSal());
		//System.out.println("사원명 확인:"+dao.getEnameByJob());
		///System.out.println("최초입사일:"+dao.getInitHiredate());
		/*
		for(String ename:dao.getEnames()) {
			System.out.println(ename);
		}
		*/
		/*
		System.out.println("# 급여에 의한 사원명 #");
		for(String ename:dao.getEnamesBySal()) {
			System.out.println(ename);
		}
		*/
		/*
		System.out.println("# SALESMAN의 입사일 #");
		for(Date date:dao.getHiredates()) {
			System.out.println(date);
		}
		*/
		/*
		System.out.println("# 관리자 번호에 의해 사원번호 #");
		for(int empno:dao.getEmpnoByMgr()) {
			System.out.println(empno);
		}
		*/
		//System.out.println("부서 번호에 따른 급여");
		//for(double sal:dao.getSalByDeptno()) {
		//	System.out.println(sal);
		//}
		// dao.empList(1000,3000);
		/*
		System.out.println(dao.empList(1000,3000).size());
		System.out.println(dao.getDept01(10,20).size());
		
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("start", 1000);
		map1.put("end", 4000);
		System.out.println(dao.empList4(map1).size());
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("deptno1", 10);
		map2.put("deptno2", 20);		
		System.out.println(dao.getDept02(map2).size());
		*/
		// dao.getDept02(map2); 
		// 	List<Emp> empList5(Map map); // empno1 empno2
		/*
		Map<String, Integer> map3 = new HashMap<>();
		map3.put("empno1", 7400);
		map3.put("empno2", 7600);
		System.out.println(dao.empList5(map3).size());
		
		// List<Emp> empList6(Map map);	// job deptno	
		// 값이 하나는  String, Integer로 둘다 할당가능한 Object로 설정ㄴ..
		Map<String, Object> map4 = new HashMap();
		map4.put("job", "SALESMAN"); // Object ob = "SALESMAN"
		map4.put("deptno", 20);		// Object ob = Integer = int = 20
		System.out.println(dao.empList6(map4).size());
		*/
		/*
		Emp sch = new Emp();
		sch.setJob("SALESMAN");
		sch.setDeptno(20);
		System.out.println(dao.getEmpList10(sch).size());
		*/
		
		Salgrade sal = dao.getSalgrade( new Salgrade(0, 700, 1200) );
		System.out.println(sal.getGrade());
		System.out.println(sal.getLosal());
		System.out.println(sal.getHisal());
	}
	public List<Emp> empList4(Map map){
		return dao.empList4(map);
	}
	
	
	public int getCountByDeptno(int deptno) {
		return dao.getCountByDeptno(deptno);
	}
	
	public List<String> getEnamesByDeptno1( int deptno){
		
		return dao.getEnamesByDeptno1(deptno);
	}
		
	public List<Integer> getEmpnosByJob(String job){
		return dao.getEmpnosByJob(job);
	}	
	
	public Dept getDept(int deptno) {
		return dao.getDept(deptno);
	}
	
	public List<Heroes> getHero(@Param("name") String name){
		// 키워드 검색으로 %% 포함 처리..
		return dao.getHero("%"+name+"%");
	}
}





