package qiuz;

public class A03_Introduce {
	public static void main(String[] args) {
		
		String name = "홍길동", tel = "010-1234-1234", blood = "O" ;
		int age = 20, weight = 75;
		float height = 178.5f;
		boolean sleep = true;
		
	
		System.out.println(
				"=========출력 결과=========\n\n"
				+ "이름   : "+ name 
				+"\n나이   : " + age 
				+ "\nTel  : " + tel 
				+ "\n키      : " + height 
				+ "\n몸무게	: " + weight
				+ "\n혈액형	: " + blood
				+ "\n잠 잘잤나? " + sleep);
		
	}
}
