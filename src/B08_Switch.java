
public class B08_Switch {

	public static void main(String[] args) {
		/*
		 * switch-case문
		 * 
		 * -()안에 연산 결과에 따라 실행할 코드를 결정한다
		 * -()안에 boolean타입은 들어갈 수 없다
		 * -if문으로 완벽하게 대체 가능하다
		 * -break를 안쓰면 break를 만날 때까지 내려가면서 모든 case를 실행한다
		 * -default는 if문에 else와 똑같은 역할을 한다
		 * 
		 * */

		int a = 10;
		
		switch(a % 2) {
		case 0:
			System.out.println("짝수"); break;
		case 1:
			System.out.println("홀수"); break;
			
		}
		
		char grade = 'A';
		
		switch (grade){
		case 'E': case 'e':
			System.out.println("전체 관람가입니다"); 
			break;
		case 'K' :case 'k':
			System.out.println("12세이상 관람가입니다");
			break;
		case 'Y' :case 'y':
			System.out.println("15세이상 관람가입니다");
			break;
		case 'A' :case 'a':
			System.out.println("청소년 관람불가입니다");
			break;
		default :
			System.out.println("상영제한 등급입니다");
			break;
		}
		
		int score = 100;
		
		switch(score / 10) {
		case 10: case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		}
		
	}

}












