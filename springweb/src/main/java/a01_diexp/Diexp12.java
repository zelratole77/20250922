package a01_diexp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import a01_diexp.vo.Student;
import a01_diexp.vo.StudentCard;

public class Diexp12 {

	public static void main(String[] args) {
		// 가상컨테이너에 있는 객체를 호출하여 처리되는 내용을 확인하기 위해서
		// 코드 처리..
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config12.class);
		// 1. 컨테이너 안에 있는 객체를 호출해서 메모리에 로딩.
		Student ob = ctx.getBean("cardStudent", Student.class); // Bean으로 설정된 이름으로 객체를 호출..
		System.out.println("컨테이너 안에 있는 객체:"+ob);
		System.out.println(ob.getName());
		StudentCard cd = ob.getCard();
		System.out.println("객체 안에 있는 카드 번호:"+cd.getCardNumber());
		// 2. 컨테이너 처리하는 메모리 해재
		ctx.close();
		

	}

}
