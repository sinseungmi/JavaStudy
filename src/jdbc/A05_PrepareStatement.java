package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A05_PrepareStatement {
	
	public static void main(String[] args) {
		//사용자로부터 2개의 값을 입력 받아 insert한다고 가정
		String fname = "Kiwi";
		String fcolor = "Purple";
		
		//보안 취약점(SQL Injection)
		//String sql = "insert into fruits values(fruit_seq.nextval," + fname + "," + fcolor + ")";
		
		//preparestatement에 준비시킬 쿼리문에 변수가 필요하다면 변수자리는 ?로 채운다
		String sql = "insert into fruits values(fruit_seq.nextval,?,?)";
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
				//다음과 같이 ?를 채울 수 있다
				pstmt.setString(1, fname);
				pstmt.setString(2, fcolor);
				
				//실행
				pstmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
