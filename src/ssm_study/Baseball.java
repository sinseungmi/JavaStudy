package ssm_study;

import java.util.Scanner;

public class Baseball {

	/*
	 * 게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다
	 * 
	 * 1. 플레이어는 8번의 시도를 할 수 있다
	 * 
	 * 2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다
	 * 
	 * 숫자와 위치가 다 맞을경우 - Strike 숫자만 맞을경우 - Ball
	 * 
	 * ex: 정답이 3456일때
	 * 
	 * >> 5634 4 Ball >> 3789 1 Strike >> 3654 1 Strike 3 Ball
	 * 
	 * ※ 맞추고 나면 몇 번만에 맞췄는지 알려주기
	 */
	public static void main(String[] args) {
		final boolean DEBUGMODE = true;

		StringBuilder answer_builer = new StringBuilder();
		Scanner input_scanner = new Scanner(System.in);

		for (int i = 0; i < 4; ++i) {
			answer_builer.append((int) (Math.random() * 10));
		}
		String answer = answer_builer.toString();

		if (DEBUGMODE) {
			System.out.printf("이번 정답 [%s]\n", answer);
		}

		// 기본 타입 변수는 0으로 초기화
		int strike = 0, ball = 0;
		int tryCount = 0;

		// 참조형 변수는 null로 초기화
		String input = null;

		while (strike != 4 && tryCount != 8) {
			strike = 0;
			ball = 0;

			while (true) {
				System.out.printf("시도 %d >> ", tryCount + 1);
				input = input_scanner.nextLine();

				boolean valid = true;

				if (input.length() != 4) {
					valid = false;
				}

				for (int i = 0; valid && i < 4; ++i) {
					if (input.charAt(i) < '0' || input.charAt(i) > '9') {
						valid = false;
					}
				}

				if (valid) {
					break;
				} else {
					System.out.println("4자리 숫자만 입력하셔야 합니다.");
				}
			}

			// strike, ball 체크
			if (answer.equals(input)) {
				strike = 4;
			} else {
				for (int i = 0; i < 4; ++i) {

					if (answer.charAt(i) == input.charAt(i)) {
						strike++;
					} else {
						for (int j = 0; j < 4; ++j) {
							if (answer.charAt(i) == input.charAt(j)) {
								ball++;
								break;
							}

						}
					}

				}
			}

			System.out.printf("%d strike, %d ball!\n", strike, ball);

			tryCount++;
		}

		System.out.println("게임 종료!");
	}

}
