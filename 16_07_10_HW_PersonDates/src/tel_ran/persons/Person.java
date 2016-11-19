package tel_ran.persons;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Person {
	private static final String Default_FORMAT = "dd/MM/yyyy";
	String name;
	Date birthDay;
	String country;
	static DateFormat df=new SimpleDateFormat(Default_FORMAT);
	public Person(String name, String country, String sbirthDay) throws ParseException {
		super();
		this.name = name;
		this.country = country;
		this.birthDay = df.parse(sbirthDay);
	}
	public String getCountry() {
		return country;
	}
	public String getName() {
		return name;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public static void setDateFormat(DateFormat df) {
		Person.df = df;
	}
	
	@Override
	public String toString() {
		DateFormat ndf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		ndf.setTimeZone(TimeZone.getTimeZone(country));
		if ((country=="USSR")||(country=="Russia")) ndf.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
		if (country=="USA") ndf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		if (country=="Australia") ndf.setTimeZone(TimeZone.getTimeZone("Australia/Melbourne"));
		return "Person [name=" + name + ", birthDay=" + ndf.format(birthDay) +", country="+country+  "]";
	}
	/**
	 * 
	 * @return Age of person (number if full years)
	 * 
	 */
	public int getAge(){
		Calendar checkDay=GregorianCalendar.getInstance();
		Calendar birthDay = new GregorianCalendar();
		birthDay.setTime(this.birthDay);
		 int years = checkDay.get(GregorianCalendar.YEAR) - birthDay.get(GregorianCalendar.YEAR);
	        // Correcting, if this month less then birthday's month
	        int checkMonth = checkDay.get(GregorianCalendar.MONTH);
	        int birthMonth = birthDay.get(GregorianCalendar.MONTH);
	        if ( checkMonth < birthMonth ) {
	            years --;
	        } else  if (checkMonth == birthMonth
	                && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthDay.get(GregorianCalendar.DAY_OF_MONTH)) {
	            // if months equal
	            // but day less than birthday
	            years --;
	        }
	        return years;
	}
	/**
	 * 
	 * @return days to next birthday celebration
	 */
	public int getDaysToBirthdayCelebration() {
		Calendar today = new GregorianCalendar();
		int age= getAge();
		Calendar nextbirthDay = new GregorianCalendar();
		nextbirthDay.setTime(this.birthDay);
		nextbirthDay.add(Calendar.YEAR, age+1);
		long difference=(nextbirthDay.getTime()).getTime()-(today.getTime()).getTime();
		int days = (int)(difference/(24*60*60*1000)); // getting different in ms and dividing by 1000, by 60, by 60, by 24 to get days
		return days;
		
	}
	/// + testcase
	
	
}
