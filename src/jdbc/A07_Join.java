package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;

import javax.swing.text.View;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jdbc.model.Department;
import jdbc.model.Employee;
import jdbc.model.View1;

public class A07_Join {
	
	public static void main(String[] args) {
		
		//이름에 en이 들어가는 모든 사원의 이름/고용일/부서번호/부서명/도시를 
		//모델 클래스를 이용해 저장한 후 출력해보세요
		
		HikariConfig config = new HikariConfig("./db.properties");
		HikariDataSource ds = new HikariDataSource(config);
		String keyword = "en";
		String sql = "SELECT first_name,hire_date,department_id,department_name,"
				+ "city FROM DEPARTMENTS INNER JOIN EMPLOYEES USING(department_id) "
				+ "INNER JOIN locations USING(location_id) WHERE first_name LIKE '%'||?||'%'";
		
		try (	
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			pstmt.setString(1,keyword);
			//pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			//pstmt.setDate(3, new java.sql.Date(LocalDateTime.now().toEpochSecond(ZoneOffset.of("Asia/Seoul"))));
			
			ResultSet rs = pstmt.executeQuery();

			
			while (rs.next()) {
									
				View1 view = new View1(rs.getString("first_name"),
						rs.getDate("hire_date"),  //java.sql.Date to java.util.Date
						rs.getInt("department_id"),
						rs.getString("department_name"), 
						rs.getString("city"));
				
				//Date to Instant
				Instant instant = Instant.ofEpochMilli(view.getHire_date().getTime());
				
				//instant to LocalDateTime
				System.out.println(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
				
				System.out.println(view);
				
			}
		
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}










