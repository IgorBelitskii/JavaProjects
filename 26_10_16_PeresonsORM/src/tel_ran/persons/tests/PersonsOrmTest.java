package tel_ran.persons.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.model.dao.PersonsOrm;
import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Child;
import tel_ran.persons.model.entities.Employee;
import tel_ran.persons.model.entities.Person;
import static tel_ran.persons.tests.PersonsORMTestCreationAppl.*;;

public class PersonsOrmTest {
	Person[] persons;
	Person[] personsNov;
	private static final int ID = 112233;
	private static final String STREET = "dsfd";
	private static final String CITY = "rrrrr";
	private static final int BLD = 10;
	static AbstractApplicationContext ctx;
	static PersonsOrm personsOrm;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new FileSystemXmlApplicationContext("beans.xml");
		personsOrm = ctx.getBean(PersonsOrm.class);
	}

	@Before
	public void setUp() {
	//	personsOrm
		//		.addPerson(new Child(ID, "masha", LocalDate.of(2013, 11, 1), new Address(CITY, STREET, BLD), "shalom"));
		persons = new Person[] {
				new Child(123, "Moshe", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Employee(124, "Vasya", LocalDate.of(2011, 10, 3), new Address("Rehovot", "Plaut", 10), 15000,
						"Tel-Ran"),
				new Employee(124, "Vasya", LocalDate.of(2015, 10, 3), new Address("Rehovot", "Plaut", 10), 15000,
						"Tel-Ran"),
				new Employee(124, "Vasya", LocalDate.of(2011, 10, 3), new Address("Rehovot", "Plaut", 10), 15000,
						"TepersonasOrml-Ran") };
		createPersons(persons, personsOrm);

		personsNov = new Person[] {

				new Child(123, "Moshe", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), "tel-ran") };

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Person person = personsOrm.getPerson(ID);
		assertEquals(CITY, person.getAddress().getCity());
	}

	@Test
	public void testGetPersonsMonth() {

		List<Person> actual = personsOrm.getPersonsByMonth(11);
		Person[] actualArray = actual.toArray(new Person[actual.size()]);
		Arrays.sort(actualArray, (a, b) -> a.getId() - b.getId());
		Arrays.sort(personsNov, (a, b) -> a.getId() - b.getId());
		assertArrayEquals(personsNov, actualArray);

	}

}
