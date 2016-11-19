package tel_ran.persons.model.entities;

import static tel_ran.persons.api.PersonsConstants.*;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Entity;

@Entity
public class Child extends Person {
String garten;

public String getGarten() {
	return garten;
}

public void setGarten(String garten) {
	this.garten = garten;
}

public Child(int id, String name, LocalDate birthdate, Address address, String garten) {
	super(id, name, birthdate, address);
	this.garten = garten;
}

@Override
public String toString() {
	return "Child [garten=" + garten + ", id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", address="
			+ address + "]";
}

public Child(){}
	
@Override
public void setData(Map<String, Object> data) throws IllegalArgumentException {
	super.setData(data);
	try {
		garten = (String) data.get(GARTEN);
	} catch (Exception e) {
		new IllegalArgumentException("Wrong field/s in map for child");
	}
	return;

}
}
