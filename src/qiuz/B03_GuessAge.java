package qiuz;

import java.util.Scanner;

public class B03_GuessAge {
	public static void main(String[] args) {
		//사용자로부터 태어난 해와 올해의 년도를 입력받으면
		//그 사람의 한국 나이를 계산하여 몇살인지 알려주는 프로그램을
		//만들어보세요
		
		Scanner sc = new Scanner(System.in);
		int bornYear = sc.nextInt();
		int thisYear = sc.nextInt();
		
		int age = thisYear - bornYear + 1;
		
		System.out.printf("올해는 %d년 입니다.그리고 당신이 태어난 해는 %d년이고 나이는 %d살입니다",
				thisYear,bornYear,age);
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("태어난 해 입력 : ");
//		int bornYear = sc.nextInt();
//		
//		System.out.print("올해년도 입력 : ");
//		int year = sc.nextInt();
//		
//		System.out.printf("태어난 해는 %d년이며 나이는 %d살입니다\n",bornYear, year-bornYear+1);
		
		
	}

}
