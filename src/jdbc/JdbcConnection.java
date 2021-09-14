package jdbc;

import java.sql.Connection;

public class JdbcConnection implements AutoCloseable{

	private Connection conn;
	private boolean using;
	
	public JdbcConnection() {
		conn = DBConnector.getConnection();
	}
	
	public boolean using() { 
		return using;     //사용 중이 아닐 때 가져다 쓰겠다
	}
	
	public Connection use() {
		using = true;
		return conn;
	}
	
	@Override
	public void close() throws Exception {
		using = false;
		
	}
}
