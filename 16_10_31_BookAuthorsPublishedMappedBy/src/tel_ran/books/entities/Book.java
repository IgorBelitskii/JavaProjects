package tel_ran.books.entities;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Book {
@Id
long isbn;
String title;
float price;
@ManyToOne
Publisher publisher;
@ManyToMany
Set<Author> authors;
public long getIsbn() {
	return isbn;
}
public Book(long isbn, String title, float price) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.price = price;
}
public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
}
public void setAuthors(Set<Author> authors) {
	this.authors = authors;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Publisher getPublisher() {
	return publisher;
}
public Set<Author> getAuthors() {
	return authors;
}
public Book() {

}
@Override
public String toString() {
	return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publisher=" + publisher + ", authors="
			+ authors + "]";
}

}
