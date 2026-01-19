package web.com.springweb.a00_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import web.com.springweb.a11_chatting.A01_ChattingHandler;

// 서버단의 handler객체와 클라이언트단에서 연동할 때, 처리한 url패턴을 설정..
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	// 컨테이너 객체에 있을 때, 자동 등록 처리(필드 autowiring 처리)
	//Autowired(required=false)
	//private A01_ChattingHandler chaHandler;
	// 생성자 주입방식
	/*
	1. 불변성 : private final 키워드를 사용할 수 있습니다.  객체가 생성될 때 한 번 성정되면 이후에 변경 염려가 없어 안전합니다.
	2. 필수 객체 보장 : 생성 시점에 chatHandler가 반드시 전달되어야 하므로, 객체 생성 누락을 방지 할수 있습니다.
		(컴파일 단계 오류 확인가능)
	3. 테이스 용이성 : 스프링 컨테이너 없이 순수 자바 코드로 단위 테스트를 할 때 객체를 직접 넣어주기 쉽습니다.
	위 장점으로 소켓통신에는 생성자 주입방식을 선호합니다. 
	 * */
	private final A01_ChattingHandler chaHandler;
	
	public WebSocketConfig(A01_ChattingHandler chaHandler) {
		this.chaHandler = chaHandler;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// client에서 url 주소로 Handler객체와 연동 설정
		// http://서버주소:5050/chat 로 client에서 서버에 있는 핸들러 클래스와 소켓통신으로 연동 처리..
		// 즉, client에서 자바스크립트로 url주소로 서버와 연동되게 처리한다.
		registry.addHandler(chaHandler, "/chat").setAllowedOriginPatterns("*");
		
	}
	

}
