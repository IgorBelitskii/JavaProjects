package tel_ran.persons.controller;

import tel_ran.persons.dao.PersonsMongo;
import tel_ran.persons.entities.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static tel_ran.persons.controller.interfaces.PersonsRandomConstans.*;

public class RandomPersonCreation {

    public static void main(String[] args) throws Exception {
        PersonsMongo personsMongo = new PersonsMongo
        		("mongodb://igsoft:igsoft@ds053176.mlab.com:53176/", "igsoft");
      List<Person> persons = createRandomPersons();
        for (Person person : persons) {
       // 	System.out.println(person);
            personsMongo.addPerson(person);
            
        }
  //   personsMongo.drop();
    }

    private static List<Person> createRandomPersons() {
        List<Person> res= new ArrayList<>();
        for (int i = 0; i <N_PERSONS ; i++) {
            res.add(createOneRandomPerson());
        }
        return res;
    }

    private static Person createOneRandomPerson() {
        int id = getrandomNumber(MIN_ID,MAX_ID);
        int birthYear = getrandomNumber(MIN_BIRTH_YEAR,MAX_BIRTH_YEAR);
        String  name = "name "+ getrandomNumber(0,NAME_ID);
        return new Person(id,birthYear,name);
    }

    private static int getrandomNumber(int min, int max) {
        return (int)(Math.random()*(max-min+1)+min);
    }
}