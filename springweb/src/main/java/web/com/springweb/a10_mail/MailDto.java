package web.com.springweb.a10_mail;
// title receiver sender content
public class MailDto {
	private String receiver;  // 수신자
	private String sender;	// 발신자 : 기본적으로 등록된 계정으로 처리됨(smtp차용해서)
	private String title;	// 제목
	private String content; // 내용
	public MailDto() {
		// TODO Auto-generated constructor stub
	}
	public MailDto(String receiver, String sender, String title, String content) {
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
		this.content = content;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
