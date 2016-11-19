package tel.ran.strings.model;

public class StringJoinString extends StringsJoin {

	public StringJoinString(String[] strings, String delimeter) {
		super(strings, delimeter);
		// TODO Auto-generated constructor stub
	}

	public String join() {
		String sum="";
		if ((strings!=null) && (strings.length>0)) {
			sum=strings[0];
			for (int i = 1; i < strings.length; i++) {
					sum+=delimeter+strings[i];
					}
		} 
		return sum;

	}

}
