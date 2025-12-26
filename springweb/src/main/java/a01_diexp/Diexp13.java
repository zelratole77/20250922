package a01_diexp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import a01_diexp.vo.Car;
import a01_diexp.vo.Engine;
import a01_diexp.vo.Pet;
import a01_diexp.vo.PetOwner;

public class Diexp13 {

	public static void main(String[] args) {
		// 가상컨테이너에 있는 객체를 호출하여 처리되는 내용을 확인하기 위해서
		// 코드 처리..
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config13.class);
		// 1. 컨테이너 안에 있는 객체를 호출해서 메모리에 로딩.
		Pet ob = ctx.getBean("pet01", Pet.class); // Bean으로 설정된 이름으로 객체를 호출..
		System.out.println("컨테이너 안에 있는 객체:"+ob.getName());
		PetOwner po = ob.getPetOwner();
		System.out.println(po.getName()); // 객체가 없으므로 null
		System.out.println(po.getAge());
		// 컨테이너 안에 Pet PetOwner가 각각 있고, Autowired에 의해 선언 되어 있을 때..
		// 자동으로 연결되어 처리 된다..
		// 2. 컨테이너 처리하는 메모리 해재
		
		// ex) vo 패키지 안에 Engine(engineType-문자열)
		//                 Car(model-문자열, engine - Engine )
		//     Config13안에 위 두객체가 선언되고, 속성을 설정하되.. Car에서 autowired
		//     통해서 자동을 할당되게 처리 후, 확인하세요..
		Car car = ctx.getBean("car", Car.class);
		System.out.println("자동차 모델:"+car.getModel());
		Engine engine = car.getEngine();
		System.out.println("엔진 타입:"+engine.getEngineType());
		ctx.close();
		
	}
}
