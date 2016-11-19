package tel_ran.books.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Author implements Serializable {
String name;
LocalDate birthDate;
public Author(String name, LocalDate birthDate) {
	super();
	this.name = name;
	this.birthDate = birthDate;
}
@Override
public String toString() {
	return "Author [name=" + name + "]";
}

}
