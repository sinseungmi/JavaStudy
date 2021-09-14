package qiuz;

import java.util.Scanner;

public class B16_GuessNumber {

	public static void main(String[] args) {
		/*
		 * 게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다
		 * 1. 플레이어는 8번의 시도를 할 수 있다
		 * 2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다
		 * 
		 * 	숫자와 위치가 다 맞을 경우 - strike
		 *  숫자만 맞을 경우 - Ball
		 *  
		 *  ex : 정답이 3456일 때
		 *  
		 *  	>> 5634	4Ball
		 *  	>> 3789 1strike
		 *  	>> 3654 1strike 3Ball
		 *  
		 *  # 맞추고 나면 몇 번만에 맞췄는지 알려주기
		 * 
		 * */
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append((int)(Math.random() * 10));
		}
		String number = sb.toString();
		
		
		Scanner sc= new Scanner(System.in);
		String input = null;
		int Attempt = 0;
		int strike = 0, ball = 0;
		boolean bool = true;
		
		while (Attempt <= 8) {
			Attempt++;
			while (bool) {
				System.out.print(Attempt + "번째 시도 : ");
				input = sc.next();
				
				for (int i = 0; i < 4; i++) {
					if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
						if (input.length() == 4) {
							bool = false;
						}else {
							System.out.println("입력 숫자를 초과하였습니다.");
							continue;
						}
					}else {
						System.out.println("숫자만 입력해주세요");
						continue;
					}
				}

			}
		
			
			if (number.equals(input)) {
				strike = 4;
				break;
			}
			for(int i = 0; i < 4; i++) {
				if (number.charAt(i) == input.charAt(i)) {
					strike++;
				}else {
					for (int j = 0; j < 4; j++) {
						if (number.charAt(i) == input.charAt(j)) {
							ball++;
							break;  //number에서 같은 걸 하나 찾았을 때 break
						}
					}
					
				}
			}
			System.out.println(strike + ":strike" + ball + ":ball");
		}
		

	}

}
