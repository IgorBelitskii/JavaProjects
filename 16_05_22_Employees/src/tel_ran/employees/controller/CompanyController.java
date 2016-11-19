package tel_ran.employees.controller;

import tel_ran.employees.model.EmployeesModel;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.Manager;
import tel_ran.employees.model.dao.WageEmployee;
import tel_ran.employees.model.implementation.EmployeesArray;
import tel_ran.generation.events.Distribution;
import tel_ran.view.random.RandomMenu;
import tel_ran.view.tests.AddNumbersItem;
import tel_ran.view.tests.StringLengthItem;

public class CompanyController {
int nEmployees;
int percentWageEmployees;// percent of wage employees
int nNames;//
int minBasicSalary;//minimum basic salary
int maxBasicSalary;
int maxGrade;
int minWage;
int maxWage;
int minHours;
int maxHours;

public static void main(String[] args) {
	
	Distribution items=new Distribution();
	items.addEvent(new HireManager(10));
	items.addEvent(new HireEmployee(30));
	items.addEvent(new HireWage(60));
	int nRuns=30;
	RandomMenu menu=new RandomMenu(items, nRuns);
	menu.runMenu();
	Distribution items2= new Distribution();
	items2.addEvent(new FireEmployee(20));
	items2.addEvent(new GetAllEmployees(10));
	items2.addEvent(new GetEmployee(10));
	items2.addEvent(new GetEmployeesBySalary(30));
	items2.addEvent(new HireManager(10));
	items2.addEvent(new HireWage(10));
	items2.addEvent(new HireEmployee(10));
	nRuns=30;
	RandomMenu menu2=new RandomMenu(items2, nRuns);
	menu2.runMenu();
	
}
}


