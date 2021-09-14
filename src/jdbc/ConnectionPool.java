package jdbc;

import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;

public class ConnectionPool {
	
	/*
	 * DB에 DML을 적용할 때마다 새로운 접속을 생성하는 것은 리소스가 많이 낭비된다
	 * 
	 * 그래서 연결을 이미 여러개 생성해두고, 사용중이지 않은 커넥션을 꺼내주는 방식을
	 * 커넥션 풀이라고 한다.
	 * 
	 * 웹 컨테이너(WAS)가 실행되면서 DB와 미리 connection(연결)을 해놓은 객체들을 pool에 저장해두었다가
	 * 클라이언트 요청이 오면 connection을 빌려주고, 처리가 끝나면 
	 * 다시 connection을 반납받아 pool에 저장하는 방식을 말합니다.
	 * 
	 * 
	 * */
	List<JdbcConnection> pool;
	
	public ConnectionPool(int size) {
		pool = new ArrayList<>(size);
		
		for (int i = 0; i < size; ++i) {
			pool.add(new JdbcConnection());
		}
	}
	
	public JdbcConnection getConnection() {
		for (JdbcConnection jconn : pool) {
			if(!jconn.using()) {
				return jconn;
			}
		}
		return null;
	}
	


}
























