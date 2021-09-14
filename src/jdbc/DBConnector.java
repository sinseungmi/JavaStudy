package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
	
	//코드에 들어있는 아이디,비번은 위험해서 취약점이라한다. 코드에 있는건 바람직하지않다
	
	//파일에 있는 내용을 읽어서 DB와의 연결을 생성해보세요
	static String driverName;
	static String url;
	static String id;
	static String password;
	
	static {
		
		File file = new File("D:/개인정보.txt");
		
		try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
	
				){
			
			ArrayList<String> array = new ArrayList<String>();
			
			String line = null;
			while ((line = br.readLine()) != null) {
				array.add((line));
			}
		
			for(int i = 0; i < array.size(); i++) {
				String str = array.get(i);
				if(str.contains("OracleDriver")){
					driverName = array.get(i).trim();
				}else if (str.contains("XEPDB1")) {
					url = array.get(i).trim();
				}else if (str.contains("id=")) {
					id = array.get(i).replace("id=", "").trim();
				}else {
					password = array.get(i).trim();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try (BufferedReader in = new BufferedReader(new FileReader(file));) {
//			url = in.readLine();
//			id = in.readLine();
//			password = in.readLine();
//			
//			System.out.println("[Info]Initilize static variables");
//			
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//	
	}
	
//	static {
//		try {
//			Class.forName(driverName);
//			System.out.println("드라이버 로드 완료");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, id, password);
		}catch (SQLException e) {
			return null;
		}
	}
	

}
