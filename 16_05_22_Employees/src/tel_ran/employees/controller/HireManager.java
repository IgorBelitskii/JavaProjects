package tel_ran.employees.controller;

import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.Manager;

public class HireManager extends HireEmployee {

	public HireManager(int probability) {
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
		int tz = dataProvider.getInteger("Teudat zeut", 1, 99999);
		int basicSalary =  dataProvider.getInteger("Basic Salary", 3000, 25000);
		String [] strings= {"Alex","Vasya","Semen","Wlad", "Igor"};
		String name=dataProvider.getString("select string", strings);
		int grade=dataProvider.getInteger("grade", 1, 3);
		Manager man1 = new Manager(tz,name,"office worker",basicSalary,grade);
		dataProvider.showMessage("Hired manager: "+man1);
		empl.hireEmployee(man1);
		}

}
