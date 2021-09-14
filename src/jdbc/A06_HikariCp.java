package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class A06_HikariCp {
	
	public static void main(String[] args) {
		
	//slf4j - 로그를 찍는 용도로 사용하는 인기 라이브러리
	HikariConfig config = new HikariConfig();
	config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
	config.setUsername("hr");
	config.setPassword("1234");
	config.addDataSourceProperty("cachePrepStmts", "true");
	config.addDataSourceProperty("prepStmtCacheSize", "250");
	config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

	HikariDataSource ds = new HikariDataSource(config);

	String sql = "select * from employees";
	try (
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			){
		while (rs.next()) {
			System.out.println(rs.getNString(2));
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	}
}











