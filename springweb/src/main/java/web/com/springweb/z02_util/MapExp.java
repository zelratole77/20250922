package web.com.springweb.z02_util;

import java.util.HashMap;
import java.util.Map;

public class MapExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Map : key/value형식의 데이터를 입력/저장할 수 있는 Collection객체
		// dao/serivce단에서 매개변수가 여러개 많을 때, 하나로 설정하여 처리할 때,
		// 사용한다.
		// 1. Map 선언 String/String
		Map<String, String> capitalMap = new HashMap<>();
		// 2. key/value형식의 데이터 등록  key는 중복되어 등록하면 마지막값이 등록된다.
		capitalMap.put("KR","서울");
		capitalMap.put("US","워싱턴");
		capitalMap.put("JP","도쿄");
		capitalMap.put("KR","경주"); /// 동일한 KEY에 다른 데이터를 VALUE로 등록하면
		// 최종 등록된 값이 저장된다.
		
		// 3. 데이터 가져오기..
		System.out.println(capitalMap.get("KR"));
		System.out.println(capitalMap.get("US"));
		System.out.println(capitalMap.get("JP"));
		
		// mapper 인터페이스에서
		// @Select("select * from emp where sal between #{start} and #{end}")
		// List<Emp> getEmpList(Map map); 로 설정하여 위 형식의 key값을 호출하여
		// service단..
		// Map<String, Integer> map = new HashMap<>();
		// map.put("start", 1000);
		// map.put("end", 3000);
		// return dao.getEmpList(map);
		// 처리가 가능하다..
		
		
	}

}
