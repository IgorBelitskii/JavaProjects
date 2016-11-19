package tel_ran.persons.client.api;

import java.util.Date;

public class PersonData {
	int id;
	String _type;
	String name;
	Date birthdate;
	String city;
	String street;
	int bld;
	public PersonData(int id, String name, Date birthdate, String city, String street, int bld) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.city = city;
		this.street = street;
		this.bld = bld;
	}
	public PersonData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getBld() {
		return bld;
	}
	public void setBld(int bld) {
		this.bld = bld;
	}
	

}
