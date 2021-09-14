package jdbc.quiz;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jdbc.DBConnector;

public class A06_FileBasedHikariCP {
	
	//메뉴얼의 File based 방식으로 HikariCP 구동해보기
	
	public static void main(String[] args) {
		HikariConfig config = new HikariConfig("./db.properties"); //DB정보를 주입.빈 등록
		HikariDataSource ds = new HikariDataSource(config);  //db정보를 담아주는 DataSource
									//log는 기록
		config.addDataSourceProperty("logWriter", new PrintWriter(System.out));
		config.setConnectionTestQuery("select 1 from dual");
		
		String sql = "select * from employees";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				
				){
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}













