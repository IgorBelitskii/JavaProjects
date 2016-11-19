package tel_ran.books.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

@Id
String name;
@Embedded
Address address;
int birthYear;


@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




public Author() {
}



public Author(String name, Address address, int birthYear) {
	super();
	this.name = name;
	this.address = address;
	this.birthYear = birthYear;
}



@Override
public String toString() {
	return "Author [name=" + name + ", address=" + address + ", birthYear=" + birthYear + "]";
}


}
