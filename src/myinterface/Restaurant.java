package myinterface;

public interface Restaurant {
	
	String[] order();        //주문 받기
	
	boolean servingCheck();  //서빙이 됐는지 안됐는지 체크
	
	int seatGuide();  		//자리 안내
	
	int calculate();
	
	default void move() {
		System.out.println("움직이는 중");
	}

}
