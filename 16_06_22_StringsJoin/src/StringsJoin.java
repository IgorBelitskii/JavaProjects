
public class StringsJoin {
public static String join(String[] strings, String delimeter) {
	String sum="";
	if ((strings!=null) && (strings.length>0)) {
		sum=strings[0];
		for (int i = 1; i < strings.length; i++) {
				sum+=delimeter+strings[i];
				}
	} 
	return sum;
}
public static String joinBuilder(String[] strings, String delimeter) {
	String sum="";
	StringBuilder builder=null;
	if ((strings!=null) && (strings.length>0)) {
		 builder = new StringBuilder(strings[0]);
		for (int i = 1; i < strings.length; i++) {
				builder.append(delimeter).append(strings[i]);
				}
	} 
	sum=builder.toString();
	return sum;
}
}
