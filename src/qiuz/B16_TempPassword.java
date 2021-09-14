package qiuz;

import java.util.Random;

public class B16_TempPassword {
	public static void main(String[] args) {
		/*
		 * 4자리의 랜덤 임시비밀번호를 생성하는 프로그램을 만들어보세요.
		 * (비밀번호를 구성하는 문자는 영어 대문자와 숫자입니다)
		 * 
		 * */
		
		StringBuilder sd = new StringBuilder();
		
		for (int i = 0; i < 4; i++) {
			int ran = (int)(Math.random() * 2);
			switch(ran) {
			case 0:
				sd.append((int)(Math.random() * 10)); break;
			case 1:
				sd.append((char)(Math.random() * 26 + 65)); break;
			}
			
		}
		System.out.println(sd.toString());
		
		
		StringBuilder sd2 = new StringBuilder();
		String alpNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		for (int i = 0; i < 4; i++) {
			char alpNumGet = alpNum.charAt((int)(Math.random() * alpNum.length()));
			sd2.append(alpNumGet);
		}
		System.out.println(sd2.toString());
		
		
//		// 문자셋을 만들어두고 인덱스를 랜덤으로 선택하는 방식
//		String str = "ABCDEFGFIJKLMNOPQRSTUVWXYZ0123456789";
//		int strSize = str.length();
//		int passwordSize = 4;
//		
//		for (int i = 0; i < passwordSize; i++) {
//			int str_index = (int)(Math.random() * strSize);
//			char ch = str.charAt(str_index);
//			System.out.print(ch);
//		}
//		

		
		
	}
}
