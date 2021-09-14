package qiuz;

public class B14_Gugudan {

	public static void main(String[] args) {
		/*
		 * 1. 구구단을 다음과 같이 가로로 출력해보세요
		 * 
		 * 2단: 2x1=2 2x2=4 ...
		 * 3단: 3x1=3 3x2=6 ...
		 * 
		 * 
		 * 2. 구구단을 다음과 같이 세로로 출력해보세요
		 * 
		 * 2단	3단	4단
		 * 2x1=2 3x1=3 .....
		 * 2x2=4 3x2=6 .....
		 * 
		 * */
		
		
		for (int i = 2; i <= 9; i++) {
			System.out.print(i + "단:");
			for (int j = 1; j <= 9 ; j++) {
				System.out.printf("%dx%d=%-2d ",i,j,i*j);
			}
			System.out.println();
		}
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				if (i == 0) {
					System.out.print(j + "단\t");
				}else {
					System.out.printf("%dx%d=%-2d\t",j,i,j*i);	
				}
			}
			System.out.println();
		}
	
//		for (int dan = 2; dan <= 9; ++dan) {
//			System.out.printf("%d단: ",dan);
//			for (int gop = 1; gop <= 9; ++gop) {
//				System.out.printf("%dx%d=%-2d ",dan, gop, dan * gop);
//			}
//			System.out.println();
//		}
//		for (int i = 0; i <= 9; i++) {   //몇줄 출력할건지 결정
//			for (int j = 2; j <= 9; j++) {
//				if (i == 0) {
//					System.out.print(j + "단\t");
//				}else {
//					System.out.printf("%dx%d=%d\t",j, i, j * i );	
//				}
//			}
//			System.out.println();
//				
//		}

	}

}
