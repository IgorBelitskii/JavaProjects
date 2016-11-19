package tel_ran.persons.model.dao;

import java.util.Iterator;
import java.util.*;
import java.util.function.Predicate;

import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Person;
import tel_ran.persons.model.interfaces.PersonsCrudRepositary;

public class PersonsRepositoryMaps implements PersonsCrudRepositary {
Map<Integer, Person> persons = new HashMap<>(); // key=id, value= person
Map<Integer,List<Person>> personsSalary= new TreeMap<>(); // key=Salary - value=list of persons
// В TreeMap используем SubMap  для получений диапазонов
Map<Address,List<Person>> personsAddress = new HashMap<>(); // key - Address , value = list of persons
Map<Integer,List<Person>> personsYear = new TreeMap<>(); // key - birthYear



	@Override
	public Iterator<Person> iterator() {
		
		return persons.values().iterator();
	}

	@Override
	public boolean addPerson(Person person) {
		int id = person.getId();
		if(persons.containsKey(id))
		return false;
		persons.put(id, person);
		addPersonsSalary(person);
		addPersonsAddress(person);
		addPersonsYear(person);
		return true;
	}

	private void addPersonsAddress(Person person) {
		Address address = person.getAdress();
		List<Person> persons=personsAddress.get(address);
		if (persons==null) {
			persons=new LinkedList<>();
			personsAddress.put(address, persons);
		}
		persons.add(person);
	}

	@Override
	public Person removePerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> getPersonsBySalary(int minSalary, int maxSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> getPersonsByAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> getPersonsByBirthYear(int fromYear, int toYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> getPersons(Predicate<Person> predicate) {
		// TODO Обходим MAP persons и делаем тест совпадает ли с предикатом
		return null;
	}

	@Override
	public boolean updateSalary(int id, int salary) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAddress(int id, Address newAaddress) {
		// TODO Auto-generated method stub
		return false;
	}

}
