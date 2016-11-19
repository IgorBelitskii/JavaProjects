package tel_ran.persons;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestPerson {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws ParseException {
			Person.setDateFormat(new SimpleDateFormat("dd MM yyyy HH:mm:ss zzzz"));
			Person Itshak = new Person("Itshak","Russia","11 09 1981 15:25:00 +0500");
		assertEquals(34, Itshak.getAge());
			/// Testing days to next birthdays 
			Calendar today = new GregorianCalendar();
				int age= Itshak.getAge();
			Calendar nextbirthDay = new GregorianCalendar();
			nextbirthDay.setTime(Itshak.birthDay);
			nextbirthDay.add(Calendar.YEAR, age+1);
			long difference=(nextbirthDay.getTime()).getTime()-(today.getTime()).getTime();
			int days = (int)(difference/(24*60*60*1000));
		assertEquals(days, Itshak.getDaysToBirthdayCelebration());
			Person.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			Person Arie = new Person("Arie","USSR","01/04/1955");
		assertEquals(61, Arie.getAge());
		
		// Testing random persons
		
		Random rand = new Random();
		int number;
		int NUMBER_OF_PERSONS=100;
		Calendar nextbirthDay1 = new GregorianCalendar();
		String country;
		Person[] persons = new Person[NUMBER_OF_PERSONS];
		for (int i = 0; i < persons.length; i++) {
			number=rand.nextInt(3);
			switch (number) {
				case 0: country="Russia"; break;
				case 1: country="India"; break;
				case 2: country="USA"; break;
				default: country="China"; break;
			}
				persons[i]=new Person("Person "+(rand.nextInt(NUMBER_OF_PERSONS)),country,rand.nextInt(31)+"/"+rand.nextInt(12)+"/"+(rand.nextInt(60)+1950));
				System.out.println(persons[i]);
				
				age= persons[i].getAge();
			nextbirthDay1.setTime(persons[i].birthDay);
			nextbirthDay1.add(Calendar.YEAR, age+1);
			difference=(nextbirthDay1.getTime()).getTime()-(today.getTime()).getTime();
			days = (int)(difference/(24*60*60*1000));
		assertEquals(days, persons[i].getDaysToBirthdayCelebration());
		}
		

	}

}
