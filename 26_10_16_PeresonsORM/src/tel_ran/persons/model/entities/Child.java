package tel_ran.persons.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Child extends Person {
	String garden;

	public Child(int id, String name, LocalDate birthdate, Address address, String garden) {
		super(id, name, birthdate, address);
		this.garden = garden;
	}

	@Override
	public String toString() {
		return "Child [garden=" + garden + ", id=" + id + ", name=" + name + ", birthYear=" + birthdate + ", address="
				+ address + "]";
	}

	public String getGarden() {
		return garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
	}

	public Child() {
	}

}
