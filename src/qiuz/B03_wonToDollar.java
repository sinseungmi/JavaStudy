package qiuz;

import java.util.Scanner;

public class B03_wonToDollar {
	public static void main(String[] args) {
		//한국 돈을 입력하면 미국 달러로 환전해주는 프로그램을 만들어보세요
		//(현재 환율은 구글 검색, 소수 둘째 자리까지 출력, 환전 수수료 1.75%)
		
		int won = new Scanner(System.in).nextInt();
		
		double dollar = won * 0.00089;
		
		System.out.println(dollar);
		
		System.out.println(Math.round(dollar * 0.9825 * 100) / 100.0);
//		
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int korMoney;
//		final double WON_TO_DOLLAR;
//		
//		System.out.print("한국돈을 입력하세요(수수료 1.75%) : ");
//		korMoney = sc.nextInt();
//		WON_TO_DOLLAR = 0.00089;
//		double wonDollar = 1125.00;
//		
//		double usd = korMoney * WON_TO_DOLLAR;  
//		//(usd *1.75 /100) 수수료
//						
//		System.out.println(Math.round(usd * 0.9825 * 100)/100.0 + "$");  
//		//정수와 정수를 나누면 몫만 나오기 때문에 정수와 실수 나누기
//		
//		System.out.printf("%d원은  %.2fUSD입니다\n", korMoney,(usd * 0.9825));
//		
		//소수 곱하기 100은 오른쪽
		//소수 나누기 100은 왼쪽
		
		/*
		 * 달러를 원화로 변경 시 : 달러 금액 X 환율 = 원화 환전액
		 * 100 X 1196.90 = 119690
		 * 
		 * 원화를 달러로 변경 시 : 원화 금액 / 환율 = 달러화 환전액
		 * 100,000 / 1196.90 = 83.55
		 * 
		 * */
		
	}
}
