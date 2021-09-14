package qiuz;

import java.util.Random;
import java.util.Scanner;

public class B17_CountRandomFruit {

	public static void main(String[] args) {
		/*
		 * 1. 사용자로부터 배열의 크기를 입력 받는다
		 * 
		 * 2. 해당 크기만큼의 배열에 랜덤 과일 문자열을 저장한다.
		 * (랜덤으로 등장하는 과일 :
		 *  apple, banana, kiwi, orange, peach, strawberry, pineapple)
		 *  
		 * 3. 각 과일이 몇 번 등장 했는지 모두 기록하고 출력해본다
		 * 
		 * */
		
		System.out.print("숫자를 입력하세요 :");
		int input = new Scanner(System.in).nextInt();
		String[] userArr = new String[input];
		
		String[] fruit = {"apple", "banana", "kiwi", "orange", "peach", "strawberry", "pineapple"};
		int[] count = new int[fruit.length];
		
		for (int i = 0; i < userArr.length; i++) {
			int index = (int)(Math.random() * fruit.length);
			userArr[i] = fruit[index];
			//System.out.println(userArr[i]);
			for (int j = 0; j < fruit.length; j++) {
				if(userArr[i].equals(fruit[j])) {
					count[j]++;
				}
				
			}
			
		}
		for (int i = 0; i < fruit.length; i++) {
			System.out.println(fruit[i] + ":" + count[i] + "번");
		}


	}

}
