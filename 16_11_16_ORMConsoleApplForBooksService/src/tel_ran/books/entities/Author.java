package tel_ran.books.entities;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Author {
	@Id
	String name;
	Date birthdate;
	@ManyToMany(mappedBy="authors")
	Set<Book> books;
	public Author(String name, Date birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", birthdate=" + birthdate + ", books=" + books + "]";
	}

	

}
