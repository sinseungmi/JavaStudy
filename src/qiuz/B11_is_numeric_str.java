package qiuz;

import java.util.Scanner;

public class B11_is_numeric_str {

	public static void main(String[] args) {
		/*
		 * 입력받은 문자열에 숫자만 포함되어 있으면 result가 1 다른 문자가 포함되어 있다면 result가 0
		 * 
		 */
		
		
		String str = new Scanner(System.in).next();
		int result = 1;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9') {
				result = 0;
				break;
			}
		}
		System.out.println(result);
		
//		System.out.print("문자열을 입력하세요 : ");
//		String input = new Scanner(System.in).next();
//		int result = 1;
//		boolean bool = true;
//
//		for (int i = 0; i < input.length(); i++) {
//			char ch = input.charAt(i);
//			if (!(ch >= '0' && ch <= '9')) {
//				result = 0;
//				break;  
//			} 
//		}
//		System.out.println(result);
//		System.out.println(result == 1 ? "true" : "false");
//		
		
//		for (int i = 0; i < input.length(); i++) {
//			char ch = input.charAt(i);
//			if (!(ch >= '0' && ch <= '9')) {
//				result = 0;
//				bool = false;
//			} 
//			if (bool) {
//				result = 1;
//			}
//			
//		}
//		System.out.println(result);
	}

}
