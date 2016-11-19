package tel.ran.strings.model;

public class StringsJoinBuilder extends StringsJoin {

	public StringsJoinBuilder(String[] strings, String delimeter) {
		super(strings, delimeter);
		// TODO Auto-generated constructor stub
	}


	public String join() {
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
