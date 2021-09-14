
public class C09_InnerClass {
	/*
	 * # 클래스 내부에 클래스 사용하기
	 * 
	 * - 클래스 내부에도 클래스를 정의하고 사용할 수 있다
	 * - 클래스 내부에 존재하는 클래스는 인스턴스가 생성되어야 사용할 수 있는 설계도이다
	 * 
	 * */
	public static void main(String[] args) {
		
		AppleBox box = new AppleBox("감귤 박스");
		
		//이너 클래스 인스턴스 생성하기
		AppleBox.Apple apple1 = new AppleBox("사과 박스").new Apple();
		AppleBox.Apple apple2 = box.new Apple();
		
		apple1.whereAmI();
		apple2.whereAmI();
		
	}
	
}

class AppleBox{
	
	Apple[] box;
	String boxName;
	
	public AppleBox(String name) {
		box = new Apple[10];
		
		for (int i = 0; i < 10; i++) {
			box[i] = new Apple();
		}
		
		boxName = name;
	}
	
	class Apple{ //얜 일단 그냥 설계도
		String color;
		int size;
		boolean insect;
		
		void whereAmI() {
			System.out.println(boxName);
		}
	}
}









































