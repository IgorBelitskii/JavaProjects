package tel_ran.employees.controller.salary;

import tel_ran.collections.interfaces.Comparator;
import tel_ran.employees.model.dao.Employee;

public class SalaryComparator implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		
		return ((Employee)obj1).computeSallary() - ((Employee)obj2).computeSallary();
		
	}


}
