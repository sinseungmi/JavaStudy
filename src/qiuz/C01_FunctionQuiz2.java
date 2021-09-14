package qiuz;

import java.util.Arrays;
import java.util.Scanner;

public class C01_FunctionQuiz2 {
	/*
	 * 다음의 함수를 정의하고 올바르게 동작하는지 테스트해보세요
	 * 
	 * 1. 최대값을 매개변수로 전달 받으면 0부터 최대값 미만의 모든 값을 포함하는 int배열을 생성하여 반환하는 range 함수를
	 *    만들어보세요 (최대값 미만)
	 *    
	 *    ex : range(10)의 결과 -> [0,1,2,3,4,5,6,7,8,9]
	 * 
	 * 2. 최소값과 최대값을 매개변수로 받으면  그 사이에 존재하는 모든 값을 포함하는 int배열을 생성하여 반환하는
	 * 	range 함수를 만들어보세요 (최소값 이상, 최대값 미만)
	 * 
	 *    ex : range(5,10)의 결과 -> [5,6,7,8,9]
	 *    
	 * 3. 최소값과 최대값과 증가값을 매개변수로 받으면 최소값에서 시작하여 최대값까지 증가값만큼 증가하는 int 배열을
	 *    생성하여 반환하는 range함수를 만들어보세요(최소값 이상, 최대값 미만)
	 * 
	 * 	  ex : range(50,56,5)의 결과 -> [50,55]
	 * 	  	   range(50,55,5)의 결과 -> [50]
	 * 
	 * */
	
	//매개변수의 개수 혹은 타입이 다르면 같은 함수명을 사용할 수 있다
	// (함수의 오버로딩, function overloading)
	public static int[] range(int num) {
		int[] allNum = new int[num];
		
		for (int i = 0; i < allNum.length; i++) {
			allNum[i] = i;
		}
		return allNum;
	}
	
	public static int[] range(int start, int end) {
//		int[] allNum = new int[Math.max(num1, num2) - Math.min(num1, num2)];
//		int index = 0;
//		for (int i = Math.min(num1, num2); i < Math.max(num1, num2); i++) {
//			allNum[index++] = i;
		if (start >= end) {
			return null;
		}
		
		int[] allNum = new int[end - start];
		
		for (int i = 0, num = start; i < allNum.length; i++,num++) {
			allNum[i] = num;
		}
		return allNum;
	}
	
	public static int[] range(int start, int end, int increment) {
		int index = 0;
		int len = (int)Math.ceil((end - start) / (double)increment);
		//int len = (end - start) / increment;
	
		int[] allNum = new int[len];
		
		for (int i = 0, num = start; i < allNum.length; i++, num += increment) {
			allNum[i] = num;
		}
		return allNum;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println(Arrays.toString(range(num)));
		System.out.println(Arrays.toString(range(num,num2)));
		System.out.println(Arrays.toString(range(num,num2,num3)));
//		System.out.println(range(10)[2]);
//		
//		System.out.println(Arrays.toString(range(10,25)));
//		System.out.println(Arrays.toString(range(25,10)));
	}

}
