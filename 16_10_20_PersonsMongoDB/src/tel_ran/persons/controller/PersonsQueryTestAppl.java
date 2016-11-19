package tel_ran.persons.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.model.dao.PersonsMongoDB;
import tel_ran.persons.model.entities.Person;

public class PersonsQueryTestAppl {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		PersonsMongoDB personsMongo = ctx.getBean(PersonsMongoDB.class);
		/*displayPersons(personsMongo.getPersonsByName("Sara"));*/
/*		displayPersons(personsMongo.getPersonsByCity("Rehovot"));*/
	/*	displayPersons(personsMongo.getPersonsByAge(0, 13));*/
		displayPersons(personsMongo.getEmployeesBySalaryLess(18000));
		ctx.close();

	}

	private static void displayPersons(Iterable<Person> personsByName) {
		for (Person person : personsByName) {
			System.out.println(person);
		}
		
	}
}
