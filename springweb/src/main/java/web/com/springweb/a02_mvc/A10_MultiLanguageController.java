package web.com.springweb.a02_mvc;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class A10_MultiLanguageController {
	// 컨테이너에 선택하 지역 언어 선택 객체 호출
	@Autowired(required=false)
	private LocaleResolver localeResolver;
	
	// 언어 선택에 따른 변환처리
	// http://localhost:5050/multilang
	// http://localhost:5050/multilang?lang=ko
	// http://localhost:5050/multilang?lang=en
	@GetMapping("multilang")
	public String multilang(
			@RequestParam(value="lang", defaultValue = "ko") String lang,
			HttpServletRequest request,
			HttpServletResponse response
			) {
		System.out.println("언어 선택 : "+lang);
		Locale locale = new Locale(lang);
		localeResolver.setLocale(request, response, locale);
		
		return "a03_model\\a07_multiLanguage";
	}
	

}
