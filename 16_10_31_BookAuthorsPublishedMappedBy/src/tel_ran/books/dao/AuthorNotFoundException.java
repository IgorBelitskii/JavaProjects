package tel_ran.books.dao;

public class AuthorNotFoundException extends Exception {
String name;

public AuthorNotFoundException(String name) {
	super("Author "+name+ " not found");
	this.name = name;
}

public String getName() {
	return name;
}


}
