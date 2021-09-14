
public class C04_Static {

	/*
	 * static (정적 영역, 클래스 영역 <=> 인스턴스 영역 (반대개념)
	 * 
	 * - static은 같은 클래스의 모든 인스턴스가 공동으로 사용하는 영역이다.
	 * - 앞에 스태틱이 붙은 클래스의 자원은 모든 인스턴스에서 같은 값을 지니게 된다
	 * - static 영역은 클래스당 하나밖에 생성되지않으므로 메모리가 절약된다 
	 * - static 영역은 클래스당 하나이기 때문에 클래스명에 .을 찍고 접근하는 것이 좋다
	 * - static 영역의 자원은 인스턴스가 생기기전에도 호출할 수 있다.
	 * - 인스턴스가 존재하지않을 때도 static이 사용될 가능성이 있기 때문에
	 * 	static 메서드에서는 인스턴스 자원을 사용할 수 없다
	 * 
	 * */
	public static void main(String[] args) {
		
		//아직 생성된 인스턴스가 없더라도 static 자원을 사용할 수 있다
		//static자원은 클래스명에 .을 찍고 접근할 수 있다
		
		System.out.println(Lamp.heigth);
		System.out.println(Lamp.width);
		
		Lamp lamp01 = new Lamp();
		Lamp lamp02 = new Lamp();
		Lamp lamp03 = new Lamp();
		Lamp lamp04 = new Lamp();
		
		lamp03.width = 30;
		
		System.out.println(lamp01.width);
		System.out.println(lamp02.width);
		System.out.println(lamp03.width);
		System.out.println(lamp04.width);

	}

}

class Lamp {
	
	//강의장 내부의 모든 형광등의 너비와 높이는 일정하다
	static int width = 50; 
	static int heigth = 200;
	
	//각자의 값을 가져야하는 변수
	int[] position;
	double brightness;
	boolean powerOn;
	
	//static 메서드에서 static 변수에 접근하는 것은 가능
	static void changeWidth(int width) {
		Lamp.width = width; //static 변수에는 this를 사용할 수 없다.
	}
	
	//static 영역에서 instance 자원에 접근하는 것은 불가능
//	static void turnOn() {
//		this.powerOn = true; 
//	}
}

//myobj 패키지에 static 변수를 포함한 클래스를 한 정의해보세요


















