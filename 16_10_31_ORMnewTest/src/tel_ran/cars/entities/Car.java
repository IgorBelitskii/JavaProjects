package tel_ran.cars.entities;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", color=" + color + ", model="+model+"]";
	}
	@Id
	private long regNumber;
	private String color;
	@ManyToMany
	Set<Owner> owners;
	@ManyToOne
	Model model;
	public long getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(long regNumber) {
		this.regNumber = regNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Set<Owner> getOwners() {
		return owners;
	}
	public Car() {
		super();
	}
	public Car(long regNumber, String color, Set<Owner> owners, Model model) {
		super();
		this.regNumber = regNumber;
		this.color = color;
		this.owners = owners;
		this.model = model;
	}
	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}

}
