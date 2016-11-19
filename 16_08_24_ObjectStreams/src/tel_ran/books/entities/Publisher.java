package tel_ran.books.entities;

import java.io.Serializable;

public class Publisher implements Serializable {
String name;
String country;
public Publisher(String name, String country) {
	super();
	this.name = name;
	this.country = country;
}
@Override
public String toString() {
	return "Publisher [name=" + name + ", country=" + country + "]";
}

}
