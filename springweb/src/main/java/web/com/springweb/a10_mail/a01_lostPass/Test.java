package web.com.springweb.a10_mail.a01_lostPass;

import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		// 사용할 임시비번호 8자리
		System.out.println(UUID.randomUUID().toString().substring(0,8));
	}

}
