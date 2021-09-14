package jdbc.model;

import java.util.Date;

public class View1 extends Employee{
	
	public View1(String first_name,Date hire_date, int department_id,
			String department_name, String city) {
		
		setFirst_name(first_name);
		setHire_date(hire_date);
		setDepartment(new Department());
		getDepartment().setDepartment_id(department_id);
		getDepartment().setDepartment_name(department_name);
		getDepartment().setLocation(new Location());
		getDepartment().getLocation().setCity(city);
		
	}
	
	@Override
	public String toString() {
		
		return String.format("%-10s%-10s%-10d%-10s%-10s", getFirst_name(),getHire_date(),getDepartment().getDepartment_id(),
				getDepartment().getDepartment_id(),getDepartment().getLocation().getCity());
	}

}
