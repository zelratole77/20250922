package web.com.springweb.a10_mail.a01_lostPass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import web.com.springweb.a10_mail.MailDto;

@Service
public class A02_LostPassService {
	@Autowired(required=false)
	private A03_LostPassDao dao;
	
	
	// 컨테이너에 있는 메일 발송 객체 로딩( pom.xml에서 lib 설정으로 가지고 있음)
	@Autowired(required=false)
	private JavaMailSender sender;
	
	// 최종적으로 다시 아이디와 임시비번으로 로그인 되는지 확인..
	public Member login(Member sch) {
		return dao.login(sch);
	}
	// 비밀번호 분실시, 처리할 메서드 처리 내용..
	public String lostPass(String id) {
		// 1. 보낼 메일 호출
		
		// 2. 임시비번호 생성.
		
		// 3. DB에 임시비번호로 해당 게정의 데이터 수정
		
		// 4. 메일로 해당 메일에 발송..
		//    id 님 새로 발급된 임시비밀번호는 @@@ 입니다.
		//    로그인 하세요..
		
		
		return "";
	}
	
	
	
	
	// 메일 발송 기능 처리
	public String sendMail(MailDto email) {
		String msg="메일발송 성공";
		/// 1. 메일 발송 데이터 전송을 위한 객체 생성
		MimeMessage mmsg = sender.createMimeMessage();
		//  2. MimeMessage 객체에 화면단에 입력한 내용 할당 처리..
		
		//   	
		try {
			// 1) 제목 설정.
			mmsg.setSubject(email.getTitle());
			// 2) 수신자
			mmsg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
			// 3) 내용
			mmsg.setText(email.getContent());
			// 메일 발송 처리
		    sender.send(mmsg);
				
		} catch (MessagingException e) {
			msg = "메일 발송 에러:"+e.getMessage();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			msg = "기타 에러:"+e.getMessage();
			System.out.println(e.getMessage());
		}
		return msg;
	}	

}
