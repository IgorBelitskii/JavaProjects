package tel_ran.personproducts.entities;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	@Id
	private long id;
	private String name;
	@ManyToMany
	@JoinTable (name="PersonProducts")
	List<Product> products;
	@ManyToMany
	@JoinTable (name="PersonRentedProducts")
	List<Product> rents;
	public Person(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getRents() {
		return rents;
	}
	public void setRents(List<Product> rents) {
		this.rents = rents;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}