package tel_ran.networking.management.elements;
/**
 * String name
Int nInterfaces
Constructor using fields
Setters
Getters

 * @author Igor
 *
 */
public class Router {
	String name;
	int nInterfaces;
	public Router(String name, int nInterfaces) {
		super();
		this.name = name;
		this.nInterfaces = nInterfaces;
	}
	public String getName() {
		return name;
	}

	public int getnInterfaces() {
		return nInterfaces;
	}

	@Override
	public String toString() {
		return "Router [name=" + name + ", nInterfaces=" + nInterfaces + "]";
	}
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
		Router other = (Router) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
