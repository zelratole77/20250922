package web.com.springweb.a01_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		return "a03_model/a02_hero";
	}
	
	
}
