package qiuz;

import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public class D07_checkValidPhoneNumber {

	/*
	 * 사용자로부터 핸드폰 번호를 입력 받으면 올바른 전화번호인지 구분하는 프로그램을 만들어보세요
	 * 
	 * 앞의 3자리가 숫자 두번째 숫자는 3자리 혹은 4자리 세번째 숫자는 4자리 4번째 또는 8번째 또는 9번째 문자는 '-'
	 */

	private static boolean checkNumeric(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public static boolean checkValidPhoneNumber(String phoneNumber) {
		int len = phoneNumber.length();

		if (len != 12 && len != 13) {
			System.out.println("[invalid] 길이가 올바르지 않음");
			return false;
		}

		for (int i = 0; i < len; ++i) {

			char ch = phoneNumber.charAt(i);

			if (i < 3 && !checkNumeric(ch)) {
				System.out.println("[invalid] 맨앞 3자리에 숫자 아닌것이 있음");
				return false;
			} else if ((i == 3 || (i == 7 && len == 12) || (i == 8 && len == 13)) && ch != '-') {
				System.out.println("[invalid] 하이픈 자리가 올바르지 않음");
				return false;
			} else if (i > 3 && ((len == 12 && i < 7) || (len == 13 && i < 8)) && !checkNumeric(ch)) {
				System.out.println("[invalid] 가운데 자리에 숫자 아닌것이 있음");
				return false;
			}else if (((i > 7 && len == 12) || (i > 8 && len == 13)) 
					&& !checkNumeric(ch)) {
				System.out.println("[invalid] 마지막 자리에 숫자 아닌것이 있음");
				return false;
				
				
		}
			// 010-730-9730
	}
		return true;

	}

	public void check(String number) {

		char[] number_ch = number.toCharArray();

		for (int i = 0; i < number.length(); i++) {
			if (number_ch[i] < '0' && number_ch[i] > '9') {
				System.out.println("숫자를 입력하세요");
				break;

			} else if (number.length() == 13) {
				if (number_ch[3] == '-' && number_ch[8] == '-') {
					System.out.println(number + "번호입력 성공");
					break;
				} else {
					System.out.println("-이 없음");
					break;
				}
			} else if (number.length() == 12) {
				if (number_ch[i] >= '0' && number_ch[i] <= '9') {
					if (number_ch[3] == '-' && number_ch[9] == '-') {
						System.out.println(number + "번호입력 성공");
						break;
					} else {
						System.out.println("-이 없음");
						break;
					}
				}
			} else {
				System.out.println("길이가 맞지않습니다");
				break;
			}

		}

	}

	public static void main(String[] args) {
		new D07_checkValidPhoneNumber().check("010-123412345");

		if (checkValidPhoneNumber("123-12a4-2344")) {
			System.out.println("올바른 핸드폰 번호 입니다!");
		}
	}

}
