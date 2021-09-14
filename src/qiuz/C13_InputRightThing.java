package qiuz;

import java.util.InputMismatchException;
import java.util.Scanner;

import myobj.MyScanner;

public class C13_InputRightThing {

	/*
	 * 사용자로부터 숫자를 제대로 입력 받을 때 까지 계속 입력 받는 프로그램을 만들어보세요 
	 * (잘못된 값이 입력되어도 강제종료 되지않고, 올바른 값이 입력되면 출력 후 프로그램 종료)
	 */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int a = MyScanner.inputInt("숫자 > ");
		int b = inputInt("숫자 > ");
		
		System.out.println("input함수로 입력 받은 값: " + a);
		System.out.println("프로그램이 종료 됨");

//		Scanner sc = new Scanner(System.in);
//		int input;
//		System.out.print("숫자를 입력하세요  : ");
//
//		while (true) {
//			try {
//				input = sc.nextInt();     //여기서 잘못된 값을 넣었을 때 그 값은 계속 남아있어서 무한 루프.
										  //남아있는 값을 빼줘야함
//				break;
//
//			} catch (Exception e) {
//				System.out.print("다시 입력하세요\n");
//				String stuck = sc.nextLine();   //쓰레기 값을 비워주는 nextLine()
//				System.out.println("걸려있던걸 뺌 : " + stuck);
//			}
//		}
//		System.out.println("입력한 값: " + input);
//		System.out.println("프로그램 종료");
	}
	
	public static int inputInt(String message) {
		int num;
		
		while(true) {
			try {
				System.out.println(message);
				num = sc.nextInt(); 
				break;
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		}
		
		//sc.close(); //더 이상 쓰지 않을 스캐너 삭제 (System.in은 close를 하지않는 것이 좋음.운영체제 콘솔과 유일한 연결통인데
		              //닫으면 다시 연결하기 힘들어서 )
		
		return num;
	}

}














