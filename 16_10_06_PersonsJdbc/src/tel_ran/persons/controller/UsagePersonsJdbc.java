package tel_ran.persons.controller;

import tel_ran.persons.dao.PersonsJdbc;
import tel_ran.persons.entities.Person;
import static tel_ran.persons.controller.interfaces.PersonsRandomConstants.*;

public class UsagePersonsJdbc {

	public static void main(String[] args) throws Exception {
		
		PersonsJdbc personsJdbc = new PersonsJdbc();
		Iterable<Person> personsAge=personsJdbc.getPersonsByAge(0, 100);
		displayPersons(personsAge);
		System.out.println(personsJdbc.getPerson(963489));
	//	displayPersons(personsJdbc.getPersonsByName("name 11"));
	}

	private static void displayPersons(Iterable<Person> persons) {
		for (Person person: persons) {
			System.out.println(person);
		}
		
	}

}
