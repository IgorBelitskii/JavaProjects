package tel.ran.strings.model;

public abstract class StringsJoin {

	abstract public String join();
	public void setStrings(String[] strings) {
		this.strings = strings;
	}
	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}
	String[] strings;
	String delimeter;
	public StringsJoin(String[] strings, String delimeter) {
		this.strings = strings;
		this.delimeter = delimeter;
	}
	
	
}
