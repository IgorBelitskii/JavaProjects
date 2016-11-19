package tel_ran.books.entities;

import java.io.Serializable;
import java.util.List;

public abstract class Book implements Serializable {
long isbn;
transient public int count;
float cost;
String tittle;
List<Author> authors;
Publisher publisher;
abstract public String toString();
public Book(long isbn, float cost, String tittle, List<Author> authors, Publisher publisher) {
	super();
	this.isbn = isbn;
	this.cost = cost;
	this.tittle = tittle;
	this.authors = authors;
	this.publisher = publisher;
}

}
