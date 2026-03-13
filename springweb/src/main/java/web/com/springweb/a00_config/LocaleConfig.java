package web.com.springweb.a00_config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


/*
# 스프링 부트라는 거대한 성(Castle)에 외국어 통역사와 출입국 관리소를 세우는 작업과 같습니다.
이 코드가 없으면 우리 웹사이트는 한국어만 고집하는 고집불통이 되지만, 이 설정을 넣는 순간 전 세계
사람들을 맞이할 준비가 된 글로벌 맛집이 됩니다.

 * */

@Configuration
public class LocaleConfig implements WebMvcConfigurer{
	// 기본 언어 설정
	// LocaleResolver : 우리집 기본 언어는 한국어(kr-KOREAN) 입니다. 표현
	// 1. 기본 안내 가이드
	// 2. 손님이 우리 성(웹사이트)에 들어왔을 때, 이 손님한테 어떤 언어로 말해야 하지?
	// 		를 결정하는 장치입니다.
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		// SessionLocaleResolver : 이건 손님의 기억력을 이용합니다. 한 번 영어(en)로
		// 할께요라고 말하면, 세션(session)이라는 주머니에 그 정보를 넣어두고 손님이 나갈 때까지
		// 계속 영어로 응대합니다.
		// setDefaultLocale(Locale.KOREAN); 손님이 아무 말도 안하면 일단 한국어로
		// 안내해라는 뜻입니다.
		resolver.setDefaultLocale(Locale.KOREAN); // 기본 언어
		return resolver;
	}
	// URL로 언어 변경 가능하도록 인터셉터 등록
	// 언어 좀 바꿔줘!!
	@Bean
	public LocaleChangeInterceptor localeChangeIntercepter(){
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		// 사용자가 보내는 모든 요청(url)을 유심히 지켜보다가..
		// 사용자가 주소창 뒤에 ?lang=en이나  ?lang=ja라고 속삭이는지 감시합니다.
		// 만약 lang이란느 단어가 보이면, 아 이 손님이 언어를 바꾸고 싶어하는구나라고 즉시
		// 알아 차리고 시스템에 보고 합니다.
		// lang=en 이면 영어로 스위치
		// lang=ko 이면 한국어로 스위치..
		interceptor.setParamName("lang"); // ?lang=en, /lang=kor
		return interceptor;
	}
	// 인터셉터 등록 : 통역사를 성문에 배치하기
	public void addInterceptors(InterceptorRegistry registry){
		// 아무리 똑똑한 통역사(LocaleChangeInterceptor)를 만들어도, 성문 앞에
		// 서 있지 않으면 아무 소용 없겠죠? 자, 이제부터 모든 손님이 들어오는 문에 이 통역사를
		// 배치해!!라고 명령하는 것입니다. 이제 모든 요청은 이 인터셉터를 가져 가야만 합니다..
		registry.addInterceptor(localeChangeIntercepter());
	}
}
