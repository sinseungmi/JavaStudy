package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class A03_jdbcTransaction {
	
	static String sql = "UPDATE fruits SET fcolor ='GREEN' WHERE fname ='Kiwi'"; 
	//여기서 주의할점은 문장 끝에 ;는 들어가지 않는다
	
	public static void main(String[] args) {
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				
			){
			
			/*
			 * PreparedStatement의 특성상, 자동으로 commit이 이루어 지는데,
			 * 한 매서드 안에서 두개 이상의 sql문을 실행하고자 할 때,
			 * 하나라도 제대로 수행되지 않으면 rollback을 하고싶은 경우가 있을 수 있죠.
			 * 이러한 경우에, Connection객체에 setAutoCommit(false); 라는 메서드를 통해서
			 * 각각을 따로 commit/rollback 할 수 있게 설정을 할 수 있습니다.
			 *  
			 * */
			
			//JDBC로 처음 연결을 생성하면 기본적으로 AutoCommit이 활성화 되어있다
			//트랜젝션을 직접제어하기 위해서는 자동으로 커밋을 비활성화 해야한다
			conn.setAutoCommit(false);
			
			int rows = pstmt.executeUpdate();
			
			System.out.println(rows + "행이 업데이트 되었습니다.");
		
			if (rows % 2 ==0) {
				conn.commit();
				System.out.println("커밋 완료");
			}else {
				conn.rollback();
				System.out.println("롤백 완료");
			}
			
			System.out.println("업데이트하려다가 취소되었습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
