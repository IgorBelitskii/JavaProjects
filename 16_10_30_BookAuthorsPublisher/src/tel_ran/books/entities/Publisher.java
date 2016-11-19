package tel_ran.books.entities;
import javax.persistence.*;
@Entity
public class Publisher {
@Id
String name;
@Embedded
Address address;
public Publisher(String name, Address address) {
	super();
	this.name = name;
	this.address = address;
}
public Publisher() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Publisher [name=" + name + ", address=" + address + "]";
}
public String getName() {
	return name;
}


}
