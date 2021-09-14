import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01_JavaIO {
	public static void main(String[] args) {
		/*
		 * Java IO (input/output)
		 * 
		 * - 자바는 스트림이라는 개념을 이용해 입출력을 다룬다
		 * - 프로그램으로 들어오는 모든 데이트들을 입력이라고 부른다(input)
		 * - 프로그램이 연산해서 내보내는 모든 데이터들을 출력이라고 부른다(output)
		 * 
		 * Stream
		 * - 데이터들이 오고가는 통로
		 * - 입력 받을 때 데이터들이 프로그램으로 들어오는 통로를 inputstram이라고 한다
		 * - 출력할 때 데이터들이 나가는 통로를 outputstream이라고 부른다
		 * - 데이터가 stream으로 이동하기위해서는 해당 데이터를  byte타입으로 변환해야한다
		 * 
		 * 
		 * 
		 * */
		
		FileOutputStream fout = null;
		
		/*
		 * # 절대 경로와 상대 경로
		 * 
		 * - 원하는 자원까지의 경로를 뿌리부터(root)부터 모두 적는 것을 절대경로라고 한다
		 *  C:\,D:\,E:\,http://,ftp://,file://,/(루트)
		 * 
		 * 	* 절대경로 예
		 * 	- D:\Pictures\animals\penguin.jpg
		 * 
		 * - 원하는 자원까지의 경로를 현재 위치부터 찾아가는 것을 상대경로라고한다
		 *   상대경로는 ./ 또는 ../로 시작한다(./는 생략이 가능하다)
		 *   
		 *   ./ : 현재 위치부터 시작
		 *   ../ : 상위 폴더
		 * 
		 * 	* 상대경로 예
		 * 	- ./../../penguin.jpg
		 * 	- ./../images/penguin.jpg
		 * 
		 * 
		 * */
		
		try {                                //폴더까지는 내가 윈도우로 생성해주고 파일은 이클립스에서 생성해줌.              
			//fout = new FileOutputStream("D:\\files\\a.txt",true);
			
			//소스에서 현재 위치(./)는 프로젝트의 root이다
			fout = new FileOutputStream("./a.txt",true);
			
			for(int i = 0; i < 10; i++)  //출력처가 sysout에서 파일로  바뀐 것(콘솔대신 파일로 쓴다 생각)
				fout.write(String.format("오늘은 날씨가 참 좋네요%d\n", i).getBytes());
			// * I/O Stream은 수동으로 close()를 호출해줘야한다(메모리회수)
			// fout.close();
		
			System.out.println("파일 쓰기 완료");
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음 익셉션");
		} catch (IOException e) {  //catch 두번째에 추가할라면 add catch어쩌구 누르면됨(두번째 꺼)
			System.out.println("데이터를 쓰다가 문제가 생겼음");
		} finally {
			try {                 //열고 쓰고 수동으로 닫고. (IOStream - 언제 닫아야할지 몰라해서 항상 
				                  //열려있으므로 내가 직접 닫아줘야함)
				if (fout != null) fout.close(); //.close()는 웬만하면 에러날일이 없음
			} catch (IOException e) {}
		}
		
		
	}

}








