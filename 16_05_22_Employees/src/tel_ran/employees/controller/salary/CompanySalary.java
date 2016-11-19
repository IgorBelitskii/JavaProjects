package tel_ran.employees.controller.salary;

import tel_ran.collections.Array;
import tel_ran.employees.controller.CompanyRand;
import tel_ran.employees.model.EmployeesModel;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.implementation.EmployeesArray;

public class CompanySalary {
	EmployeesModel employees;
	
	
	
public CompanySalary(EmployeesModel employees) {
		this.employees = employees;
	}



public Array getEmployeesSortedBySalary() {
	Array arrempl = employees.getAllEmployees();
	arrempl.sort(new SalaryComparator());
	/*EmployeesArray arrempl = new EmployeesArray();
	Array ar1 = new Array();
	int size=((Array)employees).size();
	for (int i=0; i<size; i++) {
	ar1.add(i,((Array)employees).get(i));
	}
	ar1.sort(new SalaryComparator());
	for (int i=0; i<size; i++) {
		arrempl.hireEmployee((Employee)ar1.get(i));
		}*/
	return arrempl;
	
	}
public Array getSalaryGroups(int nGroups) {
	Array ar1=employees.getAllEmployees();
	ar1.sort(new SalaryComparator());
	int size=((Array)employees.getAllEmployees()).size();
	int min=((Employee)(ar1).get(0)).computeSallary();
	int max=((Employee)(ar1).get(size-1)).computeSallary();
	int step=(max-min)/nGroups;
	Array sal= new Array();
	for (int i=0; i<nGroups; i++) {
		int low=0, high=0;
		if (i==0) {low = min + i*step; }else {low = min + i*step+1;}
		if (i==nGroups-1) high=max; else high = min + (i+1)*step;
		//int high = max - (nGroups-i-1 )* step;
		ar1=employees.getEmployeesBySalary(low, high);
	
		sal.add(i, new SalaryGroup(low, high, ar1));
		
	}
	return sal;
	}
public void increaseSalary(SalaryGroup group, int percent) {
	Array arr1=new Array();
	arr1=group.getEmployees();
	int size=arr1.size();
	int sal;
	int minSal=group.getMinSalary();
	int maxSal=group.getMaxSalary();
	
for (int i=0; i<size; i++) {
	sal=(int) (((Employee)arr1.get(i)).getBasicSalary()*((100+percent)/100.0));
	
	((Employee)arr1.get(i)).setBasicSalary(sal);
	int sal1=((Employee)arr1.get(i)).computeSallary();
	if (sal1<minSal) minSal=sal;
	if (sal1>maxSal) maxSal=sal;
	}
	group.setEmployees(arr1);
	group.setMaxSalary(maxSal);
	group.setMinSalary(minSal);
}

public void decreaseSalary(SalaryGroup group, int percent) {
	increaseSalary(group, -percent);
	}
	
}


