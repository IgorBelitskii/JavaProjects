package tel_ran.persons.client.api;

import java.util.Date;

public class EmployeeData extends PersonData {

	String company;
	
	int salary;
	
	public EmployeeData(){
		
		_type="Employee";
	}

	public EmployeeData(int id,  String name, Date birthdate, String city, String street, int bld,
			String company, int salary) {
		super(id, name, birthdate, city, street, bld);
		this.company = company;
		this.salary = salary;
		this._type="Employee";
	}

	public EmployeeData(int id, String name, Date birthdate, String city, String street, int bld) {
		super(id, name, birthdate, city, street, bld);
		// TODO Auto-generated constructor stub
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	
}
