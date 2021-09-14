package qiuz;

import java.util.Scanner;

public class B17_CountAlphabet {

	public static void main(String[] args) {
		/*
		 * 사용자로부터 문장을 하나 입력 받고 
		 * 해당 문장에 어떤 알파벳이 몇 번 등장 했는지 세어서 모두 출력해보세요
		 * (대소문자 구분 없이 셀 것)
		 * 
		 * */
		String input = new Scanner(System.in).next();
		
		//대상 문자열을 모두 대문자로 변환한다
		input = input.toUpperCase();
		int[] count = new int[26];
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				count[ch - 'A']++;
			}
		}
		char ch = 'A';
		for (int i = 0; i < count.length; i++) {
			System.out.println(ch + ":" + count[i]);
			//ch = (char)(ch + 1);
			ch++;
		}

	}

}













