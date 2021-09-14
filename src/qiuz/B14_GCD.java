package qiuz;

import java.util.Scanner;

public class B14_GCD {

	public static void main(String[] args) {
		/*
		 * 두 숫자를 입력 받고 두 숫자의 최대 공약수를 구해보세요
		 * # 최대공약수 :  두 숫자의 공약수 중 가장 큰 공약수
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int result = 0;
		
		for (int i = Math.min(num1, num2); 0 < i ; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		
		
//		Scanner sc = new Scanner(System.in);
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int result = 0;
//		
//		for (int i = Math.min(num1, num2); i > 0; i--) {
//			if (num1 % i == 0 && num2 % i == 0) {
//				result = i;
//				break;
//			}
//		}
//		System.out.println(result);
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요 : ");
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int result = 0;
//		int min = Math.min(num1, num2);
//		int max = Math.max(num1, num2);
//		
//		//소수도 고려해서 1을 넣어준다. 1이 최대 공약수가 될 수 있기 때문
//		/*for (int i = 1; i <= min; i++) {
//			if (min % i == 0 && max % i ==0) {
//				result = i;
//			}
//		}
//		System.out.println(result);*/
//		
//		//최대공약수를 구하는 거이기 때문에 시작값을 1부터하기보단 
//		//큰수부터 시작하여 --로 내려가는게 더 효율적이다
//		//왜냐면 앞부터가 아닌 뒤부터 시작한다면 break을 걸 수 있고 나머지 쓸데 없는 비교는 안해도 되기때문
//		for (int i = min; i >= 1; i--) {
//			if (min % i == 0 && max % i ==0) {
//				result = i;
//				break;
//			}
//		}
//		System.out.println(result);
	}

}























