package tel_ran.persons.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Employee;
import tel_ran.persons.model.entities.Person;
import tel_ran.persons.model.interfaces.PersonsCrudRepository;

public class PersonsRepositoryMaps implements PersonsCrudRepository {
	Map<Integer,Person> persons = new HashMap<>();//key -id
	Map<Integer, List<Person>> salaries = new TreeMap<>();//key -salary
	Map<Address,List<Person>> addresses = new HashMap<>();
	Map<Integer, List<Person>> birthYears = new TreeMap<>();//key -birthYear

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
		addPersonsBirthYear(person);
		return true;
	}

	private void addPersonsBirthYear(Person person) {
		int birthYear = person.getBirthYear();
		List<Person> persons = birthYears.get(birthYear);
		if(persons == null) {
			persons = new LinkedList<>();
			birthYears.put(birthYear, persons);
		}
		
		persons.add(person);
		
	}

	private void addPersonsAddress(Person person) {
		Address address = person.getAddress();
		List<Person> persons = addresses.get(address);
		
		if(persons == null) {
			persons = new LinkedList<>();
			addresses.put(address,persons);
		}
		
		persons.add(person);
		
	}

	private void addPersonsSalary(Person person) {
		int salary; 
		Employee emp;
		if(isEmployee(person)) {
			 emp = (Employee)person;
			salary = emp.getSalary();
			List<Person> newSalaries = salaries.get(salary);
			
			if(newSalaries == null) {
				newSalaries = new LinkedList<>();
				salaries.put(salary, newSalaries);
			}
			newSalaries.add(person);
		}
		
	}

	@Override
	public Person removePerson(int id) {
		Person person = persons.remove(id);
		
		
		addresses.get(person.getAddress()).remove(person);
		birthYears.get(person.getBirthYear()).remove(person);	
		
		if(isEmployee(person)) 
			salaries.get(((Employee)person).getSalary()).remove(person);	
		
		
		return person;
	}

	private boolean isEmployee(Person person) {
		try {
			if(((Employee)person).getSalary() >= 0)
			return true;
		} catch (ClassCastException e) {
			return false;
		}
		return false;
	}

	@Override
	public Person getPerson(int id) {
		return persons.get(id);
	}

	
	@Override
	public Iterable<Person> getEmployeesBySalary(int minSalary, int maxSalary) {	
		return getPersonsByTwoParameter((TreeMap<Integer, List<Person>>)salaries, minSalary, maxSalary);
	}

	private Iterable<Person> getPersonsByTwoParameter(TreeMap<Integer, List<Person>> map, int min,
			int max) {
		
		ArrayList<Person> res = new ArrayList<>();
		Map<Integer,List<Person>> submap = new HashMap<>(((TreeMap<Integer,List<Person>>)map).subMap(min, max));
		for (List<Person> list : submap.values()) {
			res.addAll(list);
		}
		
		return res;
	}

	@Override
	public Iterable<Person> getPersonsByAddress(Address address) {
		return addresses.get(address);
	}

	@Override
	public Iterable<Person> getPersonsByAge(int fromYear, int toYear) {
		return getPersonsByTwoParameter((TreeMap<Integer,List<Person>>)birthYears,fromYear,toYear);
	}

	@Override
	public Iterable<Person> getPersons(Predicate<Person> predicate) {
		List<Person> res = new ArrayList<>();
		for (Person person : persons.values()) {
			if(predicate.test(person))
				res.add(person);
		}
		return res;
	}

	@Override
	public boolean updateSalary(int id, int newSalary) {
		Person p = persons.get(id);
		if(isEmployee(p)) {
			Employee emp = (Employee)p;
			int oldSalary = emp.getSalary();
			
			updatePersonsMap(emp, id, newSalary);
			updateSalariesMap(emp, oldSalary , newSalary);
			
			return true;
		}
		return false;
	}

	private void updateSalariesMap(Employee emp, int oldSalary, int newSalary) {
		List<Person> pers = salaries.get(oldSalary);
		pers.remove(emp);
		pers = salaries.get(newSalary);
		pers.add(emp);
		
	}

	private void updatePersonsMap(Employee emp, int id, int newSalary) {
		emp.setSalary(newSalary);
		persons.put(id, emp);
	}

	@Override
	public boolean updateAddress(int id, Address newAddress) {
		//изменить в persons:  -2 change - 3 save
		Person p = persons.get(id);//1 find
		Address oldAddress = p.getAddress();//1 find
		p.setAddress(newAddress);// change
		persons.put(id, p);//save
		
		List<Person> persList = addresses.get(oldAddress);
		persList.remove(p);
		persList = addresses.get(newAddress);
		persList.add(p);
		
		
		//изменить в persons: 1 find -2 change - 3 save
		//удалить из старого адреса in addresses
		//добавить в новый адрес in addresses
		return true;
	}

}
