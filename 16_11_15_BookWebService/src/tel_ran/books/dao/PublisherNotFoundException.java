package tel_ran.books.dao;

public class PublisherNotFoundException extends Exception {
	String name;

	public PublisherNotFoundException(String name) {
		super("Publisher "+name+ " not found");
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
