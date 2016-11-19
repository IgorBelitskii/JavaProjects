package tel_ran.cars.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Owner {
@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", city=" + city + ", birthYear=" + birthYear + "]";
	}
@Id
Integer id;
String name;
String city;
int birthYear;

public Owner() {
	super();
	// TODO Auto-generated constructor stub
}
public Owner(Integer id, String name, String city, int birthYear) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.birthYear = birthYear;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getBirthYear() {
	return birthYear;
}
public void setBirthYear(int birthYear) {
	this.birthYear = birthYear;
}
public Set<Car> getCars() {
	return cars;
}
public void setCars(Set<Car> cars) {
	this.cars = cars;
}
@ManyToMany(mappedBy="owners")
Set<Car> cars;
		
}
