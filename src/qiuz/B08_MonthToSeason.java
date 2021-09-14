package qiuz;

import java.util.Scanner;

public class B08_MonthToSeason {

	public static void main(String[] args) {
		/*
		 * 사용자로부터 달을 입력받으면 해당하는 계절을 출력해보세요
		 * (switch-case문을 이용)
		 * 
		 * */
		
		int month = new Scanner(System.in).nextInt();
		String season = null;
		
		switch(month) {
		case 12: case 1: case 2:
			season = "겨울";
		case 3: case 4: case 5:
			season = "봄";
		case 6: case 7: case 8:
			season = "여름";
		case 9: case 10: case 11:
			season = "가을";
		default:
			season = "잘못 누르셨습니다";
		}
		System.out.println(season);
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("달을 입력하세요 : ");
//		int input = sc.nextInt();
//		
//		switch(input) {
//		case 12: case 1: case 2:
//			System.out.println("겨울");
//			break;
//		case 3: case 4: case 5:
//			System.out.println("봄");
//			break;
//		case 6: case 7: case 8:
//			System.out.println("여름");
//			break;
//		case 9: case 10: case 11:
//			System.out.println("가을");
//			break;
//		default:
//			System.out.println("잘못 입력하셨습니다");
//		}
	}

}
