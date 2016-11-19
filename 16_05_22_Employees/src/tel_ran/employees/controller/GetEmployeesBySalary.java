package tel_ran.employees.controller;

import tel_ran.collections.Array;
import tel_ran.employees.controller.salary.SalaryGroup;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.Manager;

public class GetEmployeesBySalary extends HireEmployee {

	public GetEmployeesBySalary(int probability) {
		super(probability);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void action() {
		/*
		 Manager man1 = new Manager(111222333, "Super Manager1", "General director", 10000, 1);
		 WageEmployee man2= new WageEmployee(333444555, "Super Wage1", "cleaner", 3000, 25, 100);
		 Employee man3= new Employee(666777888, "Super Employee1", "cleaner", 7000);	
		 */
		
		int min = dataProvider.getInteger("getting min to display", 0, 50000 );
		int max = dataProvider.getInteger("getting max to display", 0, 50000 );
		int mm;
		if (min>max) {
			mm=max;
			max=min;
			min=mm;
		}
		Array a1=empl.getEmployeesBySalary(min, max);
		dataProvider.showMessage("Getted employees by salary min="+min+"; max="+max+" : "+a1.size()+"employees.");
		}

}
