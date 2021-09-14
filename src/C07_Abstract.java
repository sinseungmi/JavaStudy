
public class C07_Abstract {
	
	/*
	 * 추상 클래스 (abstract class)
	 *  - 완성을 자식 클래스에게 미루는 클래스
	 *  - 클래스 내부에 추상 메서드를 지닌 클래스는 앞에 abstract를 붙여 표시한다
	 *  - 내부의 추상 메서드를 구현하기 전에는 인스턴스 생성이  불가능
	 *  
	 *  
	 * # 추상 메서드 (abstract method)
	 *  - 메서드의 형태(리턴 타입, 접근 제어자, 매개 변수)만 정해놓고 자세한 구현은 자식 
	 *  클래스에서 오버라이드를 통해 구현하는 메서드
	 *  - 자식 클래스에서 오버라이드 하지않으면 컴파일 에러가 발생한다
	 * 
	 * */
	public static void main(String[] args) {
		Vehicle v1 = new Bus();
		
		//즉석에서 오버라이드
		//이렇게 즉석에서 수정하는 건 익명 클래스.이름이 없음(Anonymous class) 
		Vehicle v2 = new Vehicle(){  //이것도 일종에 상속. 상속과 동시에 구현함. 대신 클래스 이름은 없음
			@Override 
			void ride() {
				System.out.println("즉석에서 구현한 탈 것");
				
			} 
		}; //여기까지가 생성자
		
		v1.ride();
		v2.ride();
	}

}


abstract class Vehicle{
	
	abstract void ride();
	
}

class Bus extends Vehicle{
	@Override
	void ride() {
		System.out.println("요금을 내고 타야함");
	}
}

class Bike extends Vehicle{

	//오버라이드 조건(같은 함수명, 같은 리턴 타입, 같은 매개 변수) 
	@Override
	void ride() {}
	
}















