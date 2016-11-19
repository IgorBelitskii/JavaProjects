package tel_ran.persons.model.entities;

public class Child extends Person {
	String garten; //детский сад

	public Child(String garten) {
		super();
		this.garten = garten;
	}

	public String getGarten() {
		return garten;
	}

	public void setGarten(String garten) {
		this.garten = garten;
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + ", id=" + id + ", name=" + name + ", birthYear=" + birthYear + ", adress="
				+ adress + "]";
	}

	
}
