package tel_ran.persons.model.entities;

import javax.persistence.*;
import static tel_ran.persons.api.PersonsConstants.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
public class Employee extends Person {
	String company;
	int salary;

	public Employee(int id, String name, LocalDate birthdate, Address address, String company, int salary) {
		super(id, name, birthdate, address);
		this.company = company;
		this.salary = salary;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", salary=" + salary + ", id=" + id + ", name=" + name + ", birthYear="
				+ birthdate + ", address=" + address + "]";
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

	@Override
	public void setData(Map<String, Object> data) throws IllegalArgumentException {
		super.setData(data);
		try {
			company = (String) data.get(COMPANY);
			Integer Salary = (Integer) data.get(SALARY);
			salary=Salary==null?0:Salary;
		} catch (Exception e) {
			new IllegalArgumentException("Wrong field/s in map for employee");
		}
		return;

	}
}
