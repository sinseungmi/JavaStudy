package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class A01_JdbcConnection {
	
	/*
	 * # JDBC
	 * - Java database Connectivity
	 * - DB에 쿼리문을 전달하여 실행하고 결과를 받아오는 java API(자바에서 미리 만든 어쩌구)
	 * - 어떤 DB와도 호환할 수 있도록 설계되어 있다
	 * - Java 부분의 소소는 어떤 DB를 사용하더라도 항상 일정하다
	 * - DB를 제작한 쪽에서 jdbc에서 요구하는 형식을 맞추어 개발하기 때문에
	 * 	프로그래머들은 새로운 DB도 기존의 jdbc로 편리하게 사용할 수 있다
	 * 
	 * 
	 * # OJDBC
	 * - 오라클 데이터 베이스가 java API와 소통하기 위해 만든 라이브러리
	 * - 오라클 DB가 설치된 폴더에 포함되어 있다
	 *
	 * 
	 * */
	
	public static void main(String[] args) {
		/*
		 * # 어떤 회사 DB를 사용하더라도 거쳐야하는 똑같은 절차들
		 * */
		/*
		 * 동적 로딩이란 : 어떠한 클래스가 로딩 될지 모르기 때문에 Class 클래스의 
		 * forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것입니다.
		 * 
		 * 
		 * - DriverManager.getConnection()은 실제 자바프로그램과 데이터베이스를 네트워크상에서 연결을 해주는 메소드이다. 
		 * 	연결에 성공하면 DB와 연결 상태를 Connection 객체로 표현하여 반환한다. 
		 * 	Connection은  네트워크상의 연결 자체를 의미한다. 자바프로그램과 DB사이의 길로 볼 수 있다. 
		 * 	보통 Connection하나당 트랜잭션 하나를 관리한다. 
		 * - Connection은 자바 언어로 워크시트 하나를 작성하는 거와 같다
		 * 
		 * */
		
		try {
			//1.Class.forName(driverName)으로 해당 DB사의 jdbc드라이버를 로드한다 (생략가능)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OraleDriver가 존재함");
			
			Class.forName("jdbc.A01_JdbcConnection");
			System.out.println("방금만든 클래스 존재함");
			
			//2.DriverManager 클래스를 통해 DB와의 연결을 생성한다    //OJDBC에서 찾을 수 있는 주소
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
			System.out.println("연결 생성됨");
			
			//3. 생성된 연결을 통해 전송할 쿼리문을 생성한다
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
			
			//4. 생성된 쿼리문을 DB로 보낸다
			/*
			 * # executeQuery()
			 * 1. 수행결과로 ResultSet 객체의 값을 반환합니다.
			 * 2. SELECT 구문을 수행할 때 사용되는 함수입니다.
			 * 
			 * */
			ResultSet rs = pstmt.executeQuery();
			
			//5. 받아온 결과를 마음대로 사용한다
			while (rs.next()) {  
				// next(): 아래 방향으로 한 행씩 이동. 더이상 행이 존재하지 않을 때(After the last row)는 false. 
				System.out.println(rs.getString("first_name") + "/" + rs.getNString("salary"));
										//컬럼명 지정 방법		
			//6. 다 썼으면 연결을 잘 끊어준다(가장 나중에 열었던 순서대로 닫는다)
			rs.close();
			pstmt.close();
			conn.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}











