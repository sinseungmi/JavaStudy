package jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class A01_ConnectionPractice {
	
	/*
	 * 사용자로부터 부서번호를 입력받으면 해당부서 사원들의 모든 정보를 조회하여 콘솔에 보기 좋게 출력해보세요
	 * */
	
	//static 블록 - 해당 클래스가 한번이라도 언급되면 static 블록을 최초로 한번 실행한다(제일 먼저 실행됨)
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	static String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	
	static Connection getConnection(String id, String password) {
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public static void main(String[] args) {
		String sql = "SELECT * FROM employees WHERE department_id="+50;
		
		try (
			Connection conn = getConnection("hr", "1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
				
			){
			System.out.println("EMPNO\t   FORST_NAME\tLAST_NAME");
			while (rs.next()) {                       //컬럼 인덱스 방법
				System.out.printf("%-10d%-13s\t%s\n",rs.getInt(1), rs.getString(4), rs.getNString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사원 부서를 입력하세요 : ");
		int department = sc.nextInt();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				try {
					if(rs.getString("department_id").equals(Integer.toString(department))) {
						System.out.println(
								rs.getString("employee_id") + rs.getString("first_name") +
								rs.getString("last_name") + rs.getString("email") +
								rs.getString("phone_number") + rs.getString("HIRE_DATE") +
								rs.getString("JOB_ID") + rs.getString("SALARY") +
								rs.getString("COMMISSION_PCT") + rs.getString("MANAGER_ID") +
								rs.getString("DEPARTMENT_ID"));
					}
				} catch (NullPointerException e) {
					//부서번호 중에 null도 있어서 예외처린
				}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	*/

}
