package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A02_CRUD {

	public static void main(String[] args) {
		/*
		 * JDBC에서 SELECT는 ResultSet을 반환한다
		 * 그 외의 DML(INSERT, UPDATE, DELETE)은 적용된 행의 개수를 반환한다
		 * 
		 * SELECT는 PreparedStatement의 executeQUery() 메서드를 사용하고
		 * 나머지는 executeUpdate()메서드를 사용한다
		 * 
		 * # executeUpdate()
		 * 1. 수행결과로 Int 타입의 값을 반환합니다.
		 * 2. SELECT 구문을 제외한 다른 구문을 수행할 때 사용되는 함수입니다.
		 * 
		 * executeUpdate 함수를 사용하는 방법입니다.
		 *  -> INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
		 *  -> CREATE / DROP 관련 구문에서는 -1 을 반환합니다.
		 *  
		 * */
		
		//자바에서 넣는 데이터는 디비에서 롤백이 안된다. 할라면 자바에서 롤백해야함
		String sql = "INSERT INTO fruits(fid, fname, fcolor) "
				+ "VALUES(fruit_seq.nextval,'Kiwi','ORANGE')";
		String sql2 = "SELECT * FROM fruits";
		
		try {
			
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			
			for (int i = 0; i < 10; i++) {
				//insert, update, delete
				int rows = pstmt.executeUpdate();
				System.out.println(rows + "row(s) update");
			
			}
			//select
			ResultSet rs = pstmt2.executeQuery();
			
			while (rs.next()) {
				System.out.printf("%d\t%s\t%s\n",
						rs.getInt(1), rs.getNString(2), rs.getNString(3));
			}
			
			System.out.println("성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
