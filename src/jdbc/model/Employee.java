package jdbc.model;  //로직이 다빠진 모델이 가장 최적

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	//객체지향에서는 클래스에 딸려있는 속성을 직접.찍고 제어하는 것을
	//좋아하지 않는다. 밖에서 건들면 기능이 한순간에 망가질 수 있기 때문에 private을 붙여야한다(감추고싶어서)
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private Employee manager;
	//private int department_id;  //조인없이할 때
	private Department department;  //조인이 일어나는 경우가 많을 때
	
	//Class<?> class_info = this.getClass();
	
//	public Employee(ResultSet rs) {
//		//현재 클래스의 정보와 rs의 메타데이터를 참조하여 존재하는 필드만 채우는 코드
//	}

	public int getEmployee_id() {
		return employee_id; //get만 있을 경우,임플로이 아이디를 가져갈 순 있지만 셋팅은 안된다는 의사표시
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

}









