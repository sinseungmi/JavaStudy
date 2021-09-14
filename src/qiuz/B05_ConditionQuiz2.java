package qiuz;

import java.util.Scanner;

public class B05_ConditionQuiz2 {
	public static void main(String[] args) {
		/*
        [ 알맞은 조건식을 만들어보세요 ]

        1. char형 변수 a가 'q'또는 'Q'일 때 true
        2. char형 변수 b가 공백이나 탭이 아닐 때 true
        3. char형 변수 c가 문자('0' ~ '9')일 때 true
        4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
        5. char형 변수 e가 한글일 때 true (유니코드 표 참고)
        6. char형 변수 f가 일본어일 때 true (유니코드 표 참고) 
        7. 사용자가 입력한 문자열이 exit일 때 true
*/        
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String userInput = sc.next();
		
		char a = 'q', b = '\t', c = 'i', d = 'd', e = '가',f = '゠';
		
		System.out.println(!(c < '0' || c > '9'));
		System.out.println(0xA0F3);
		
		System.out.println(a == 'q' || a == 'Q');
		System.out.println(!(b == ' '|| b == '\t'));
		System.out.println(c >='0' && c <= '9');
		System.out.println((d >='a' && d <= 'z') || (d >='A' && d <= 'Z'));
		System.out.println(e >= 44032 && e <= 55215);     //0xA705
		System.out.println(e >= '가' && e <= '힣');
		System.out.println((f >= 0x3040 && f <= 0x309F) || (f >= 0x30A0 && f <= 0x30FF));
		                         //10진수 외에도 이렇게 16진수를 표현할 수 있다. 자바의 정석 52p 참고
		System.out.println(0x3040);
		System.out.println(0x309F);
		//System.out.println((char)44032);
		System.out.println(f >= 12448 && f <= 12543);
		//System.out.println((char)12448);
		System.out.println(userInput.equals("exit"));
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
