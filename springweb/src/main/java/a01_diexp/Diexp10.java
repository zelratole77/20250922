package a01_diexp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Diexp10 {

	public static void main(String[] args) {
		// 가상컨테이너에 있는 객체를 호출하여 처리되는 내용을 확인하기 위해서
		// 코드 처리..
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config10.class);
		// 1. 컨테이너 안에 있는 객체를 호출해서 메모리에 로딩.
		Object ob = ctx.getBean("obj"); // Bean으로 설정된 이름으로 객체를 호출..
		System.out.println("컨테이너 안에 있는 객체:"+ob);
		// 2. 컨테이너 처리하는 메모리 해재
		ctx.close();
		

	}

}
