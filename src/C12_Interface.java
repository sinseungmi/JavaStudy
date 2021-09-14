
public class C12_Interface {
	
	/*
	 * 인터페이스 (Interface)
	 * 
	 * - class는 상속을 여러개 받을 수 없다는 단점을 보완한 것
	 * - 인터페이스 내부의 메서드는 자동으로 abstract public이 된다
	 * - 인터페이스 내부의 변수는 자동으로 public final static이 된다(상수)
	 * - 인터페이스 내부의 메서드를 정의할 때 default를 붙이면 기본 동작을 설정할 수 있다
	 * - 인터페이스는 구현된 것은 아무것도 없고 밑그림만 그려져 있는 기본 설계도와 같다.
	 * 
	 * */
	public static void main(String[] args) {
		new OrangeTree().click();
	}

}

interface CanClick{
	int a = 10;  //인터페이스는 오직 추상메서드와 상수만을 멤버로 가질 수 있으며 그 외의 다른 요소는 어떤 것도 허용하지 않는다
	
	default void click() {
		System.out.println("클릭 인터페이스가 달려있는 클래스의 기본 동작(오버라이드해서 사용해주세요)");
	} //이렇게 인터페이스에 메서드를 추가 했을 땐 구현하는 클래스에는 무조건 이 메서드를 추가해서 구현해야하지만
	//여기에 디폴트를 붙인다면 구현하는 클래스에서는 (디폴트)메서드를 구현할 필요가 없어진다.(번거로운 상황이 줄어듬)
	
}
interface CancPunch{
	void punch();
}

class OrangeTree implements CanClick,CancPunch{

	@Override
	public void punch() {
		
	}
	
	//클릭을 여기서 오버라이드하면 다른 동작으로 바뀌겠지만 클릭을 만들지 않을 때는 디폴트한 메서드 클릭이 실행된다

}

























