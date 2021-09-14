import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E03_FileIO {
	
	/*
	 * (컴퓨터 기준으로 생각하기)
	 * # Stream
	 * - 데이터들이 오가는 통로, 데이터를 운반하는 연결 통로
	 * - 프로그램으로 들어올 때 사용하는 통로를 InputSteam이라고한다
	 * - 프로그램에서 처리된 후 나갈 때 사용하는 통로를 OutputStream이라고 한다
	 * 
	 * # InputStream                               //(end of file)
	 * 	- read() : 스트림으로 부터 다음의 한 바이트를 읽어온다. EOF에 도달하면 -1을 반환
	 *  - read(byte[]) : byte[]을 만들어서 전달하면 거기에 담아준다
	 *  - read(byte[], off, len) : byte[]을 만들어서 전달하되
	 * 							원하는 만큼 원하는 위치에 읽는다
	 * 				: 최대 len개의 byte를 읽어서, 배열 byte의 지정된 위치(off)부터 저장한다.
	 * 				  실제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다.
	 * - close(): 다 사용한 스트림을 닫는다. 닫지 않으면 계속 메모리를 차지한다.
	 * 
	 * # OutputStream의 공통 메서드
	 *  - write(int) : 한글자씩 쓴다 
	 *  - write(byte[]) : byte[]에 담긴 내용을 한번에 쓴다
	 *  				: 주어진 배열 byte에 저장된 모든 내용을 출력소스에 쓴다.
	 *  - flush(): write로 모아 놓은 내용들을 모두 내보낸다.(한글자씩 파일을 왔다갔다하는 것은 비효율적이기에 한번에 모아서 보낸다)
	 *  	     : flush()는 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다. 
	 *  		 : flush()를 호출하지 않는다면 내용이 버퍼에만 남고 파일에는 쓰이지 않는 상황이 나올 수 있습니다.
	 *  - close(): 다 사용한 스트림을 닫는다. 닫지 않으면 계속 메모리를 차지한다.
	 * 			     남은 데이터가 있다면 flush()를 한다.
	 * 
	 * # 버퍼
	 * - 버퍼는 기본적으로 입출력 전송 속도차이에 대한 성능을 보완하기 위해 사용합니다. 
	 * 	입력속도에 비해 출력속도가 느린경우 데이터를 임시 저장하는 공간을 말하며, 임시저장장치라고도 합니다.
	 * 
	 * */
	public static void main(String[] args) {
		
		File git = new File("./note/01_Git.txt");
		
		System.out.println(git.exists());
		System.out.println(git.isDirectory());
		System.out.println(git.isFile());
		
		try {   
			FileInputStream fin = new FileInputStream(git);  //얘 입장에선 git의 내용이 프로그램으로 들어오는 거임
			     //여기서도 read()를 해서 띄엄띄엄 읽는 중이다.         //그래서 InputStream.
			
			byte[] buffer = new byte[100];
			
			// 원하는 바이트 크기만큼씩 읽기
			int len;         //buffer크기 만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환.
			while((len = fin.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, len));
			}
			
			//안녕하세요 반갑습니다!!
			
			//ex)3칸씩 읽을 수 있음
			
			//안녕하
			//세요
			//반갑습
			//니다!
			//!다!(이거는 공간이 남았을 때 마지막부분이 또 나온다)
			
			fin.read(buffer);
			
			System.out.println("Arrays.toString(buffer) : " + Arrays.toString(buffer));
														   //이건 바이트가 출력됨
			System.out.println("new String(buffer) : " + new String(buffer));
	 											   //String 생성자에  전달해야지 바이트가 문자열로 출력됨
			
			//문제 : 두번 읽는 거 고쳐 
			
			int by; 
			while((by = fin.read()) != -1) {
				System.out.print((char)by);
				
			}
			
			// 1 바이트씩 읽기
//			int _byte;
//			while((_byte = fin.read()) != -1) {
//				System.out.print((char)_byte);
//			}
			
			fin.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File newFile = new File("./note/my first file output.txt");
		try {
			FileOutputStream fout = new FileOutputStream(newFile); //얘는 데이터들이 나가서 출력되는 거.그래서 output.
			
			//1.int를 사용하는 방식
			fout.write(65);
			fout.write(66);
			fout.write(67);
			fout.write(68);
			fout.write(69);
			fout.write('\n');
			
			//2.byte[]를 이용하는 방식
			fout.write("안녕하세요\n".getBytes());
		
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}







































