package tel_ran.persons;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonTestAppl {

	public static void main(String[] args) throws ParseException {

		
		Person.setDateFormat(new SimpleDateFormat("dd MM yyyy HH:mm:ss zzzz"));
		Person Itshak = new Person("Itshak","Russia","11 09 1981 15:25:00 +0500");
		System.out.println(Itshak);
		System.out.println(Itshak.getAge());
		System.out.println(Itshak.getDaysToBirthdayCelebration());
		Person.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));

	}

}
