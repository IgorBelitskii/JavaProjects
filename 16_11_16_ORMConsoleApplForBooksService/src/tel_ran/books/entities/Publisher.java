package tel_ran.books.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	@Id
	String name;
	String city;
	
	@OneToMany(mappedBy="publisher")
	Set<Book> books;

	public Publisher(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
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
	

	public Set<Book> getBooks() {
		return books;
	}


	@Override
	public String toString() {
		return "Publisher [name=" + name + ", city=" + city + ", books=" + books + "]";
	}
	
	
	
}
