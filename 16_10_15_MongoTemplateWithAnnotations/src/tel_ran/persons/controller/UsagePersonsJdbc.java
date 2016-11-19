package tel_ran.persons.controller;

import tel_ran.persons.dao.PersonsMongo;
import tel_ran.persons.entities.Person;

import java.sql.SQLException;

public class UsagePersonsJdbc {
	public static void main(String[] args) throws Exception {
		PersonsMongo personsMongo = new PersonsMongo("mongodb://igsoft:igsoft@ds053176.mlab.com:53176/", "igsoft");
		// System.out.println(personsMongo.getPerson(63715700));
		/*
		 * Iterable<Person> personAge = personsJdbc.getPersonsByAge(20,30);
		 * displayPersons(personAge);
		 */

		// displayPersons(personsMongo.getPersonsByName("name 20"));
	//	displayPersons(personsMongo.getPersonsByNameAndYearAfter("name 20", 1950));
		displayPersons(personsMongo.getPersonsByNames(new String[]{"name 7", "name 8"}));

	}

	private static void displayPersons(Iterable<Person> personAge) {
		for (Person person : personAge) {
			System.out.println(person);
		}
	}
}
