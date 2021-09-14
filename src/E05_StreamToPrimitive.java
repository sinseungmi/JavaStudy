import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class E05_StreamToPrimitive {
	
	/*
	 * # DataInputStream/DataOutputStream
	 * 
	 * - Reader/Writer는 Stream을 문자로 손쉽게 다루기 위한 클래스였다면
	 *   DataInputStream/ DataOutputStream은 기본형 타입으로 손쉽게 다루기 위한 클래스다
	 * 
	 * */
	
	public static void main(String[] args) {
		
		File file = new File("myData.data");
		
		try {
			FileOutputStream fout = new FileOutputStream(file);
			DataOutputStream dout = new DataOutputStream(fout); //바이트를 기본형으로 손쉽게~
			
			dout.writeInt(9900);
			dout.writeInt(3000);
			dout.writeInt(850);
			dout.writeFloat(123.123F);
			dout.writeDouble(12345.123456778);
			dout.writeUTF("UTF타입으로 쓰기");
			dout.writeBoolean(false);
			
			//메모장으로 열때 깨져 보이는 이유는 메모장은 문자로 해석하려고 하기 때문이다.(난 숫자를 저장했는데 그걸 문자로 읽을라해서)
			//사용한 스트림은 가장 최근에 만든 것 부터 차례대로 닫아줘야 한다.
			//java15 기준으로는 dout만 닫아도 fout이 함께 닫힌다. 하지만 나는 1.8버전이므로 둘다 닫아야한다.
			dout.close();
			
			OutputStreamWriter writer = 
					new OutputStreamWriter(fout, Charset.forName("UTF-8"));
			
			writer.append("안녕하세요");
			writer.flush();
			
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileInputStream fin;
		DataInputStream din;
		try {
			fin = new FileInputStream(file);
			din = new DataInputStream(fin);
			
			//writeInt로 썼던 것은 readInt로 읽어야 한다
			//파일에 썼던 순서대로 읽으면 데이터를 다시 가져올 수 있다.
			System.out.println("아까 저장했던 첫번째 int : " + din.readInt());
			System.out.println("아까 저장했던 두번째 int : " + din.readInt());
			System.out.println("아까 저장했던 세번째 int : " + din.readInt());
			System.out.println("float : " + din.readFloat());
			System.out.println("double : " + din.readDouble());
			System.out.println("UTF : " + din.readUTF());
			System.out.println("boolean : " + din.readBoolean());
			
			din.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}









