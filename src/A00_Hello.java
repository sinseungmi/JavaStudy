
/*
 	# 주석 
 	- 프로그래머가 하고 싶은 말을 적는 것
 	- 주로 이 소스를 보게 될 다른 프로그래머들에게 전달하는 용도로 사용
 	
 	
 	# Eclipse 단축키 정리
 	
 	- ctrl + w : 창닫기
 	- ctrl + shift + w : 창 다 닫기
 	- ctrl + shift + / : 여러 줄 주석
 	- ctrl + shift + \ : 여러 줄 주석 제거
 	- ctrl + [+,-] : 글자 크기 조절
 	- ctrl + F11 : 소스 코드 컴파일 및 실행 (Run)
 	- Alt + 방향키  : 줄 옮기기
 	- Shift + Tab : 거꾸로 들여쓰기
 	- Shift + End : 커서의 현재 위치부터 맨 뒤까지 블록 지정
	- Shift + Home : 커서의 현재 위치부터 줄 맨 앞까지 블록 지정
 	- Ctrl + Y : 방금 되돌린 것을 취소
 	- Ctrl + Shift + F : 코드 정렬
     
 */

/** 문서화 주석(말풍선에 등장하게 되는 주석) */

// public class의 이름은 반드시 파일명과 같아야 한다
public class A00_Hello {   
//빨간 줄이 생겼을 때는 그곳에 커서를 두고 F2를 누르면 에러에 대한 정보와 해결책을 볼 수 있다.
	
	/* main() 함수
	 * 
	 * - 프로그램의 시작 지점
	 * - 사용자가 프로그램을 시작하면 가장 먼저main() 함수를 찾아서 실행시킨다
	 * - main() 함수의 범위는 중괄호{}로 결정된다
	 * 
	 * 함수란?
	 * - 어떤 단어 뒤에 ()가 있는 것은 모두 함수라고 부른다
	 * 
	 * */
	
	public static void main(String[] args) {
		//프로그램 시작
		
		/* 
		 * system.out.println() 함수
		 * -()안에 전달한 데이터를 콘솔에 출력하는 함수
		 * 
		 *  콘솔
		 *  -글자만 나오는 검은 화면(옛날 컴퓨터 화면)
		 *  -Eclipse에서는 테스트용으로 하얀 바탕의 콘솔을 제공한다
		 *  -ctrl + f11를 누르면 우리가 만든 프로그램을 테스트용 콘솔 창에서 실행할 수 있다
		 *  -우리가 만든 소스 코드(.java)의 결과물(.class)을 bin폴더에 저장되어 있다
		 * 
		 * */
		System.out.println("Hello World 1");
		System.out.println("Hello World 2");
		System.out.println("Hello World 3");		
		System.out.println("Hello World 4");
		System.out.println("Hello World 5");
		System.out.println(1234 + 55);
		System.out.println("1234" + 55);
		
		/*
		 * 자바의 데이터들(리터럴)
		 * 
		 *  리터럴은 데이터 그 자체를 뜻 한다. 
 		 *  변수에 넣는 변하지 않는 데이터를 의미하는 것이다.
		 * 
		 * 1. "" 사이에 적는 것들 : 문자열(String), 문자를 여러개 쓸 수 있는 데이터 타입
		 * 2. '' 사이에 적는 것 : 문자(Character),문자 단 하나만 쓸 수 있는 데이터 타입
		 * 3. 숫자를 적는 것 : 정수(Integer)
		 * 4. 소수를 적는 것 : 실수(Float, Double)
		 * 5. true, false
		 * 
		 * */
		
		System.out.println("ABCDEF 라랄랄");
		System.out.println('한');
		System.out.println('韓');
		System.out.println('2');
		System.out.println('#');
		System.out.println(10000 + 20000);
		System.out.println(123.435 + 2434.35);
		System.out.println(true);
		System.out.println(false);
		
		//문자들은 실제로는 숫자 값을 가지고 있다
		//우리 눈에 보일 때만 문자로 보이는 것이다
		
		//''타입은 숫자타입으로 전환될 수 있고 숫자 타입도 ''타입으로 전환될 수 있다
		//문자와 정수는 실제로는 거의 같은 타입이며 서로 계산도 가능하다
		System.out.println('A');
		System.out.println((int)'A');
		System.out.println((int)'한');	//(int)의 역할 - 문자를 숫자로 보이게 함
		System.out.println((char)54621); //(char)의 역할 - 숫자를 문자로 보이게 함
		System.out.println((int)'가');
		
		System.out.println((char)('A' +  0));
		System.out.println((char)('A' +  1));
		System.out.println((char)('A' +  2));
		System.out.println((char)('A' +  3));
		System.out.println("A" + 2);  //문자와 숫자 계산은 char만 가능하다. 아스키코드!!
		
		System.out.println((int)'A');
		System.out.println((int)'a');
		
		//문자열 타입과 다른 타입을 더하면 계산을 하는 것이 아니라 이어붙인다
		System.out.println("'A'의 보여지는 모습 : " + 'A');
		System.out.println("'A'의 코드 값 : " + (int)'A');
		System.out.println("'1'의 코드 값 : " + (int)'1');
		System.out.println("1" + 5);	//문자열 + 숫자
		System.out.println('1' + 5);	//문자(코드값) + 숫자
		System.out.println(1 + 5);		//숫자 + 숫자
		
		// 정수 + 실수는 실수가 된다
		System.out.println(10 + 10.123);
		
		// 정수 + 문자는 정수가 된다
		System.out.println('a' + 10);
		System.out.println((char)('a' + 10));
		
		// ; (세미콜론)
		// -  한 명령어가 끝났음을 알린다

		//프로그램 끝 
	}
	
} 





























