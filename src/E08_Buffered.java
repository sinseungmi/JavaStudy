import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class E08_Buffered {
	
	//fankentein.txt를 한글자씩 모두 모두 읽고 걸린 시간을 측정해보세요
	
	
	//오토클로즈어블이란? 알아보기
	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("./data/text/frankenstein.txt");
				InputStreamReader inreader = new InputStreamReader(fin);){
			
//			int _byte;
//			long start = System.currentTimeMillis();
//			while((_byte = inreader.read()) != -1) {
//				System.out.print((char)_byte);
//			}
//			long end = System.currentTimeMillis();
//			
//			long result = end - start;
//			
//			System.out.println("\n 걸린 시간 : " + result + " 밀리미초");
			
//			int len = -1;
//			StringBuilder sb = new StringBuilder();
//			char[] buffer = new char[2048];   //배열을 buffer라고 해야한다
//			long start = System.currentTimeMillis();
//			while((len = (inreader.read(buffer))) != -1) {
//				sb.append(new String(buffer, 0, len));
//			}
//			long end = System.currentTimeMillis();
//			
//			long result = end - start;
//			
//			System.out.println("\n 걸린 시간 : " + result + " 밀리미초");
			
			long start = System.currentTimeMillis();
			BufferedReader bin = new BufferedReader(inreader, 2048);
			//자바의 정석 p.650 참고
			
			StringBuilder sb = new StringBuilder();
			
			String line = null;
			while((line = bin.readLine()) != null) {
				sb.append(line);
			}
			long end = System.currentTimeMillis();
			
			System.out.println("걸린 시간 : " + (end - start) + "ms");
			
			inreader.close();
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (   BufferedWriter bout = new BufferedWriter(
				new OutputStreamWriter(
				new FileOutputStream("./data/text/abc.txt")))){
			
			bout.append("Hello, BufferedWriter!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
