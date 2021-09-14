import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C13_Exception {
	
	/*
	 * 예외(Exception)
	 * 
	 * - 우리가 에러라고 알고 있던 빨간 글씨들을 사실 예외라고 부른다
	 * - 프로그래머가 발생 가능한 예외를 미리 예상하고 대비해두는 것을 
	 * 	예외처리라고 한다
	 * - 자바의 문법을 틀리는 것은 예외가 아니라 컴파일 에러라고 부른다(오타 등)
	 * - 프로그래머가 예외에 대하여 적절한 조치를 취해준다면 프로그램을 강제
	 * 	종료하지않고 계속해서 진행할 수 있다
	 * - 메서드에 마우스를 올려보면 어떤 예외가 어떤 상황에 발생하는지에 대한 
	 * 	설명이 Throws에 적혀있다
	 * 
	 * 예외처리
	 * 
	 * - 예외가 발생할 가능성이 있는 코드를 try문 내부에 포함시킨다
	 * - try문 내부에 있는 코드는 예외가 발생하지않으면 모두 정상 실행된다
	 * - try문 내부에서 예외가 발생하는 경우 실행이 즉시 중단 되고
	 * 	해당 예외를 담당하는 catch문으로 이동하게 된다
	 * - catch문에는 발생한 예외에 대한 정보를 담고 있는 인스턴스가 도착하게 된다
	 * -catch문은 여러개 중첩해서 사용 가능(다양한 예외 처리를 한번에)
	 * - 예외가 발생하든 안하든 실행하고 싶은 코드는 finally에 작성한다
	 * 
	 * 
	 * */
	
	/*
	 * 강제적으로 JVM을 종료시키고 싶을 때는 System 클래스의 exit() 메소드를 호출하면 됩니다. 
	 * exit() 메소드는 현재 실행하고 있는 프로세스를 강제 종료시키는 역할을 합니다. 
	 * exit() 메소드는 int 매개값을 지정하도록 되어 있습니다. 이 값을 종료 상태값이라고
	 * 합니다. 일반적으로 정상 종료일 경우 0으로 지정하고 비정상 종료일 경우 0이외의 다른값을 줍니다.
	 * 
	 */
	
	public static void main(String[] args) {
		
		int a;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반드시 숫자만 적어 ");
		try {
			a = sc.nextInt();  //클래스  //변수명
		} catch (InputMismatchException e) {  //여기에서 예외 발생 인스턴스 도착
//			e.printStackTrace();  //에러에 대한 정보를 출력
//			System.exit(-1);  	  //강제 종료
//			 
//			System.out.println("getMessage: " + e.getMessage());
			a = -1;
			System.out.println("이상한걸 입력햇다");
			return;
		
		} catch (IllegalStateException e) {
			System.out.println("스캐너가 닫혀잇다");
			a = -1;
		} catch (NoSuchElementException e) {
			System.out.println("스캐너에 읽을 내용 없음");
			a = -1;
		} finally {
			System.out.println("나는 꼭 실행할 거야");
		}
		
		System.out.println("입력한 숫자는 " + a);
		System.out.println("프로그램이 정상적으로 종료됨");
	}
	
	
}

























