package web.com.springweb.a05_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class A02_AjaxController {

	// http://localhost:5050/callReqInit
	@GetMapping("callReqInit")
	public String callReqInit() {
		return "a08_ajax\\a02_ajaxReqView";
	}
	// http://localhost:5050/callReqAjax01?name=홍길동
	@GetMapping("callReqAjax01")
	@ResponseBody
	public String callReqAjax01(@RequestParam("name") String name) {
		String msg=name+" 안녕하세요!!";
		return msg;
	}
	// http://localhost:5050/callReqAjax02?price=3000&cnt=5
	@GetMapping("callReqAjax02")
	@ResponseBody
	public String callReqAjax02(@RequestParam("price") int price, @RequestParam("cnt") int cnt ) {
		String msg="구매 가격은 "+price+"원 이고, 구매 갯수는 "+cnt+"개, 총계는 "+(price*cnt)+"원 입니다.";
		return msg;
	}	
	
}
