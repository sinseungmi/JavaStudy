
public class C01_Function {
	/*
	 * 함수 (Function)
	 *  - 기능을 미리 정의해두고 나중에 가져다 쓰는 것
	 *  - 자바에서 함수(메서드)는 반드시 클래스 내부에 선언해야한다
	 *  - 정의해둔 함수 이름 뒤에 ()를 붙여서 함수를 호출하면
	 *    호출한 자리에 함수의 실행 결과가 반환된다
	 *  - 함수를 정의 할 때 해당 함수가 반환할 값의 타입을 앞에 적어둔다
	 *  - 나중에 재사용할 가능성이 있는 기능들을 미리 만들어둠으로써 작업의 반복을 줄일 수 있다
	 *  - 리턴 타입 void는 해당 함수가 반환하는 값이 없다는 것을 나타낸다
	 *   
	 * */

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; ++i) {
			print_rabbit();
			print_rabbit();
			print_rabbit();
		}
		
		String basket = apple_basket(123,10);
		System.out.println(basket);

	}
	
	//ex: 사과의 개수와 바구니의 크기를 전달하면 필요한 바구니의 개수를 알려주는 함수
	
	// public static : 나중에 생각할 것
	// int : 이 함수의 실행 결과의 타입 (리턴 타입, return)
	// apple_basket : 타입 뒤에 함수명을 정의할 수 있다
	// apple_basket(int apple, int size) : 이 함수를 실행할 때 int타입 값을 두 개 전달 받도록 정의 (매개변수,argument)
	
	public static String apple_basket(int apple, int size) {
		int result;
		
		if (apple % size == 0) {
			result = apple / size;
		}else {
			result = apple / size + 1;
			
		}
		//return: 함수를 즉시 종료시키며, 이 함수를 호출한 곳에 값을 돌려준다
		return "필요한 바구니의 개수는 " + result + "개 입니다";
	}
	
	
	public static void print_rabbit() {
		System.out.println(" /)/)");
		System.out.println("(  ..)");
		System.out.println("(  >$");
	}

}














