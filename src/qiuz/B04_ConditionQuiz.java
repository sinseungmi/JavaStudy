package qiuz;

public class B04_ConditionQuiz {

	public static void main(String[] args) {
		
		/*
		 * [알맞은 비교연산을 만들어보세요]
		 * 
		 * 1. int형 변수 a가 10보다 크고 20보다 작을 때 true
           2. int형 변수 b가 짝수일 때 true                
           3. int형 변수 c가 7의 배수일 때 true
           4. int형 변수 hour가 0미만 24이상이 아니고, 12이상일 때 true
           5. int형 변수 d와 e의 차이가 30일 때 true                
           7. 민수가 철수보다 2살 많으면 true
           8. 민수가 철수보다 생일이 3달 빠르면 true  
           9. boolean형 변수 powerOn이 false일 때 true
           10. 문자열 참조변수 str이 "yes"일 때 true
		 *
		 * */
		
//		int a = 16, c = 70, hour = 12, d = 30, e = 60, min = 24, chul = 26;
//		boolean powerOn = false;
//		System.out.println(a > 10 && a < 20);
//		System.out.println(a % 2 == 0);
//		System.out.println(c % 7 == 0);
//		System.out.println(!(hour < 0 && hour >= 24) && hour >= 12);
//		System.out.println(d - e == 30 || e - d == 30);
//		System.out.println(min - chul == 2);
//		System.out.println(!powerOn);
		
		
//		6. int형 변수 year가 400으로 나누어 떨어지거나  
//		또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
//		연도가 4의 배수이면서 100의 배수가 아닐때와 연도가 400의 배수인 것을 or 논리연산을 통해 둘 중에 하나만 참이어도 윤년이 나오게 한다.
		
		int Year = 2021;
		
		System.out.println(Year % 400 == 0 || (Year % 4 == 0 && Year % 100 != 0));
		
		
		int a =13, b = 44, c = 49, hour = 13,d = 90,e = 60, year = 800,minsu = 18, chulsoo = 8;
		int minsuBirth = 12, chulsooBirth = 9;
		boolean powerOn = false;
		String str = "ys";
		
		//비교를 할 때 변수가 왼쪽에 있는 것이 좋다
		System.out.println(a > 10 && a < 20);
		System.out.println(b % 2 == 0);
		System.out.println(c % 7 == 0);
		System.out.println((hour < 24 && hour >= 12)); 
		System.out.println(d - e == 30 || e - d == 30); 
		System.out.println(Math.abs(d-e) == 30);
//		6. int형 변수 year가 400으로 나누어 떨어지거나  
//		또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
//		연도가 4의 배수이면서 100의 배수가 아닐때와 연도가 400의 배수인 것을 or 논리연산을 통해 둘 중에 하나만 참이어도 윤년이 나오게 한다.
		System.out.println(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));  //윤년
		System.out.println(minsu - chulsoo == 2);
		System.out.println(chulsoo + 2 == minsu);
		System.out.println( minsuBirth >= 1 && minsuBirth <= 12 && chulsooBirth >= 1 && chulsooBirth <= 12 && minsuBirth - chulsooBirth == 3);
		System.out.println(!(powerOn));
		
		//문자열(참조형 타입)은 ==으로 비교하면 안된다.
		//참조형 타입의 값을 비교할 때는 해당 클래스에 정의 되어 있는 equals()라는 메서드를 이용해야한다.
		System.out.println(str == "yes");
		System.out.println(str.equals("yes"));
		
		//기본형 타입과 참조형 타입의 차이점
		// - 기본형 타입은 내부 데이터의 크기를 예측하기 쉽다 (차곡차곡 쌓이는 메모리를 사용, Stack),크기가 일정
		// - 참조형 타입은 내부 데이터의 크기를 예측하기 어렵다 (여기 저기 막 쓰는 메모리를 사용, Heap), 크기가 일정치 않음
		
		String str1 = "yes";
		String str2 = new String("yes"); //주소 새로 만든 것
		String str3 = "yes";  
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1.equals(str2) : " + str1.equals(str2));  //주소는 다르지만 내용은 같다
		System.out.println("str1 == str3 : " + (str1 == str3));  //str3가 str1주소를 재사용이여서 true(주소 비교)
		System.out.println(str1.equals(str3));
		
	}

}
