package qiuz;

public class B15_WhileBasicQuiz {

	public static void main(String[] args) {
		/*
		 * while문을 이용하여 다음을 구하시오
		 * 
		 * 1. 1부터 100까지의 3의 배수의 총합
		 * 2. 200부터 1까지 출력
		 * 3. continue를 이용하여 300부터 500사이의 7의 배수만 출력
		 * 4. 1부터 200까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합
		 * 
		 * */
		
		int i = 0,sum = 0;
		while (i++ <= 100) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 100까지의 3의 배수의 총합 : " + sum);
		
		
		i = 200;
		while (i >= 1) {
			System.out.print(i-- + " ");
		}
		System.out.println();
		
		i = 299;
		while (i++ <= 500) {  //여기서 i++은 (i++ <= 500)에서 ")"를 만날때 숫자값이 올라감.그래서 i++해도 상관없음.
			if (i % 7 != 0) {
				continue;
			}
			System.out.println(i);  //여기서 i++하면 안됨.왜냐면 처음에 코드가 내려올때 위에 continue때문에 여기까지 도달을 못해서 
									//숫자값이 올라가지않음.
		}
		
		i = 0;
		sum = 0;
		while (i++ <= 200) {
			if (i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}
		}
		System.out.println("2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합 : " + sum);
		
		

	}

}














