package tel_ran.persons.model.interfaces;

import java.util.function.Predicate;

import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Person;

public interface PersonsCrudRepositary extends Iterable<Person> {
boolean addPerson(Person person);
Person removePerson(int id);
Person getPerson(int id);				// MAP key-id value=Person??????
Iterable<Person> getPersonsBySalary(int minSalary, int maxSalary); // Tree MAP key Sallary, value = list persons; самый быстрый поиск по зарплатам Employee.
Iterable<Person> getPersonsByAddress(Address address); // MAP самый быстрый поиск
Iterable<Person> getPersonsByBirthYear(int fromYear, int toYear); //Tree MAP самый быстрый поиск
Iterable<Person> getPersons(Predicate<Person> predicate);
boolean updateSalary(int id, int salary);
boolean updateAddress(int id, Address newAaddress);

}
