
public class A03_VarTypes {
	public static void main(String[] args) {
		/*
		 * 정수 타입
		 * - byte (1byte)
		 * 
		 * 	1byte => 8bit
		 * 
		 * 0000 0000 (0) ~ 1111 1111(255)
		 * 
		 * 첫번째 bit는 부호 비트로 사용된다
		 * 0이 양수, 1이 음수
		 * 
		 * byte 타입의 양수 범위 0000 0000(0) ~ 0111 1111 (127)
		 * byte 타입의 음수 범위 1000 0000(-128) ~ 1111 1111 (-1)  음수에선 -1이 가장 큰 수이기 때문에 1로 채운 것이고,
		 * 									 -128은 가장 작은 수이기 때문에 0으로 채운 것.(음수는 숫자가 올라갈 수록 작은 숫자라는 걸 기억)
		 * 
		 * 
		 * 2 ^ 1 - 2가지
		 * 2 ^ 2 - 4가지
		 * 2 ^ 3 - 8가지
		 * 2 ^ 4 - 16가지
		 * 2 ^ 5 - 32가지
		 * 2 ^ 6 - 64가지
		 * 2 ^ 7 - 128가지
		 * 2 ^ 8 - 256가지
		 * 
		 * - short(2byte,signed)
		 * 
		 * 	2byte -> 16bit
		 * 
		 * 	2 ^ 16 - 65536가지
		 * 
		 * 	short의 양수 범위 0 ~ 32767
		 * 	short의 음수 범위 -32768 ~ -1
		 * 
		 * - char (2byte, unsigned)
		 * 
		 * 	2byte - 16bit 
		 * 
		 * 	2 ^ 16 - 65536가지
		 * 
		 *  부호가 없기 때문에 0 ~ 65535의 양수만 저장할 수 있는 타입
		 *  주로 문자 코드를 저장하는데에 사용한다 (문자 타입)
		 *  
		 *  
		 * - int  (4byte)
		 * 
		 * 	4byte -> 32bit
		 * 
		 * 	2 ^ 32 - 4,294,967,296가지
		 * 
		 * int의 양수 범위 0 ~ 2,147,483,647
		 * int의 음수 범위 -2,147,483,648 ~ -1
		 * 
		 * 
		 * - long (8byte)
		 * 
		 * 	8byte -> 64bit
		 * 
		 * 	2 ^ 64 - ...
		 */
		
		byte maxByte = 127;
		byte minByte = -128;
		System.out.println("byte타입에 저장할 수 있는 가장 큰 값은" + maxByte + "이고, 가장 작은 값은 " + minByte+"입니다");
		
		short maxShort = 32767;
		short minShort = -32768;
		System.out.println("short타입에 저장할 수 있는 가장 큰 값은" + maxShort + "이고, 가장 작은 값은 " + minShort+"입니다");
		
		char maxChar = 65535;
		char minChar = 0;
		char ch = 65;
		
		System.out.println("char 타입에 저장된 값은 기본적으로 문자로 출력된다 " + ch);
		System.out.println("char 타입에 저장된 코드값을 확인하고 싶으면 (int)를 붙인다 " + (int)ch);
		
		System.out.println("char타입에 저장할 수 있는 가장 큰 값은" + (int)maxChar + "이고, "
				+ "가장 작은 값은 " + (int)minChar+"입니다");
		
		int maxInt = 2_147_483_647;
		int minInt = -2_147_483_648;
		System.out.println("int타입에 저장할 수 있는 가장 큰 값은" + maxInt + "이고, 가장 작은 값은 " + minInt+"입니다");
		// 숙제
		
		// int의 범위를 넘어가는 숫자를 사용할 때는 L을 붙여야 한다 (그냥 숫자만 쓰는것은 int)
		long _long = 2_147_483_648L;
		
		
		 /* 실수 타입
		 * 
		 * 	-float (4byte)
		 * 	-double (8byte)
		 * 
		 * 실수는 주로 그래픽 계산에 사용된다.
		 * 부동소수점 방식을 사용한다
		 */
		
		// 그냥 소수만 적는것은 기본적으로 double타입이다.
		// float 타입의 소수는 뒤에 F를 붙여야 한다.
		float weight = 65.66F;
		double height = 177.77;
		
		/* 
		 * boolean 타입
		 * 
		 * 	참과 거짓을 표현하는데에 사용되는 타입
		 * 	값은 true와 false밖에 없다
		 */
		boolean hasFood = true;
		boolean over130cm = false;
		
		 /* 참조형 타입(클래스 타입)
		 * 참조형 타입은 기본형 타입들과는 다르게 대문자로 시작한다.				
				
			- String : 문자열
			- 그 외 모든 클래스들 ..
		 * */
		String helloMessage = "Hello, My name is John Doe.";
		String byeMessage = "Good bye. ";
		
		System.out.println(helloMessage);
		System.out.println("helloMessage");
		
		System.out.println(byeMessage + byeMessage + byeMessage);
		
		
		
		
	}
}
