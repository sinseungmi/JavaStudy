package myobj.item;
/*
 * 이 클래스를 상속 받아 아이템을 3개 만들어보세요
 * 
 * # Item 클래스는 수정하지 말 것 
 * 
 * */
public abstract class Item {
	
	String name;
	int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	//final을 붙인 메서드는 자식 클래스에서 오버라이드를 금지시킨다
	//final은 한번 값을 정해주면 그뒤로 값을 변경할 수 없다.그래서 final이 붙으면 클래스는 상속을,
	//메서드는 오버라이딩을 못하게 된다.final이 변경을 못하도록 막았기 때문에.
	final public void info() {
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price + "원");
	}
	
	abstract public void use();

}


















