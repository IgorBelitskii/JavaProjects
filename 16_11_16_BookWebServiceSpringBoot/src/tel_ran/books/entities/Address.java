package tel_ran.books.entities;
import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Address implements Serializable {
	
String city;
String street;
int bld;
String aprt;
public Address(String city, String street, int bld, String aprt) {
	super();
	this.city = city;
	this.street = street;
	this.bld = bld;
	this.aprt = aprt;
}
public Address() {
	super();
	// TODO Auto-generated constructor stub
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
public String getAprt() {
	return aprt;
}
public void setAprt(String aprt) {
	this.aprt = aprt;
}
@Override
public String toString() {
	return "Address [city=" + city + ", street=" + street + ", bld=" + bld + ", aprt=" + aprt + "]";
}
 
 
}