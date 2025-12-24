package a01_diexp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import a01_diexp.vo.Person;
import a01_diexp.vo.Product;

public class Diexp11 {

	public static void main(String[] args) {
		// 가상컨테이너에 있는 객체를 호출하여 처리되는 내용을 확인하기 위해서
		// 코드 처리..
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config11.class);
		// 1. 컨테이너 안에 있는 객체를 호출해서 메모리에 로딩.
		Object ob = ctx.getBean("obj"); // Bean으로 설정된 이름으로 객체를 호출..
		System.out.println("컨테이너 안에 있는 객체:"+ob);
		// p01
		Person p01 = ctx.getBean("p01", Person.class); // Bean으로 설정된 이름으로 객체를 호출..
		System.out.println("컨테이너 안에 있는 객체:"+p01.getName());		
		System.out.println("컨테이너 안에 있는 객체:"+p01.getAge());		
		System.out.println("컨테이너 안에 있는 객체:"+p01.getLoc());	
		Product pro01 = ctx.getBean("pro01", Product.class);
		System.out.println("물건명:"+pro01.getName());
		System.out.println("가격:"+pro01.getPrice());
		System.out.println("갯수:"+pro01.getCnt());
		// 2. 컨테이너 처리하는 메모리 해재
		ctx.close();
		

	}

}
