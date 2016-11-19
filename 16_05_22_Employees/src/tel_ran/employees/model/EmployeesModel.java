package tel_ran.employees.model;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;

public interface EmployeesModel {

	public boolean hireEmployee(Employee empl);
	// следит чтобы не было двух с одним теудат зеутом
	
	public boolean fireEmployee(int id);
	
	public Array getAllEmployees();
	 //returns array of employees
	
	public Employee getEmployee(int id);
	//if doesn't exist returns null
	
	public Array getEmployeesBySalary(int minSalary, int maxSalary);
	// 	Array of employees getting a salary	value in the give range []
	
}
