package tel_ran.persons.tests;

import java.time.LocalDate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.model.dao.PersonsOrm;
import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Child;
import tel_ran.persons.model.entities.Employee;
import tel_ran.persons.model.entities.Person;

public class PersonsORMTestCreationAppl {
	static PersonsOrm personsOrm;

	public static void main(String[] args) {

		Person[] persons = {
				new Child(123, "Moshe", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), "tel-ran"),
				new Employee(124, "Vasya", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), 15000,
						"Tel-Ran"),
				new Employee(124, "Vasya", LocalDate.of(2015, 11, 3), new Address("Rehovot", "Plaut", 10), 15000,
						"Tel-Ran"),
				new Employee(124, "Vasya", LocalDate.of(2011, 11, 3), new Address("Rehovot", "Plaut", 10), 15000,
						"TepersonasOrml-Ran") };

		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		personsOrm = ctx.getBean(PersonsOrm.class);
		createPersons(persons, personsOrm);
		personsOrm.updateAddress(123, new Address("afdfasdf", "asdfasdf", 20));
		

	}

	public static void createPersons(Person[] persons, PersonsOrm personsOrm) {
		for (Person person : persons) {

			personsOrm.addPerson(person);
		}

	}

}
