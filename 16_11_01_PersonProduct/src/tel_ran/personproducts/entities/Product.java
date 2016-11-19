package tel_ran.personproducts.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Product {

@Id
Long barcode;
String name;

@ManyToMany(mappedBy="products")
List<Person> persons;
@ManyToMany(mappedBy="rents")
List<Person> personsRent;
public Product(Long barcode, String name) {
	super();
	this.barcode = barcode;
	this.name = name;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getBarcode() {
	return barcode;
}
public void setBarcode(Long barcode) {
	this.barcode = barcode;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Person> getPersons() {
	return persons;
}
public void setPersons(List<Person> persons) {
	this.persons = persons;
}
public List<Person> getPersonsRent() {
	return personsRent;
}
public void setPersonsRent(List<Person> personsRent) {
	this.personsRent = personsRent;
}
@Override
public String toString() {
	return "Product [barcode=" + barcode + ", name=" + name + "]";
}

}
