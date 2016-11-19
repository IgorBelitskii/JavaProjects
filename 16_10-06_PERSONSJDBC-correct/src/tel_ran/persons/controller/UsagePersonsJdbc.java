package tel_ran.persons.controller;

import tel_ran.persons.dao.PersonsJdbc;
import tel_ran.persons.entities.Person;

import java.sql.SQLException;

public class UsagePersonsJdbc {
    public static void main(String[] args) throws Exception {
        PersonsJdbc personsJdbc  = new PersonsJdbc();

        Iterable<Person> personAge = personsJdbc.getPersonsByAge(20,30);
        displayPersons(personAge);

        displayPersons(personsJdbc.getPersonsByName("name 7"));
        System.out.println(personsJdbc.getPerson(963489));
    }

    private static void displayPersons(Iterable<Person> personAge) {
        for(Person person : personAge) {
            System.out.println(person);
        }
    }
}
