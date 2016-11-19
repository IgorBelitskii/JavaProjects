package tel_ran.persons.model.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import tel_ran.persons.model.dao.PersonsRepositoryMaps;
import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Child;
import tel_ran.persons.model.entities.Employee;
import tel_ran.persons.model.entities.Person;
import tel_ran.persons.model.interfaces.PersonsCrudRepository;

public class PersonModelTests {
	Person[] persons = {new Child(123, "Moshe", 2011, new Address("Rehovot", "Plaut", 10), "tel_ran"),
			new Employee(124, "Vasya", 1980, new Address("Rehovot", "Plaut", 10),15000, "Tel_ran"),
			new Child(125, "Sara", 2013, new Address("Rehovot", "Plaut", 10), "none"),
			new Child(126, "Olya", 2010, new Address("Beersheva", "Yaelim", 3), "Klita"),
			new Child(127, "Sasha", 2012, new Address("Beersheva", "Yaelim", 3), "Klita"),
			new Employee(128, "DAvid", 1970, new Address("Beersheva", "Yaelim", 3), 20000, "Motorola"),
			new Child(129, "Talya", 2010, new Address("Rehovot", "Plaut", 10), "Salut"),
			new Employee(130, "Serg", 1975, new Address("Beersheva", "Yaelim", 3), 18000, "Motorola")};
	PersonsCrudRepository personsRepository;
	
	@Before
	public void setUp() throws Exception {
		personsRepository = new PersonsRepositoryMaps();
		for(Person p : persons)
			personsRepository.addPerson(p);
	}

	@Test
	public void testIterator() {
		int[] indexes = {0,1,2,3,4,5,6,7};
		HashSet<Person> personsSet = getPersonsSetByIndexes(indexes);
		testIterable(personsSet,personsRepository);
	}

	private void testIterable(HashSet<Person> personsSet,
			Iterable<Person> iterable) {
		int ind =0;
		for(Person person : iterable) {
			assertTrue(personsSet.contains(person));
			ind++;
		}
		assertEquals(personsSet.size(),ind);
		
	}

	private HashSet<Person> getPersonsSetByIndexes(int[] indexes) {
		HashSet<Person> res = new HashSet<>();
		for(int index : indexes)
			res.add(persons[index]);
		return res;
	}
	
	@Test
	public void testRemoveAdd() {
		assertFalse(personsRepository.addPerson(persons[2]));
		assertEquals(persons[2], personsRepository.removePerson(125));
		assertTrue(personsRepository.addPerson(persons[2]));
		
	}
	
	@Test
	public void testGetPerson() {
		assertEquals(persons[1], personsRepository.getPerson(124));
	}
	
	@Test
	public void testUpdateSalary() {
		Iterable<Person> personsSalary;
		
		
		int[] indexes = {1};
		personsSalary = personsRepository.getEmployeesBySalary(15000, 15001);
		testIterable(getPersonsSetByIndexes(indexes), personsSalary);
		assertTrue(personsRepository.updateSalary(124, 20000));
		
		int[] indexes1 = {};
		personsSalary = personsRepository.getEmployeesBySalary(15000, 15001);
		testIterable(getPersonsSetByIndexes(indexes1), personsSalary);
		assertEquals(indexes1.length,((List<Person>)personsSalary).size());
		
		int[] indexes2 = {1,5};
		personsSalary = personsRepository.getEmployeesBySalary(20000, 20001);
		testIterable(getPersonsSetByIndexes(indexes2), personsSalary);
		assertEquals(indexes2.length,((List<Person>)personsSalary).size());
		
		assertFalse(personsRepository.updateSalary(125, 5000));
	}
	
	@Test
	public void testUpdateAddress(){
		assertTrue(personsRepository.updateAddress(128, new Address("Rehovot", "Plaut", 10)));
		
		int[] indexesRehovot = {0,1,2,5,6};
		testIterable(getPersonsSetByIndexes(indexesRehovot), personsRepository.getPersonsByAddress(new Address("Rehovot", "Plaut", 10)));
		
		int[] indexesBeerSheva = {3,4,7};
		testIterable(getPersonsSetByIndexes(indexesBeerSheva), personsRepository.getPersonsByAddress(new Address("Beersheva", "Yaelim", 3)));
	}
	
	
	
	@Test
	public void testGetPersons() {
		int[] indexesMotorola = {5,7};
		testIterable(getPersonsSetByIndexes(indexesMotorola), 
				personsRepository.getPersons(p -> p instanceof Employee && ((Employee)p).getCompany().equals("Motorola")));
	}
	
	@Test
	public void PersonSaveTest() throws FileNotFoundException, IOException, ClassNotFoundException {
		PersonsCrudRepository old = personsRepository;
		personsRepository.save();
		Map<Integer,Person> p1 = ((PersonsRepositoryMaps)personsRepository).getPersons();
		Map<Address,List<Person>> a1 = ((PersonsRepositoryMaps)personsRepository).getAddresses();
		Map<Integer, List<Person>> b1 = ((PersonsRepositoryMaps)personsRepository).getBirthYears();
		Map<Integer, List<Person>> s1 = ((PersonsRepositoryMaps)personsRepository).getSalaries();
		  Iterator<Entry<Integer, Person>> it = p1.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		    }
		  personsRepository = new PersonsRepositoryMaps();
		  Map<Integer,Person> p2 = ((PersonsRepositoryMaps)personsRepository).getPersons();
		  System.out.println("After reading");
		  it = p2.entrySet().iterator();
		  while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		    }
		personsRepository.restore();
		Map<Integer,Person> p3 = ((PersonsRepositoryMaps)personsRepository).getPersons();
		Map<Address,List<Person>> a3 = ((PersonsRepositoryMaps)personsRepository).getAddresses();
		Map<Integer, List<Person>> b3 = ((PersonsRepositoryMaps)personsRepository).getBirthYears();
		Map<Integer, List<Person>> s3 = ((PersonsRepositoryMaps)personsRepository).getSalaries();

		 it = p3.entrySet().iterator();
		  while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.err.println(pair.getKey() + " = " + pair.getValue());
		    }
		assertEquals(p1.equals(p3), true);
		assertEquals(a1.equals(a3), true);
		assertEquals(b1.equals(b3), true);
		assertEquals(s1.equals(s3), true);
	}
	
}
