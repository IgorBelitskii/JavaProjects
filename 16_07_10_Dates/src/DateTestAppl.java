import java.util.*;
import java.text.*;

public class DateTestAppl {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
	
		Date date = new Date();
		System.out.println(date);
	/*	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(df.format(date));
		df = new SimpleDateFormat("MMMM dd yy - hh:mm a",new Locale("en"));
		date = new Date();
		df.setTimeZone(TimeZone.getTimeZone("GMT+5"));
		System.out.println(df.format(date));
		
		df = new SimpleDateFormat("dd/MM/yy");
		date=df.parse("01/01/70");
		System.out.println(date);
		
		// массив строк представляющих даты
		// надо отсортировать в соответствии с датами */
		
		String [] dates = {"12/10/1980","01/01/1960","03/07/1970"};
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Arrays.sort(dates, new StringDatesComparator(df));
		System.out.println(Arrays.deepToString(dates));
		
		Calendar calendar1 = new GregorianCalendar();
		Calendar calendar2=Calendar.getInstance();
		Calendar calendar3= new GregorianCalendar(2015, 01, 1);
		calendar3.set(Calendar.YEAR, 1980);
		System.out.println(calendar1.getTime());
		calendar2.add(Calendar.YEAR, 1000);
		System.out.println(calendar2.getTime());
		System.out.println(calendar3.getTime());
		System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar1.getMinimum(Calendar.DAY_OF_MONTH));
		System.out.println(calendar3.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		
	}

}
