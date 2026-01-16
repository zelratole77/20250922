package web.com.springweb.b01_basic;

import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String tempPassword = UUID.randomUUID().toString().substring(0, 8);
			System.out.println(tempPassword);
		
		
	}

}
