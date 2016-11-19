package tel_ran.persons.controller;

import tel_ran.persons.dao.MongoTemplate;
import tel_ran.persons.dao.PersonsMongo;
import tel_ran.persons.entities.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import static tel_ran.persons.controller.interfaces.PersonsRandomConstans.*;

public class PersonsMongoDBTemplateTesting {

    public static void main(String[] args) throws Exception {
       MongoTemplate<Person, Integer> pmTemplate=
    		   new MongoTemplate<Person,Integer>("mongodb://igsoft:igsoft@ds053176.mlab.com:53176/", "igsoft", "id","personsMongo1");
    
    //  List<Person> persons = createRandomPersons();
	//   pmTemplate.saveMany(persons);
       System.out.println("Finding one....");
       System.out.println(pmTemplate.findOne(49299211));
    //   Document query = new Document("birthYear", new Document("$lte", 1981));
       System.out.println("Finding many....");
	   Iterable<Person> persons =pmTemplate.findMany(new Document("birthYear", new Document("$gte", 1981)));
	   printPersons(persons);
    }

    private static void printPersons(Iterable<Person> persons) {
		for (Person person : persons) {
			System.out.println(person);
		}
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
