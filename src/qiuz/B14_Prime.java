package qiuz;

import java.util.Scanner;

public class B14_Prime {
	public static void main(String[] args) {
		/*
		 * 사용자로부터 숫자를 입력 받으면 1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해라
		 * 
		 * 소수 : 1과 자기 자신으로만 나누어 떨어지는 수 ex : 7,11,13,17...
		 * 
		 */

		System.out.print("소수 찾기 : ");
		int num = new Scanner(System.in).nextInt();
		
//		for (int check = 2; check <= num; ++check) {
//
//			int cnt = 0;
//			
//			//검사를 1과 자기자신을 제외하고 진행하면 cnt가 
//			//발생하자마자 소수가 아님을 알 수 있다     //Math.sqrt(check)했을 때 가운데 붕떠있는값이있는 건 소수,없을 땐 소수 아님.
//			for (int div = 2; div <= Math.sqrt(check); ++div) {
//				if (check % div == 0) {
//					System.out.printf("검사하는 숫자[%d]는 [%d]로 나누어떨어짐\n", check, div);
//					System.out.println("소수가 아닙니다");
//					cnt++;
//					break; //검사를 더 진행할 필요가 없다
//				}
//
//			}
////			System.out.printf("\t[%d]의 약수는 [%d]개입니다\n", check, cnt);
//			if (cnt == 0) {
//				System.out.printf("\t[%d]는 소수입니다\n",check);
//			}
//			System.out.println("-------------------------------");
//		}
		
		//  ↓ 이것도 보면 1은 10과 곱해지고 2는 5와 곱해짐
		// 10: 1, 2, 5, 10 = Math.sqrt(10)를 하는 이유는 10의 약수를 볼 때 앞에 두개만 보면 되는 것. 
		//     왜냐면 소수가 아닌 수들은 앞값들과 끝값들이 나누어지기 때문
		// 7: 1, 7 밖에 없음. 소수는 1과 자기 자신만 나눠지고 다른 수들은 나누어질 수 없기 때문
		

		for (int check = 2; check <= num; ++check) {
			
			int cnt = 0;
			
			//검사를 1과 자기자신을 제외하고 진행하면 cnt가 
			//발생하자마자 소수가 아님을 알 수 있다     //Math.sqrt(check)했을 때 가운데 붕떠있는값이있는 건 소수,없을 땐 소수 아님.
			for (int div = 2; div <= Math.sqrt(check); ++div) {
				if (check % div == 0) {
					System.out.printf("검사하는 숫자[%d]는 [%d]로 나누어떨어짐\n", check, div);
					System.out.println("소수가 아닙니다");
					cnt++;
					break; //검사를 더 진행할 필요가 없다
				}
				
			}
//			System.out.printf("\t[%d]의 약수는 [%d]개입니다\n", check, cnt);
			if (cnt == 0) {
				System.out.printf("\t[%d]는 소수입니다\n",check);
			}
			System.out.println("-------------------------------");
		}
		System.out.println((int)Math.sqrt(10));
	}
}
