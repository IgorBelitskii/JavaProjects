package tel_ran.books.entities;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Address implements Serializable {

 public Address(String country, String city) {
  super();
  this.country = country;
  this.city = city;
 }

 String country;
 String city;

 public Address() {
 }

@Override
public String toString() {
	return "Address [country=" + country + ", city=" + city + "]";
}

 
}