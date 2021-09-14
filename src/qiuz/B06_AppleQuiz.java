package qiuz;

import java.util.Scanner;

public class B06_AppleQuiz {
	public static void main(String[] args) {
		/*
		 * 사과를 10개씩 담을 수 있는 바구니가 있다
		 * 
		 * 사용자가 구매하고 싶은 사과의 개수를 입력하면
		 * 사과를 모두 담기 위해 필요한 바구니의 개수를 알려주는 프로그램을 만들라
		 * */
		
		int num = new Scanner(System.in).nextInt();
		
		System.out.println(num % 10 == 0 ? num / 10 : (int) Math.ceil(num / 10.0));
		
		int buyApple = new Scanner(System.in).nextInt();
		int basket = 10;
		
		int basketNum = (int)(Math.ceil((double)buyApple / basket));
		System.out.println((double)buyApple / basket);
		System.out.println(basketNum);
		
		int basketNum2 = buyApple % basket == 0 ? buyApple / basket : buyApple / basket + 1;
		
		System.out.println(basketNum2);
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("구매할 사과의 개수 입력 : ");
//		int buyApple = sc.nextInt();
//		double basket = 10.0;
//		int basketNum = (int)Math.ceil(buyApple/basket);
//		
//		if (basketNum >= 1) {
//			System.out.printf("사과를 담을 수 있는 바구니는 총 %d개 입니다\n",basketNum);
//		}else {
//			System.out.println("담을 사과가 없습니다");
//		}
//		
//		
//		if (buyApple < 0) {
//			System.out.println("잘못된 사과 개수입니다.");
//		}else if (buyApple % basket != 0) {
//			System.out.println("필요한 바구니의 개수 : " + (buyApple / basket + 1));
//		}else {
//			System.out.println("필요한 바구니의 개수 : " + buyApple / basket);
//		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
