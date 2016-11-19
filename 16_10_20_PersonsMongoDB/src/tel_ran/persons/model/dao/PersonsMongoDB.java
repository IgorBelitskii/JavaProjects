package tel_ran.persons.model.dao;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import tel_ran.persons.model.entities.Person;
import tel_ran.persons.repo.PersonsRepository;

public class PersonsMongoDB {

	@Autowired
	PersonsRepository persons;

	public boolean addPerson(Person person) {

		if (person == null || persons.exists(person.getId()))
			return false;
		persons.save(person);
		return true;
	}

	public Iterable<Person> getAllPersons() {
		return persons.findAll();
	}

	public boolean removePerson(int id) {
		if (!persons.exists(id))
			return false;
		persons.delete(id);
		return true;
	}

	public Person getPerson(int id) {
		return persons.findOne(id);
	}

	public Iterable<Person> getPersonsByName(String name) {
		
		return persons.findByName(name);
	}

	public Iterable<Person> getPersonsByCity(String city) {
		
		return persons.findByAddressCity(city);
	}
	
	public Iterable<Person> getPersonsByAge(int fromAge, int toAge) {
		int yearFrom=getYear(toAge);
		int yearTo=getYear(fromAge);
		return persons.findByBirthYearBetweenOrderByBirthYear(yearFrom, yearTo);
	}

	private int getYear(int age) {
		return Calendar.getInstance().get(Calendar.YEAR)-age;
	}
	
	public Iterable<Person> getEmployeesBySalaryLess(int salary) {
		return persons.findBySalaryLessThan(salary);
	}

}
