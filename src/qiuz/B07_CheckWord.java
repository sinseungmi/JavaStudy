package qiuz;

import java.util.Scanner;

public class B07_CheckWord {
	public static void main(String[] args) {
		/*
		 * 사용자로부터 단어를 하나 입력 받고
		 * 첫 번째 글자와 마지막 번째 글자가 일치하면 "ok"출력
		 * 아니라면 "not ok"를 출력 
		 * */
		
		String word1 = new Scanner(System.in).next();
		
		System.out.println(word1.charAt(0) == word1.charAt(word1.length() - 1) ? "ok" : "not ok");
		
		
		String word = new Scanner(System.in).next();
		
		if (word.charAt(0) == word.charAt(word.length() - 1)) {
			System.out.println("ok");
		}else {
			System.out.println("not ok");
		}
		
		
//		System.out.print("단어를 입력하세요 : ");
//		String input = new Scanner(System.in).next();
//		String result;
//		
//		/*
//		 * next() : 다음 단어를 String 타입으로 받아오기 (공백 기준, \t기준)
//		 * nextLine() : 다음 한 줄을 String타입으로 받아오기(\n 기준)
//		 * 
//		 * */
//		
//		int lastIndex = input.length()-1;
//		
//		if (input.charAt(0) == input.charAt(lastIndex)) {
//			result = "OK";
//		}else {
//			result = "NOT OK";
//		}
//		System.out.println("첫번째와 마지막 글자가 일치하는가? " + result);
		
	}
}










