package tel_ran.persons.client.api;

import java.util.Date;

public class ChildData extends PersonData {

	String garten;

	public ChildData() {
		super();
		_type="Child";

	}

	public ChildData(int id, String name, Date birthdate, String city, String street, int bld,
			String garten) {
		super(id, name, birthdate, city, street, bld);
		this.garten = garten;
		this._type="Child";
	}

	public String getGarten() {
		return garten;
	}

	public void setGarten(String garten) {
		this.garten = garten;
	}

	

	
}
