package qiuz;

import java.util.Scanner;

public class B15_Count369 {

	public static void main(String[] args) {

		/*
		 * 사용자로부터 정수를 하나 입력 받고 해당 숫자까지 369 게임이 진행된다면 박수를 총 몇 번 쳐야하는지 세어보세요
		 * 
		 */
		
		System.out.print("숫자를 입력하세요 : ");
		int input = new Scanner(System.in).nextInt();
		int count = 0;
		
		for (int i = 1; i <= input; i++) {
			int keepNum = i;
				while (keepNum > 0) {
					int j = keepNum % 10;
					if (j != 0 && j % 3 == 0) {
						count++;
					}
					keepNum /= 10;
				
			}
			
		}
		System.out.println(count);
		
		
//		int userNum = new Scanner(System.in).nextInt();
//		int clap = 0;
//
//		for (int i = 1; i <= userNum; i++) {
//			int keepNum = i; // i가 변형되지않도록 keepNum에 저장
//			
//			System.out.print(keepNum + " : ");
//
//			while (keepNum > 0) {
//				int oneNum = keepNum % 10; // % 10을 해서 1의 자리는 따로 변수에 저장해서 비교하고
//				if (oneNum % 3 == 0 && oneNum != 0) {   //여기서 != 0을 해야하는 이유는 위에서
//										// 20 % 10을 했을 때 저장되는 나머지값은 0이 되고
//										// 0 % 3를 했을 때 나머지가 0이 돼서 oneNum % 3 == 0 이 조건이 성립되버린다
//										// 10의 자릿수들을 염두해야할 것
//					clap++;
//					System.out.print("짝");
//				}
//				keepNum /= 10; // / 10으로 위에서 비교했던 1의 자리를 버려버리고 몫을 keepNum에 저장
//
//			}
//			System.out.println();
//
//		}
//		System.out.println(clap);
		// System.out.println(20 % 10);
//
//		int userNum = new Scanner(System.in).nextInt();
//		int count = 0;
//
//		for (int i = 1; i <= userNum; i++) { // 바깥 for문은 1부터 입력한 숫자까지 돌리는 것 // String
//			String strNum = Integer.toString(i); // Integer.toString()은 정수를 문자열로 바꾸는 메서드 String
//			strNum = "" + i; // 문자열 + 정수 = 문자열!!!이거 까묵지마ㅠㅠ
//			for (int j = 0; j < strNum.length(); j++) {
//				char ch = strNum.charAt(j);
//				if (ch == '3' || ch == '6' || ch == '9') {
//					count++;
//				}
//			}
//
//		}
//
//		System.out.printf("박수친 횟수는 총 %d번 입니다", count);

	}
}
