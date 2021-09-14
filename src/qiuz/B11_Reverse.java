package qiuz;

import java.util.Scanner;

public class B11_Reverse {
	public static void main(String[] args) {
		//사용자가 문장을 입력하면 그 문장을 거꾸로 출력해보세요
		
		String sentence = new Scanner(System.in).next();
		String reverseStr = "";
		
		for (int i = 0, j = sentence.length()-1; i <= j; j--) {
			reverseStr += sentence.charAt(j);
		}
		System.out.println(reverseStr);
		
		
		String str = new Scanner(System.in).nextLine();
		StringBuilder sb = new StringBuilder();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(str.length() - 1 - i);
			sb.append(ch);
			
		}
		long end = System.currentTimeMillis() - start;
		System.out.println(end);
		System.out.println(sb);
		String str2 = sb.toString();
		
		
//		System.out.print("문장을 입력하세요 : ");
//		String input = new Scanner(System.in).next();
//		String connect = ""; 
//		
//		for (int i = input.length()-1; i >= 0; i--) {
//			char ch = input.charAt(i);
//			connect += ch; 
//			//System.out.print(ch);
//		}
//		System.out.printf("[%s]문장을 거꾸로했을 때 결과는 [%s]입니다.",input,connect);
//		
	}
}
