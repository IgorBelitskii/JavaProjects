package tel_ran.employees.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.employees.model.dao.Manager;
import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.WageEmployee;
import tel_ran.employees.model.implementation.EmployeesArray;

public class TestEmployee {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEmployee() {
		 Manager man1 = new Manager(111222333, "Super Manager1", "General director", 10000, 1);
		 WageEmployee man2= new WageEmployee(333444555, "Super Wage1", "cleaner", 3000, 25, 100);
		 Employee man3= new Employee(666777888, "Super Employee1", "cleaner", 7000);	
		 WageEmployee man4= new WageEmployee(000000003, "Super Wage1", "cleaner", 4000, 25, 100);
		 WageEmployee man5= new WageEmployee(000000001, "Super Wage2", "cleaner", 3500, 26, 120);
		 WageEmployee man6= new WageEmployee(000000002, "Super Wage3", "cleaner", 3300, 28, 180);
		 WageEmployee man7= new WageEmployee(333444555, "Super Wage0", "cleaner", 3100, 30, 99);
		 EmployeesArray arr1 = new EmployeesArray();
		 assertEquals(true,arr1.hireEmployee(man1));
		 assertEquals(true,arr1.hireEmployee(man2));
		 assertEquals(true,arr1.hireEmployee(man3));
		 assertEquals(false,arr1.fireEmployee(555)); // false cause there is not such Employee with id=555
		 assertEquals(true,arr1.hireEmployee(man4));
		 assertEquals(true,arr1.hireEmployee(man5));
		 assertEquals(true,arr1.hireEmployee(man6));
		 assertEquals(false,arr1.hireEmployee(man7)); // false cause there is Employee in array with id = man7.id
		 assertEquals(1, man1.getGrade());
	  	 System.out.println("Number of employees: "+((Array)arr1.getAllEmployees()).size());
	  	 System.out.println("Number of employees between 8000 and 15000 nis: "+((Array)(arr1.getEmployeesBySalary(8000, 15000))).size());
	  	 System.out.println("Number of employees between 6000 and 8000 nis: "+((Array)(arr1.getEmployeesBySalary(6000, 8000))).size());
	  	 System.out.println("Number of employees between 4000 and 6000 nis: "+((Array)(arr1.getEmployeesBySalary(4000, 6000))).size());
	   	 System.out.println("Number of employees between 0 and 4000 nis: "+((Array)(arr1.getEmployeesBySalary(0, 4000))).size());
		 
		 //fail("Not yet implemented");
	}

}
