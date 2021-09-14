
public class C10_LocalInnerClass {
	
	/*
	 * 지역 내부 클래스
	 * 
	 * - 메서드 내부에서 선언하여 사용하는 클래스
	 * - 메서드가 끝나면 해당 클래스도 수명이 다한다
	 * 
	 * */
	public static void main(String[] args) {
		
		//지역  내부 클래스 (메서드가 끝나면 이 클래스도 사라지게 된다)
		class Apple {
			String size;
			String color;
			String insect;
		}
		
		Apple a = new Apple();
		AppleBox.Apple a2 = new AppleBox("고구마 박스").new Apple();
		
		// 내부 지역 클래스가 업캐스팅 되어있는 상태
		Fruit2 banana = getBanana();
		
		banana.eat();  //Fruit2(부모클래스)에도 eat()메서드가 있고,Banana(자식클래스)에도 eat()메서드가 있기 때문에
					   //오버라이드돼서 Banana(자식클래스)에 eat()메서드가 실행된다
	}
	
	public static Fruit2 getBanana() {
		   //클래스 Banana는 getBanana()메서드 안에 있는 지역 메서드
		class Banana extends Fruit2{
			int fruit;
			int[] color;
			
			public Banana(int fruit) {
				this.fruit = fruit;
			}
			
			void eat() {
				System.out.println("열매가" + fruit + "개 열린 바나나는 맛있다");
			}
			void banana만가지고있는고유의기능() {
				System.out.println("엄청난 기능");
			}
		}

		return new Banana(20); //바나나 인스턴스를 리턴으로 넘긴다
	}

}

abstract class Fruit2{
	abstract void eat();  //업캐스팅된 인스턴스는 자식 클래스에만 존재하던 것들을 모두 잊어버리지만
	                      //오버라이드된 메서드는 자식 클래스에서 구현한 내용이 실행된다
}














