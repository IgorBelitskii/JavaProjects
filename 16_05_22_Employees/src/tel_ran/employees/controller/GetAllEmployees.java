package tel_ran.employees.controller;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.Manager;

public class GetAllEmployees extends HireEmployee {

	public GetAllEmployees(int probability) {
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
		
		Array a1= empl.getAllEmployees();
		int size=a1.size();
		dataProvider.showMessage("Getting all employees: "+size+" items.");
	
		}

}
