package myobj.poker;

public class Rank {
	
	//privat을 이용해 필드를 함부로 수정할 수 없게 만든다(동료 개발자가)
	private int value;
	private String name;
	
		public Rank(int value, String name) {
			this.value = value;
			this.name =  name;
		}
		
		//getter : public으로 private 필드를 꺼내가기만 하는 메서드
		//setter를 안한 이유는 고칠 필요가 없으니까.건들지 말라는 거.
		public String getName() {
			return name;
		}
		public int getValue() {
			return value;
		}
		@Override
		public String toString() {
			return name;
		}

}
