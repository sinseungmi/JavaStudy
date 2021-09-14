package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jdbc.model.Employee;

public class A04_DESC {
	
	public static void main(String[] args) {
		
		String sql = "select * from employees";
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
				){
			//가져온 데이터의 메타 데이터들을 보고 싶을 때
			//메타 데이터란 저장된 데이터 자체가 아니라, 해당 데이터에 대한 정보를 갖는 데이터를 의미한다.
			//예를 들어 데이터베이스의 소유권 또는 데이터의 크기에 관련된 정보등이 있다면,이러한 것을 메타 데이터라한다
			ResultSetMetaData meta = rs.getMetaData();
			
			System.out.println("컬럼이 몇개?" + meta.getColumnCount() + "개");
			
			for(int i = 1, len = meta.getColumnCount(); i <= len; i++) {
				System.out.println("---------------------------------");
				System.out.println(i + "번째 컬럼의 이름은?" + meta.getColumnLabel(i));
				System.out.println(i + "번째 컬럼의 타입은?" + meta.getColumnTypeName(i));
				System.out.println(i + "번째 컬럼의 컬럼 크기는?" + meta.getPrecision(i));
			}
			
			//class<?>는 메타데이터!!
			//클래스의 정보 얻기
			// <?> : 어떤 종류의 클래스든 다 얻어올 수 있다는 의미
			Class<?> employee = Class.forName("jdbc.model.Employee");
			
			for (java.lang.reflect.Method method : employee.getMethods()) {
				System.out.println("method : "+method);
				System.out.println("methodReturnTyp : "+method.getReturnType());
			}
			
			
			int employee_id;
			int salary;
			
			while (rs.next()) {
				//Employee e = new Employee(rs);
				
				//e.setEmployee_id(rs.getInt("employee_id"));
				
				java.util.Date d = rs.getDate("hire_date"); //sql.date로 가져온 hire_date를 util.date로 업캐스팅 가능.
				                                           //sql.date타입으로 받기보다 util로 받는게 자바에서 쓸 때 더 유용하지 않나 싶음
				
				//System.out.println(e.getFirst_name());
				//System.out.println(""+e.getLast_name());
				
//				employee_id = rs.getInt(1);
//				salary = rs.getInt("salary");
				
//				for(int i = 1, len = meta.getColumnCount(); i <= len; i++) {
//					switch(meta.getColumnTypeName(i)) {
//						case "NUMBER":
//							break;
//						case "VARCHAR2":
//							break;
//						default:
//							break;
//					}
//				}
			}

		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}









