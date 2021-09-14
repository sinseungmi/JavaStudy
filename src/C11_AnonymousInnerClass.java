
public class C11_AnonymousInnerClass {

	/*
	 * # 익명 내부 클래스
	 * 
	 * - 클래스에 이름을 짓지 않고 구현한 다음 바로 사용하는 방식 
	 * - 일회용이다
	 * 
	 */
	public static void kick(Kickable something) {
		something.kick();
	}

	public static void main(String[] args) {
		kick(new Human());
		kick(new VendingMachine());
		kick(new Ball("메시"));
		kick(new Ball("기성용"));

		// 지역 내부 클래스
		class Door extends Kickable {

			boolean open;

			@Override
			void kick() {
				if (open) {
					System.out.println("문짝을 발로 차서 닫음");
					open = false;
				} else {
					System.out.println("문짝을 발로 걷어차서 열었음");
					open = true;
				}

			}
		}

		Door door1 = new Door(), door2 = new Door(), door3 = new Door();  //얘는 main메서드 안에 있다는 걸 기억

		kick(door1);
		kick(door1);
		kick(door1);
		kick(door2);
		kick(door3);
		kick(door3);

		// 익명 클래스 (즉석에서 클래스를 상속한 인스턴스를 생성)
		// 만들고 따로 저장하지 않기 때문에 다시는 사용할 수 없다(일회용)
		kick(new Door() {

			void kick() {
				System.out.println("튼튼한 금고 문이 무거워서 꿈쩍하지 않음");
			}
		});
		kick(new Door() {

			void kick() {
				System.out.println("튼튼한 금고 문이 무거워서 꿈쩍하지 않음");
			}
		});

		kick(new Ball() {
			void kick() {
				System.out.println("농구공을 발로 찼더니 멀리 나가지 않고 아프기만 함");
			}
		});
		
		//punch 메서드의 인자 값으로 전달할 수 있는
		//익명 클래스로 2개와 지역 내부 클래스 2개를 만들어서 전달해보세요
		class Tree extends Punchale{

			@Override
			void punch() {
				System.out.println("나무를 때렸더니 사과가 우수수");
				
			}
			
		}
	
		punch(new Tree() {	
			void punch() {
				System.out.println("나무를 때렸더니 새가 푸드덕");
			}
		});
	}
	
	public static void punch(Punchale punchale) {
		punchale.punch();
	}

}


abstract class Punchale{
	abstract void punch();
}


abstract class Kickable {
	abstract void kick();
}

class Ball extends Kickable {

	String kicker;

	public Ball() {

	}

	public Ball(String kicker) {
		this.kicker = kicker;
	}

	@Override
	void kick() {
		if (kicker.equals("메시")) {
			System.out.println("슛을  멋있게 찼습니다");
		} else if (kicker.equals("기성용")) {
			System.out.println("패스를 정확하게 찼다");
		}
	}
}

class Human extends Kickable {

	void kick() {
		System.out.println("사람을 발로 걷어찼다");
	}
}

class VendingMachine extends Kickable {

	void kick() {
		System.out.println("자판기를 발로 찼더니 음료수가 하나 나옴");
	}
}
