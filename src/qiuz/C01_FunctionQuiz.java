package qiuz;

import java.util.Arrays;
import java.util.Scanner;

public class C01_FunctionQuiz {
	
	/*
	 * 다음의 함수를 정의하고 올바르게 동작하는지 테스트를 해보세요
	 * 
	 * 1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	 * 2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	 * 3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수 입니다"를 반환하는 함수
	 * 4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수 
	 * 5. 전달한 정수가 소수라면 true를 반환하고 아니면 false를 반환하는 함수
	 * 6. 숫자를 전달하면 해당 숫자의 팩토리얼 결과를 반환하는 함수
	 * 		factorial : (n)*(n-1)*(n-2) ... 3*2*1
	 * 
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String input = sc.next();
//		char alpha = input.charAt(0);
//		System.out.println(getAlphabet(alpha));
//		
//		int threeNum = sc.nextInt();
//		System.out.println(multipleThree(threeNum));
//	
//		int EONum = sc.nextInt();
//		System.out.println(evenOdd(EONum));
//		
//		int diviNum = sc.nextInt();
//		System.out.println(Arrays.toString(getDivisor(diviNum)));
	
		int num = sc.nextInt();
		System.out.println(sosu(num));
		System.out.println(findSosu(num));
		System.out.println(factorial(num));
	}
	
	public static boolean getAlphabet(char alpha) {
		char ch2 = alpha;
		
		return (ch2 < 'a' || ch2 > 'z') && (ch2 < 'A' || ch2 > 'Z');
	}
	public static boolean multipleThree (int threeNum) {
	
		return (threeNum % 3 == 0);
	}
	public static String evenOdd(int EONum) {
		return EONum % 2 == 0 ? "짝수입니다" : "홀수입니다";
	}
	//4. 숫자를 전달하면 해당 숫자의 모든 약수를 배열 형태로 반환하는 함수 
	public static int[] getDivisor(int diviNum) {
		int num = diviNum;
		boolean[] bool = new boolean[num];
		int count = 0;
		
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				bool[i - 1] = true;   //배열 인덱스는 0부터 num미만에 값인걸 기억..
				count++;			//i가 약수일 때 count를 올림. 이걸로  result 길이 값을 구할 수 있음.
			}
		}
		int[] result = new int[count];
		int index = 0;
		for (int i = 0; i < bool.length; i++) {
			if (bool[i]) {    //위에서 true 체크한 것을 돌림. bool[i]가 true면 if문 실행.
				result[index++] = i + 1;  //i는 지금 배열 인덱스에 맞춰져있어서 +1을 해줘야함. 
									//ex: 배열 인덱스는 0~36 이라면 실제 데이터 값은 1~37이다
				
			}
		}
		return result;
	}
	public static boolean sosu(int num) {
		double sqrt = (int) Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean findSosu(int sosuNum) {
		int sosuSqrt = (int)Math.sqrt(sosuNum);
		
		for (int i = 2; i <= sosuSqrt; i++) {
			if (sosuNum % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int factorial(int num) {
		
		int result = 1;
		
		for (int i = num; i > 0; i--) {
			result *= i;
		}
		return result;
	}

}





















