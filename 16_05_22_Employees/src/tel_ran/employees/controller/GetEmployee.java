package tel_ran.employees.controller;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.Manager;

public class GetEmployee extends HireEmployee {

	public GetEmployee(int probability) {
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
		int size=empl.getAllEmployees().size();
		int ne = dataProvider.getInteger("getting emplpoyee to choose", 0, size-1);
		Employee man = (Employee) empl.getAllEmployees().get(ne);
		dataProvider.showMessage("Get Employee: "+man);
		empl.hireEmployee(man);
		}

}
