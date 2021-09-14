package myobj.item;

public class Phone extends Item{
	
	int lowPower; 

	public Phone(String name, int price) {
		super(name, price);
		this.lowPower = 20;
	}
	
	public void use() {
		
		if (lowPower < 0 || lowPower > 100) {
			System.out.println("없는 값입니다");
		}else if (lowPower <= 20) {
			System.out.printf("잔여량은 %d입니다. 20% 이하 이므로 저전력 모드 실행합니다",lowPower);
		}	
	}
}




