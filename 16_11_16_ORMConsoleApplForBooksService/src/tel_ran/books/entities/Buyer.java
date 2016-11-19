package tel_ran.books.entities;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Buyer {
	@Id
	int identity;
	String name;
	int birthYear;
	@Embedded
	Address address;
	String phoneNumber;
	String email;
	@OneToMany(mappedBy="buyer")
	Set<Deal> deals;
	public Buyer(int identity, String name, int birthYear, Address address, String phoneNumber, String email) {
		super();
		this.identity = identity;
		this.name = name;
		this.birthYear = birthYear;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public Buyer() {
		super();
	
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Deal> getDeals() {
		return deals;
	}
	@Override
	public String toString() {
		return "Buyer [identity=" + identity + ", name=" + name + ", birthYear=" + birthYear + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", deals=" + deals + "]";
	}
	
}
