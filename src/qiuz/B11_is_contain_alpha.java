package qiuz;

import java.util.Scanner;

public class B11_is_contain_alpha {
	public static void main(String[] args) {
		//사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true를 출력, 없으면 false를 출력
		
		System.out.print("문자열 입력: ");
		String input = new Scanner(System.in).next();
		boolean bool = false;
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				bool = true;
				break;
			}	
			
		}
		System.out.println(bool);
		
		
		
	}

}
