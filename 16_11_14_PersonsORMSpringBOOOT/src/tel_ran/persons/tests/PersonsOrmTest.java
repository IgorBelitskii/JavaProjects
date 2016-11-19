package tel_ran.persons.tests;

import static org.junit.Assert.*;
import static tel_ran.persons.controller.PersonsOrmTestCreation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
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
public class PersonsOrmTest {
private static final int ID = 112233;
private static final String CITY = "Tel-Aviv";
private static final String STREET = "Sokolov";
private static final int BLD = 10;
Person [] persons;
Person [] personsNov;
static AbstractApplicationContext ctx;
static PersonsOrm personsOrm;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx=new FileSystemXmlApplicationContext("beans.xml");
		personsOrm=ctx.getBean(PersonsOrm.class);
	}
	@Before 
	public void setUp(){
		personsOrm.addPerson(new Child(ID, "Masha", LocalDate.of(2013, 11, 1),
				new Address(CITY, STREET, BLD), "Shalom"));
		 persons=new Person[]{
				new Child(123, "Moshe", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Employee(124, "Vasya", LocalDate.of(1990, 1, 30), new Address("Rehovot", "Plaut", 10), "Tel-Ran", 15000),
				new Child(125, "Sara", LocalDate.of(2015, 3, 13), new Address("Rehovot", "Plaut", 10), "none"),
				new Child(126, "Olya", LocalDate.of(2010, 5, 12), new Address("Beersheva","Yalim",3), "Klita"),
				new Child(127, "Sasha", LocalDate.of(2012, 11, 3), new Address("Beersheva","Yalim",3), "Klita"),
				new Employee(128, "David", LocalDate.of(1970, 1, 3), new Address("Beersheva","Yalim",3), "Motorola", 20000),
				new Child(129, "Tolya", LocalDate.of(2010, 5, 3), new Address("Rehovot", "Plaut", 10), "Salut"),
				new Employee(130, "Serg", LocalDate.of(1975, 4, 12), new Address("Beersheva","Yalim",3), "Motorola", 18000)
				};
		 personsNov=new Person[]{new Child(123, "Moshe", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				 new Child(ID, "Masha", LocalDate.of(2013, 11, 1),
							new Address(CITY, STREET, BLD), "Shalom"),
				 new Child(127, "Sasha", LocalDate.of(2012, 11, 3), new Address("Beersheva","Yalim",3), "Klita")};
		createPersons(persons, personsOrm);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void testGetPerson() {
		Person person=personsOrm.getPerson(ID);
		assertEquals(CITY,person.getAddress().getCity());
	}
	@Test
	public void testRemovePerson(){
		Person person=personsOrm.getPerson(ID);
		assertEquals(person,personsOrm.removePerson(ID));
		assertEquals(null,personsOrm.getPerson(ID));
		
	}
	@After
	public void tearDown(){
		personsOrm.removePerson(ID);
	}
	@Test
	public void testGetPersonsMonth(){
		List<Person> actual=personsOrm.getPersonsByMonth(11);
		Person[]actualArray=actual.
		toArray(new Person[actual.size()]);
		Arrays.sort(actualArray,(a,b)->a.getId()-b.getId());
		Arrays.sort(personsNov,(a,b)->a.getId()-b.getId());
		assertArrayEquals(personsNov,
				actualArray);
	}
}
