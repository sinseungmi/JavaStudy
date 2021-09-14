import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C15_Throw {
	
	/*
	 * # throw
	 * 
	 * - 원하는 예외를 발생시킨다
	 * 
	 * # throws
	 * 
	 * - 해당 메서드에서 이러한 예외들을 발생시킨다는 것을 알린다
	 * - 해당 메서드를 호출하는 곳에 경고를 해줄 수 있다
	 * - 예외에 대한 처리를 호출하는 곳으로 미룬다
	 * 
	 * # Exception 클래스를 상속 받은 예외는 "반드시 처리해야하는 예외"가 된다
	 * 
	 * - Exception은 예외처리를 하지않으면 컴파일 에러를 발생 시킨다
	 * - 예외처리가 된 경우에만 컴파일을 허용한다
	 * 
	 * # RuntimeException 클래스를 상속 받은 예외는 반드시 처리하지 않아도 되는 예외가 된다
	 * - InpuMismathException,ArrayIndexOutOfBoundException.. 등
	 * - 예외처리를 하지 않아도 컴파일 에러는 발생하지 않는 예외들
	 * 
	 * */
	
	public static void main(String[] args) {
		C15_Throw c = new C15_Throw();
		
		try {
			c.dangerous_method();  //여기서 예외가 발생 했을 때 바로 chatch문으로 이동하기 때문에 아래 메서드는 가지 못하고 끝.
								   //대신 위에 예외가 발생하지 않을시 아래 메서드도 확인 가능
			c.dangerous_method2();   //스테틱에선 인스턴스에 접근할 수 없다는거 기억 좀..
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음");
		} catch(ArrayIndexOutOfBoundsException e)   {
			System.out.println("배열 터짐" + e.getMessage());
		}
		
		try {
			c.checkEven(20);
			c.checkOdd(10);
		} catch (NotEvenException e) {
			System.out.println("짝수 아님 익셉션 발생");
		} catch (NotOddException e) {
			System.out.println("홀수 아님 익셉션 발생");
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 정상 종료");
	}
	
	public void dangerous_method() throws FileNotFoundException{
		//파일의 내용을 읽어오기 위한 준비 과정 (꼭 처리해야 하는 예외 발생)
		File f = new File("D:\\name.txt");
		FileReader reader = new FileReader(f);

//		int[] arr = new int[5];
//		arr[5] = 10;
	}
	public void dangerous_method2() {
		throw new ArrayIndexOutOfBoundsException("그냥 만들었음");  //예외 내맘대로 발생하게 하기!
	}
	
	public void checkEven(int num) throws NotEvenException {
		if (num % 2 == 0) {
			System.out.println("짝수임");
		}else {
			throw new NotEvenException();
		}
		System.out.println("checkEven 메서드가 정상 종료");
	}
	
	public void checkOdd(int num){
		if (num % 2 == 1) {
			System.out.println("홀수임");
		}else {
			throw new NotOddException();   //얘가 상속 받은 애는 강제로 안던져도 됨
		}
		System.out.println("checkOdd 메서드가 정상 종료");
	}

}

//짝수가 아닐 때 발생시킬 예외 (예외 처리하지않으면 컴파일 불가)
class NotEvenException extends Exception{
	public NotEvenException() {
		super("짝수가 아니여서 발생하는 예외");
	}
}

//홀수가 아닐 때 발생시킬 예외 (예외 처리하지않아도 빨간줄이 뜨지 않는 예외)
class NotOddException extends RuntimeException{
	public NotOddException() {
		super("홀수가 아니여서 발생하는 예외");
	}
}















