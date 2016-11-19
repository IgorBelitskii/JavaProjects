package tel_ran.employees.model.implementation;

import tel_ran.collections.Array;
import tel_ran.employees.model.EmployeesModel;
import tel_ran.employees.model.dao.Employee;

public class EmployeesArray implements EmployeesModel {
	static Array employeesArray;
	public EmployeesArray() {
	employeesArray = new Array();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hireEmployee(Employee empl) {
		// следит чтобы не было двух с одним теудат зеутом
		
		if (isnotEmployee(empl.getId())) {
			employeesArray.add(empl);
			return true;
		}
		return false;
	}

	@Override
	public boolean fireEmployee(int id) {
		// TODO Auto-generated method stub
		if (isnotEmployee(id)) 
			return false;
		else {
			employeesArray.remove(indexOfEmployee(getEmployee(id)));
		return true;
		}
	}

	@Override
	public Array getAllEmployees() {
		Array res = new Array();
		int size = ((Array)employeesArray).size();
		for (int i=0; i<size; i++) {
			res.add(employeesArray.get(i));
		}
		return res; // возвращаем не ссылку на массив а копию массива
	}

	@Override
	public Employee getEmployee(int id) {
		int size = ((Array)employeesArray).size();
		for (int i=0; i<size; i++) {
			if (((Employee)employeesArray.get(i)).getId()==id) {
				return (Employee)employeesArray.get(i);
			}
		}

		return null;
	}

	@Override
	public Array getEmployeesBySalary(int minSalary, int maxSalary) {
		MatchesSalary ms=new MatchesSalary();
		int size = ((Array)employeesArray).size();
		Array ar1 = new Array();
		int sal;
		for (int i=0; i<size; i++) {
			sal=(int)((Employee)employeesArray.get(i)).computeSallary();
			/*if ((sal>=minSalary)&&(sal<maxSalary)) { //commented working "if without using predicate"
				ar1.add(employeesArray.get(i));
			}*/
			if (ms.matches((Employee)employeesArray.get(i), minSalary, maxSalary)) {
				ar1.add(employeesArray.get(i));
			}
		}
		return ar1;
	}
	/**
	 * 
	 * @param id
	 * @return false if there is Employee with this id, and true if not
	 */
	public boolean isnotEmployee(int id) {
		int size = ((Array)employeesArray).size();
			for (int i=0; i<size; i++) {
				if (((Employee)employeesArray.get(i)).getId()==id) {
					return false;
				}
			}
		return true;
	//	if (Array)employeesArray.find(predicate)
	}
	public int indexOfEmployee(Employee emp) {
		int size = ((Array)employeesArray).size();
			for (int i=0; i<size; i++) {
				if ((Employee)employeesArray.get(i)==emp) {
					return i;
				}
			}
		return 0;
	}
}
