package tel_ran.employees.controller.salary;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.implementation.EmployeesArray;

public class SalaryGroup {
	int minSalary;
	int	maxSalary;
	Array employees;
	public SalaryGroup(int minSalary, int maxSalary, Array employees) {
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}
	/*public void ResetMinMax() {
		/*Array ar1=new Array();
		ar1=((EmployeesArray)employees).getAllEmployees();
		ar1.sort(new SalaryComparator());
		int size=ar1.size();
		this.minSalary=((Employee)ar1.get(0)).computeSallary();
		this.maxSalary=((Employee)ar1.get(size-1)).computeSallary();
		}*/
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public Array getEmployees() {
		return employees;
	}
	public void setEmployees(Array  employees) {
		this.employees = employees;
	} 

}
