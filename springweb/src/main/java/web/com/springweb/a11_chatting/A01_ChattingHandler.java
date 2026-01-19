package web.com.springweb.a11_chatting;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// 컨테이너에서 객체로 사용하기 위한 설정..
// 1. 기본 사용할 추상클래스 선언..
@Component("chatHandler")
public class A01_ChattingHandler extends TextWebSocketHandler{
	
	// 접속한 클라이언트(소켓세션)을 저장하는 객체..(접속시는 추가, 종료시는 삭제) - 하나의 클라이언트가 보낸 메시지를 전송하는 대상 객체
	// Map<"키", 소켓세션>으로 put메서드를 통해 키와 소켓세션을 추가, romove()틍해서 삭제.
	private Map<String, WebSocketSession> users = new ConcurrentHashMap();
	

	
	// 재정의할 메서드 선언(overriding)
	// 1. 접속 후(client==>server단)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("[소켙 서버단 ] 접속되었습니다."+session.getId());
		users.put(session.getId(), session);  // 소켓고유아이디와 소켓 갯체로 접속시 누적 처리..
	}
	// 2. 메시지 받기(client==>server단), 메시지를 전송(servier==>client) 
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 특정한 client 중 하나가 보낸 메시지 내용..  client가 ws.send("전송할 메시지") 처리했을 때, 처리되는 내용..
		System.out.println("[소켙 메시지가 전달 받은 내용]"+session.getId()+":"+message.getPayload());
		// 접속한 모든 client에 전송..(각, 소켓세션에 전달.: 클라이언트에 전달 - 화면에서 onMessage=function(evt){}
		for(WebSocketSession ws:users.values()) {
			ws.sendMessage(message);
		}
			
		
		
	}
	// 3. 접속 종료(client x server단), session 접속된 세션 삭제
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("[소켓 접속 종료]"+session.getId());
		// 서버에 있는 특정 소켓세션삭제
		users.remove(session.getId());  // 키/값 형식으로 되어 있기에 키값으로 삭제 가능..
		
		
	}
	// 4. 소켓통신시 예외가 발생했을 때, 처리내용..
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("[에러 발생]"+session.getId()+", 예외발생:"+exception.getMessage());
	}



	
	

}
