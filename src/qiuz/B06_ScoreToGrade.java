package qiuz;

import java.util.Scanner;

public class B06_ScoreToGrade {

	public static void main(String[] args) {
		/*
		 * 점수를 입력받으면 점수에 해당하는 등급을 출력해주는 프로그램을 작성해보세요
		 * 
		 * 90점 이상 : A등급
		 * 80점 이상 : B등급
		 * 70점 이상 : C등급
		 * 60점 이상 : D등급
		 * 그 외 : F등급
		 * 
		 * 유효한 점수는 0 ~ 100점 입니다.
		 * 
		 * */
		
		int score = new Scanner(System.in).nextInt();
		int grade = 'F';
		
		if (score < 0 || score > 100) {
			System.out.println("잘못입력하셨습니다");
		}else {
			if (score >= 90) {
				grade = 'A';
			}else if (score >= 80) {
				grade = 'B';
			}else if (score >= 70) {
				grade = 'C';
			}else if (score >= 60) {
				grade = 'D';
			}
			System.out.printf("당신의 점수는 %d점이고, %c등급입니다",score,grade);
		}
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("점수 입력 : ");
//		int putGrade = sc.nextInt(); //new Scnner(System.in).nextInt();
//		char grade = 'F';
//		
//		if (putGrade > 100 || putGrade < 0) {
//			System.out.println("다시 입력하세요");
//		}else { 
//			if (putGrade >= 90) {
//				grade = 'A';
//			}else if (putGrade >= 80) {
//				grade = 'B';
//			}else if (putGrade >= 70) {
//				grade = 'C';	
//			}else if (putGrade >= 60) {
//				grade = 'D';	
//			}		
//			System.out.printf("당신은 점수 %d점으로 [%c]입니다.\n",putGrade,grade);
//		}
	}

}
