package tel_ran.persons.model.entities;

public abstract class Person {
	int id;
	String name;
	int birthYear;
	Address adress;
	
	abstract public String toString();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public int getId() {
		return id;
	}
	public int getBirthYear() {
		return birthYear;
	}
	
}
