package web.com.springweb.a10_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class A02_MailService {
	
	// 컨테이너에 있는 메일 발송 객체 로딩( pom.xml에서 lib 설정으로 가지고 있음)
	@Autowired(required=false)
	private JavaMailSender sender;
	
	
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
