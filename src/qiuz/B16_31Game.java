package qiuz;

import java.util.Random;
import java.util.Scanner;

public class B16_31Game {
	public static void main(String[] args) {
		/*
		 * 31 게임을 만들어 보세요
		 * 
		 * 1. 컴퓨터와 사람이 번갈아가면서 숫자를 선택해야한다. 
		 * (1,2,3밖에 선택할 수 없음)
		 * 2. 컴퓨터는 랜덤으로 숫자를 선택한다
		 * 3. 선공은 랜덤으로 결정한다
		 * 4. 마지막에 31이상의 숫자를 만든 플레이어가 패배한다
		 *
		 */
		
		Scanner sc = new Scanner(System.in);
		int trun = (int)Math.random() * 2;
		int sum = 0;	
		int user = 0, com = 1;
		
		System.out.println("게임을 시작합니다");
		while (sum <= 31) {

			if (trun == user) {
				System.out.print("숫자를 입력하세요 : ");
				int userChoice = sc.nextInt();
				if (userChoice < 1 || userChoice > 3) {
					System.out.println("다시 입력하세요");
					continue;
				}
				sum += userChoice;
				System.out.println("user choice : " + sum);
				trun = com;
				
			}else if (trun == com) {
				int comChoice = (int)(Math.random() * 3 + 1);
				sum += comChoice;
				System.out.println("com choice : " + sum);
				trun = user;
			}
			if (sum >= 31) {
				System.out.printf("WIN : %s\n",trun == user ? "user" : "com" );
				break;
			}
			
		}
		System.out.println("게임이 끝났습니다");
			
		
		
		
	}
}
