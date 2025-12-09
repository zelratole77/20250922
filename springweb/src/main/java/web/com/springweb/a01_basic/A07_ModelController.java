package web.com.springweb.a01_basic;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import web.com.springweb.z01_dto.Lotto;
import web.com.springweb.z01_dto.Student;

@Controller
public class A07_ModelController {

	// http://localhost:5050/model_one
	@GetMapping("model_one")
	public String modelOne(Model d) {
		// 모델 단일 데이터 설정..
		d.addAttribute("msg", "안녕하세요!! 기분 좋은 오후");
		d.addAttribute("favCount", 5);
		// ${msg}, ${favCount}
		return "a03_model/a01_start";
	}
	// http://localhost:5050/hero01
	// a03_model/a02_hero.jsp
	// 캐릭터이름 name, 레벨(level), 체력(hp), isAlive(생존여부 true/false)
	// 모델데이터 설정 및 출력하세요.
	@GetMapping("hero01")
	public String hero01(Model d) {
		d.addAttribute("name", "슈퍼맨");
		d.addAttribute("level", 77);
		d.addAttribute("hp", 125);
		d.addAttribute("isAlive", true);
		// ${name} ${level} ${hp} ${isAlive} 
		return "a03_model/a02_hero";
	}
	// 배열형 처리
	// http://localhost:5050/fruits
	@GetMapping("fruits")
	public String fruits(Model d) {
		// 고정형 배열
		d.addAttribute("fruits1", new String[] {"사과", "바나나","딸기"});
		// 고정형 배열을 가변형 배열로 만들기(List<String>)
		String [] fruits2 = {"키위", "오렌지","수박"};
		d.addAttribute("fruits2", Arrays.asList(fruits2));
		
		return "a03_model/a03_fruits";
	}
	// http://localhost:5050/travItems
	// a03_model/a04_items.jsp 설정해서, 여행에 필요한 아이템을 가변형 배열로
	// 선언하여 출력하세요..
	@GetMapping("travItems")
	public String travItems(Model d) {
		
		d.addAttribute("travelItems", 
				Arrays.asList( new String[] {"여행자 패스포트","계절에 맞는 옷","함께 하고 싶은 사람"} ));
		return "a03_model/a04_items";
	}
	// 객체형 처리
	// http://localhost:5050/modelObject
	@GetMapping("modelObject")
	public String modelObject(Model d) {
		d.addAttribute("student", new Student("홍길동",70,80,90));
		// ${student.name} ${student.kor} ${student.eng} ${student.math} 
		
		
		return "a03_model/a05_modelObj";
	}
	// http://localhost:5050/lotto
	// a03_model/a06_lotto_result.jsp
	// Lotto - 행운의 숫자(luckNum-1~100램덤할당, price-당첨금, msg-축하메시지)
	@GetMapping("lotto")
	public String lotto(Model d) {
		
		d.addAttribute("lottoResult",new Lotto((int)(Math.random()*100+1),
												2100000000,"행운인가?^^ 당신에겐 행운이길! 축하합니다."));
		// ${lottoResult.luckyNum} ${lottoResult.price} ${lottoResult.msg}
		
		return "a03_model/a06_lotto_result";
	}
	
	// 객체형 배열 처리..
	
	
	
	
}
