package tel_ran.books.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	long isbn; 
	String title;
	double price;
	int publishYear;
	int pages;
	@ManyToMany
	Set<Author> authors;
	@OneToMany(mappedBy="book")
	Set<Deal> deals;
	@ManyToOne
	Publisher publisher;
	public Book(long isbn, String title, double price, int publishYear, int pages) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publishYear = publishYear;
		this.pages = pages;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	public Set<Deal> getDeals() {
		return deals;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publishYear=" + publishYear
				+ ", pages=" + pages +  "]";
	}
	
	
}
