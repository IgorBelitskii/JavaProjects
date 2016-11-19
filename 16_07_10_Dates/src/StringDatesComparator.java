import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class StringDatesComparator implements Comparator<String> {
DateFormat df;
	public StringDatesComparator(DateFormat df) {
	super();
	this.df = df;
}
	public int compare(String o1, String o2) {
		//DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = df.parse(o1);
			date2 = df.parse(o2);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	/*
		if (((date1.getTime() - date2.getTime()) > 0))
			return 1;
		if (((date1.getTime() - date2.getTime()) < 0))
			return -1;*/ 
		return date1.compareTo(date2);
	}

}
