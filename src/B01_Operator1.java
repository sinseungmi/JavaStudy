
public class B01_Operator1 {
	public static void main(String[] args) {
		/*
		 * 연산자 (Operator)
		 * 	- 계산할 때 사용하는 것
		 * 	- +, -, *, / ...
		 * */
		
		//산술 연산자
		int a = 10, b = 7;
		double c = 7.0;
		
		System.out.println("+ : " + (a + b));
		System.out.println("- : " + (a - b));
		System.out.println("* : " + a * b);   
		//정수끼리 나누면 몫만 나온다
		System.out.println("/ : " + a / b);//곱하기와 나누기는 우선순위가 높기 때문에 먼저 계산되기 때문에 괄호 안쳐도 됨
		//정수와 실수를 나누면 정확한 값을 계산한다
		System.out.println("/ : " + a / c);
		System.out.println("/(double) : " + a / (double)b);
		System.out.println("/(float) : " + a / (float)b);
		
		System.out.println("% : " + a % b);  //나머지
		
		System.out.println("제곱 : " + Math.pow(a,3));  // Math.pow([대상 숫자], [거듭제곱 횟수]);
		System.out.println("제곱? " + (a ^ b)); //^는 제곱이 아니다
		
		System.out.println("제곱근 : " + Math.sqrt(16));  //ex: 25의 제곱근을 구하시오는 무엇을 제곱하면 25가 되는지
														//그 정답을 구하시오로 풀이.답은 5.
														//25의 제곱을 구하시오는 25 x 25 이므로 625, 4의 제곱은 
														//4 x 4 = 16 이런 것
		
		System.out.println("절대값 : " + Math.abs(25));
		
		System.out.println("소수 첫째 자리에서 반올림 : " + Math.round(3.335));
		/*
		 * Math.round()는 소수 첫째 자리에서만 반올림 할 수 있다
		 * 반올림하고 싶은자리를 소수 첫째 자리로 만들만큼 곱한 후 다시 나누는 방식을 통해
		 * 원하는 자릿수에서 반올림 할 수 있다
		 */
		System.out.println("소수 셋째 자리에서 반올림 : " + Math.round(3.335 * 100) / 100.0);
		System.out.println("소수 첫째 자리에서 반올림 : " + Math.round(3.666));
		
		System.out.println("올림 : " + Math.ceil(1.001));
		System.out.println("내림 : " + Math.floor(1.999));
		
		System.out.println("더 큰 숫자남기기 : " + Math.max(1900, 1500));
		System.out.println("더 작은 숫자남기기 : " + Math.min(1900, 1500));
		
		//비트 연산
		// &, |, ^, >>, <<
		
		//a = 10, b = 7
		// -> a = 1010, b = 0111
	
		// 1010
		// 0111
		//-------&
		// 0010 -> 2
		System.out.println("a & b: " + (a & b));  //AND
		
		// 1010
		// 0111
		//-------|
		// 1111
		System.out.println("a | b : " + (a | b));  //OR
		
		// 1010
		// 0111
		//-------^ 위아래가 다를 때 1
		// 1101
		System.out.println(a ^ b);  //XOR
		
		
		//정수 8의  비트를 2만큼 왼쪽으로 이동시킨다(빈자리는 0으로 채워짐)
		System.out.println(8 << 2); //SHIFT
		//00001000 
		//00100000 << 2
		
		System.out.println(8 >> 2); //SHIFT
		//00001000
		//00000010 >> 2
		
		
	}
}




















