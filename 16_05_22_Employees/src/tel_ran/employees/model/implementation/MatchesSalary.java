package tel_ran.employees.model.implementation;

import tel_ran.collections.interfaces.Predicate;
import tel_ran.employees.model.dao.Employee;

public class MatchesSalary implements Predicate {

	
	public boolean matches(Employee obj, int minSalary, int maxSalary) {
			if ((obj.computeSallary()>=minSalary)&&(obj.computeSallary()<=maxSalary)) return true;
		return false;
	}

	@Override
	public boolean matches(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
