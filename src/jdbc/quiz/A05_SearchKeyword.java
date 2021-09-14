package jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.DBConnector;

public class A05_SearchKeyword {
	
	/*
	 * first_name에 사용자가 입력한 내용이 포함되어있는 모든 사원을 조회해보세요
	 * (단, 검색어는 두 글자 이상이어야 하고 두 글자 이상이 아니라면 예외가 발생해야 함)
	 * */
	
	public static void main(String[] args) throws StringLengException {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름입력 : ");
		String str = sc.next();
		String keyword = "%" + str + "%";
		String sql = "select * from employees where first_name like ?";  //?에는 아무 수식도 넣으면 안됨
		// 오라클의 문자열 연결 연산자 ||
		//String sql = "select * from book where bookname like '%' || ? || '%'";

		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			if(str.length() >= 2) { 
				pstmt.setString(1, String.format("%%%s%%",str));  //setString : ''을 자동으로 붙여준다
				ResultSet rs = pstmt.executeQuery();          //%를 %%붙이는 이유는 \\(경로)와 같은 맥락
				
				while (rs.next()) {                       
					System.out.printf("%-10d%-15s%-15s%-10d\n",
							rs.getInt("employee_id"), 
							rs.getString("first_name"), 
							rs.getNString("last_name"),
							rs.getInt("salary"));
				}
				rs.close();
			}else {
				throw new StringLengException();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
	class StringLengException extends Exception{
		public StringLengException() {
			super("2글자 이하임");
		}
	}
	


