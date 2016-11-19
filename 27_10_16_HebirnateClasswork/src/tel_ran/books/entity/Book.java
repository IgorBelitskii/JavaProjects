package tel_ran.books.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "main_books")
public abstract class Book {

	public Book() {

	}

	public Book(int id, long isbn, String authors, String title, float price, int pages, String publisher) {
		this.id = id;
		this.isbn = isbn;
		this.authors = authors;
		this.title = title;
		this.price = price;
		this.pages = pages;
		this.publisher = publisher;
	}

	@Id
	int id;

	public int getId() {
		return id;
	}

	long isbn;
	String authors;
	String title;
	float price;
	int pages;
	String publisher;

}
