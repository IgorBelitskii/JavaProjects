package tel_ran.employees.controller.tests;

import tel_ran.collections.Array;
import tel_ran.employees.controller.CompanyRand;
import tel_ran.employees.controller.salary.CompanySalary;
import tel_ran.employees.controller.salary.SalaryGroup;
import tel_ran.employees.model.EmployeesModel;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.implementation.EmployeesArray;

public class CompanyTestAppl {

	public static void main(String[] args) {
		
		EmployeesModel employees = new EmployeesArray();
		int nEmployees=10;
		int percentWageEmployees=80;
		int nNames=20;
		int minBasicSalary=4500;
		int maxBasicSalary=15000;
		int maxGrade=5;
		int minWage=40;
		int maxWage=150;
		int minHours=100;
		int maxHours=200;
		CompanyRand company= new CompanyRand(nEmployees, percentWageEmployees, nNames, minBasicSalary, maxBasicSalary, maxGrade, minWage, maxWage, minHours, maxHours, employees);
		company.createCompany();
		displayCompany(employees);
		  CompanySalary salaries = new CompanySalary(employees);
		  int nGroups=3;
		  Array salaryGroups = salaries.getSalaryGroups(nGroups);
		 displaySalaryGroups(salaryGroups);
		 salaries.increaseSalary((SalaryGroup)salaryGroups.get(0), 10);
		 salaries.decreaseSalary((SalaryGroup)salaryGroups.get(nGroups-1), 10);
		 System.out.println();
		 System.out.println("________ AFTER increasing/decreasing_____________________");
		 System.out.println();
		 displaySalaryGroups(salaryGroups);
		
		
	}
	private static void displaySalaryGroups(Array salaryGroups)
		{
		  for (int i = 0; i < salaryGroups.size(); i++) {
		   displaySalaryGroup((SalaryGroup)salaryGroups.get(i));
		  }
		}
	 private static void displaySalaryGroup(SalaryGroup sGroup) {
		  
		  System.out.println("\n -----------" 
		           + sGroup.toString() 
		           + " Salaries range: " + sGroup.getMinSalary() 
		           + " - " + sGroup.getMaxSalary() 
		           + " -----------\n");
		  
		  Array allEmployees = sGroup.getEmployees();
		  int nEmployees = allEmployees.size();
		  for (int i = 0; i < nEmployees; i++) {
		   System.out.println(allEmployees.get(i) + " : Summary Salary = " + ((Employee)allEmployees.get(i)).computeSallary());
		  }
		  
		 }
	private static void displayCompany(EmployeesModel employees) {
		// TODO Auto-generated method stub
		
		Array allEmployees=employees.getAllEmployees();
		int nEmployees=allEmployees.size();
		for (int i=0; i<nEmployees; i++) {
			System.out.println(allEmployees.get(i));
		}
		
	}

}
