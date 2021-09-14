package myobj.item;

public class Inventory {

	Item[] inventory;
	int size;
	
	public Inventory(int size) {
		inventory = new Item[size];   //Inventory 생성자가 불러짐과 동시에 아이템들을 채울 공간을 마련한다
									  //이 item[]배열 안에는 item을 상속 받은 자식 클래스들은 전부 들어갈 수 있다
	}
	public boolean put(Item item) {
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null) {    //inventory[i]가 null이다 그럼
			   inventory[i] = item;       //[i]번째에 item을 채워넣는다(아이템은 넘겨 받은 주소값)
			   return true;
			}
		}
		return false;
	}
	public void useAllItems() {
		for(Item item : inventory) {  //향상된 for문 
			// - 배열의 항목 수 만큼 실행 부분을 반복.반복이 이루어질 때마다 배열의 항목을 순서대로 꺼내서 변수에 자동으로 대입
			//   주의 점은 배열의 값을 가져다 사용(read)만 가능하고 수정(write)은 불가능
			if(item != null) {
				item.use();
			}
		}
	}
	
	public static void main(String[] args) {
		Inventory inven1 = new Inventory(3);
		
		//Item을 넣어야 하는 자리에 Item을 상속받은 모든 것들이 
		//들어갈 수 있다
		
		inven1.put(new Lotto("승승 로또",4000));
		
//		for (int i = 0; i < 4; ++i) {
//			if(inven1.put(new Lotto("승승 로또",4000))) {
//				System.out.println("아이템이 잘들어가면 put()에서 true가 리턴됨");
//			}else {
//				System.out.println("아이템이 잘 안들어가면 put()에서 false가 리턴됨");
//			}
//		}
		inven1.inventory[0].info(); 
		
		inven1.useAllItems();
		
	}
	
	
	
	
	

}
