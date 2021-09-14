package qiuz;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class D07_checkValidSocialNumber {
	
	/*
	 * 사용자가 주민등록번호를 입력하면
	 * 그 주민등록번호가 유효한지 검사하는 프로그램을 만들어보세요
	 * 
	 * 맨앞 2자리 숫자
	 * 월 자리에 01 ~ 12 이내의 숫자
	 * 일 자리에 01 ~ 31 이내의 숫자 
	 * (1,3,5,7,8,10,12월이면 31 / 4, 6, 9, 11월이면 30 / 2월은 윤년일때 29 아니면 28)
	 * 7번째 자리 '-'
	 * 맨 앞자리 1 ~ 4
	 * 
	 * */
	//960925-2179720
	
	private static HashSet<Integer> month31;
	private static HashSet<Integer> month30;
	private static HashSet<Integer> gender2000;
	
	//static을 생성자에서 초기화하면 낭비이므로 static 블록에서 초기화한다
	//클래스(static) 초기화 블럭은 처음 메모리에 로딩될 때 한번만 수행된다
	//클래스(static)초기화 블럭은 클래스 변수의 초기화에 사용된다(자바의 정석 205p 참고)
	//이 파일이 실행될 때 클래스 초기화 블럭이 가장 먼저 수행된다
	static {
		month31 = new HashSet<>();
		month30 = new HashSet<>();
		gender2000 = new HashSet<>();
		
		//T...elements : 가변인자
		//가변인자? 매개변수가 몇개들어오는지 모를때
		Collections.addAll(month31, 1,3,5,7,8,10,12);
		Collections.addAll(month30, 4,6,9,11);
		Collections.addAll(gender2000, 3,4,7,8);  //Collections.addAll을 쓴 이유는 가변인자 때문에
		
	}
	
	class InvalidMonthException extends RuntimeException{
		public InvalidMonthException() {
			super("주민등록번호 3,4에 올바르지 않은 값 입력됨");
		}
	}
	
	class InvalidDateException extends Exception{
		public InvalidDateException() {
			super("주민등록번호 5,6에 올바르지 않은 값 입력됨");
		}
	}
	
	public boolean isValidSocialNumber(String sn)
	throws InvalidMonthException,InvalidDateException{
		if (sn.length() != 14 || sn.charAt(6) != '-') {
			System.out.println("잘못된 주민등록 번호");
			return false;
		}
		
		try {
			int year = Integer.parseInt(sn.substring(0, 2));
			int month = Integer.parseInt(sn.substring(2, 4));
			int day = Integer.parseInt(sn.substring(4, 6));
			int back_number = Integer.parseInt(sn.substring(7));
			
			//원래는 성별 번호를 보고 3,4면 2000을 더해야함
			int gender = sn.charAt(7) - '0';
			year = year + (gender2000.contains(gender) ? 2000 : 1900);
			
			System.out.println("gender: " + gender);
			System.out.println("year: " + year);
			System.out.println("주민등록번호 뒷자리: " + back_number);
			
			boolean day29 = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
			
			
			if (month > 12) {
				throw new InvalidMonthException();
			}else if (month31.contains(month) && day > 31) {
				throw new InvalidDateException();
			}else if (month30.contains(month) && day > 30) {
				throw new InvalidMonthException();
			}else if (month == 2 && !day29 && day > 28) {
				throw new InvalidDateException();
			}else if (month == 2 && day29 && day > 29) {
				throw new InvalidDateException();
			}
		} catch (NumberFormatException e) {
			System.out.println("[invalid] 숫자가 아닌 것이 있음");
			return false;
		}// catch (InvalidMonthException e ) {
			//System.out.println("[invalid]" + e.getMessage());
			//return false;
		//}
		return true;
		
	}
	
	public static void main(String[] args) {
		D07_checkValidSocialNumber check = new D07_checkValidSocialNumber();
		//check.check_socialNumber("960925-5179720");
		
		try {
			if (check.isValidSocialNumber("960925-2179720")) {
				System.out.println("올바른 주민등록번호");
			}else {
				System.out.println("올바르지않은 주민등록번호");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	private static boolean checkNumeric(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	public void check_socialNumber(String socialNumber) {
		
		char[] social_characters = socialNumber.toCharArray();
		int month = Integer.parseInt(socialNumber.substring(2, 4));
		int day = Integer.parseInt(socialNumber.substring(4, 6));
		int socialNum_len = socialNumber.length();
		
		for(int i = 0; i < socialNum_len; i++) {
			if(social_characters[6] != '-' || socialNum_len != 14 || !checkNumeric(social_characters[i])) {
				System.out.println("올바르지 않은 주민번호입니다");
				break;
			}else if (!(month > 0 && month < 13) || !(day > 0 && day < 32)) {
				System.out.println("올바르지않은 생년월일입니다");
				break;
			}else if (social_characters[7] < '1' || social_characters[7] > '4') {
				System.out.println("올바르지 않은 주민번호입니다");
				break;
			}else {
				System.out.println("입력완료되었습니다");
				break;
			}
		}
	}

}






























