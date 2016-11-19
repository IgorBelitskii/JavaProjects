package tel_ran.orm.test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tel_ran.employees.dao.EmployeesOrm;
import tel_ran.employees.entities.Employee;

public class OrmTest {
	static EmployeesOrm employeesOrm;
	static List<Long> productsList = new LinkedList<>();
	static AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
	
	@BeforeClass
	public static void setUp() throws Exception {
				
			try {
				employeesOrm = ctx.getBean(EmployeesOrm.class);
				Employee igor = new Employee(1, "Igor", 20000);
				Employee sasha = new Employee(2, "Alexander", 18000);
				Employee josef = new Employee(3, "Iosef", 21000);
				Employee leonid = new Employee(4, "Leonid", 12000);
				employeesOrm.addGeneralManager(igor);
				employeesOrm.addEmployee(sasha, 1);
				employeesOrm.addEmployee(josef, 1);
				employeesOrm.addEmployee(leonid, 2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	@Test
	public void GetEmployeesTest() {
		assertTrue(employeesOrm.getEmployees().size() == 2);
	}
	
	@Test
	public void GetSubordinatesTest() {
		assertTrue(employeesOrm.getSubordinates(1).size() == 2);
	}
	
	@Test
	public void GeneralManagerTest() {
		assertTrue(employeesOrm.getGeneralManagers().size() == 1);
	}

	@Test
	public void GetEmployeesWithSalaryGreaterThanManagerTest() {
		assertTrue(employeesOrm.getEmployeesWithSalaryGreaterThanManager().size() == 1);
	}

	@Test
	public void GetLineManagersTest() {
		assertTrue(employeesOrm.getLineManagers().size() == 1);
	}
	
	@AfterClass
	public static void ctxClose() {
		
	//	employeesOrm.deleteGeneral(4);
		
		ctx.close();

	}

}
