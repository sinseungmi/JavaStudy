package qiuz;

import java.util.Scanner;

public class B11_ForBasicQuiz {

	public static void main(String[] args) {
		/*
		 * 사용자가 숫자를 입력했을 때
		 * 
		 * 1. 10부터 입력한 숫자까지의 총합 구하기
		 * 2. 1부터 입력한 숫자 사이의 5의 배수만 모두 출력해보기
		 * 
		 * */
//		
//		int num = new Scanner(System.in).nextInt();
//		int sum = 0;
//		
//		for(int i = 10; i <= num; i++) {
//			sum += i;
//			System.out.println(sum);
//		}
//		System.out.println(sum);
		
		
//		int num = new Scanner(System.in).nextInt();
//		int sum = 0;
//		for (int i = Math.min(10,num); i <= Math.max(10,num); i++) {
//			sum += i;
//			System.out.println(sum);
//		}
//		System.out.println(sum);
		
//		
		System.out.print("숫자를 입력하세요 : ");
		int num = new Scanner(System.in).nextInt();
		int sum = 0;
								  
		for (int i = Math.min(10, num); i <= Math.max(10, num); i++) {
			sum += num;
		}
		System.out.println(sum);
		
		int i = Math.min(1, num);
		int j = Math.max(1, num);
		System.out.printf("++++ %d ~ %d까지 5의 배수 출력++++\n",i,j);
		for (; i <= j; i++) {
			if (i % 5 == 0) {
				System.out.println(i);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.print("숫자 입력 : ");
//		int input = new Scanner(System.in).nextInt();
//		int sum = 0; 
//		
//		for (int i = 10; i <= input; ++i) {
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		for (int i = 1; i <= input; ++i) {
//			if(i % 5 == 0) {
//				System.out.println(i);
//			}
//		}
//		for (int i = 1; i <= input; i += 5) {
//			if(i % 5 == 0) {
//				System.out.println(i);
//			}
//		}
//		
//		// 1번 문제의 시작 숫자는 10, 2번 문제의 시작 숫자는 1
//        int start1 = 10, start2 = 1;
//        
//        int end1 = -50, end2 = -50;
//        int sum = 0;
//        
//        // 만약 start값이 end값보다 크다면, 두 값을 교환한다
//        if (start1 > end1) {
//                int temp = start1;
//                start1 = end1;
//                end1 = temp;
//        }
//        
//        if (start2 > end2) {
//                int temp = start2;
//                start2 = end2;
//                end2 = temp;
//        }
//        
//        for (int i = start1; i <= end1; ++i) {
//                sum += i;                
//        }                
//        
//        System.out.println("10부터 user가 입력한 숫자까지의 총합: " + sum);
//        
//        System.out.println();
//        System.out.printf("#### %d ~ %d 사이의 5의 배수만 출력 ####\n", 
//                        start2, end2);
//        for (int i = start2; i <= end2; ++i) {
//                
//                if (i % 5 == 0) {
//                        System.out.println(i);
//                }                        
//        }

	}

}








