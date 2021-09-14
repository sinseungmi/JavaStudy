package qiuz;

import java.util.Scanner;

public class B11_Palindrome {

	public static void main(String[] args) {
		/*
		 *  사용자로부터 단어를 하나 입력받고
		 *  해당 단어가 회문이라면  "PALINDROME"
		 *  회문이 아니라면 "NOT PALINDROME"를 출력
		 *  
		 *  회문? MOM, BOB, ABBA, MADAM  처럼 좌우 대칭인 단어
		 * 
		 * */
		
		String word = new Scanner(System.in).next();
		String result = "PALINDROME";
		
		for(int i = 0, j = word.length() - 1; i < word.length() / 2; i++,j--) {
			if(word.charAt(i) != word.charAt(j)) {
				result = "NOT PALINDROME";
				break;
			}
		}
		System.out.println(result);
		
//		String word = new Scanner(System.in).next();
//		String result = null;
//											// /2를 하는 이유는 앞뒤를 동시에 같이 비교하니까
//		for (int i = 0, j = word.length() - 1; i <= (j / 2); i++, j--) {
//			char firstCh = word.charAt(i);
//			char endCh = word.charAt(j);
//			if (firstCh == endCh) {
//				result = "PALINDROME";
//			}else {
//				result = "NOT PALINDROME";
//				
//			}
//		}
//		System.out.println(result);
		
//		System.out.print("단어를 입력하세요 : ");
//		String word = new Scanner(System.in).next();
////		String result = "PALINDROME";
//		boolean result = true;
//		
//													//DAFG | HHAA (/2하는 이유)
//		for (int i = 0, j = word.length()-1; i < word.length()/2; i++,j--) {
//			char ch = word.charAt(i);
//			char ch2 = word.charAt(j);
//			System.out.printf("%c VS %c\n",ch,ch2);
//			if (ch != ch2) {
//				result = false;
//				break;
//			}
//		}
//		System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
//		
		
//		for (int i = 0; i < word.length()/2; i++) {
//			char ch = word.charAt(i);
//			char ch2 = word.charAt(word.length() - 1 - i);
//			if (ch != ch2) {
//				result = "NOT PALINDROME";
//				break;
//			}
//		}
//		System.out.println(result);
		
		
//		for (int i = 0, j = word.length()-1; i < word.length(); i++,j--) {
//			char ch = word.charAt(i);
//			char ch2 = word.charAt(j);
//			if (ch != ch2) {
//				result = "NOT PALINDROME";
//				break;
//			}
//		}
//		System.out.println(result);
		
		
	}

}




























