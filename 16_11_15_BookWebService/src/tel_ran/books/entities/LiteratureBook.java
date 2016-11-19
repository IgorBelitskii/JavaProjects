package tel_ran.books.entities;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class LiteratureBook extends Book {
	String ganre;


	public LiteratureBook() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LiteratureBook(long isbn, String title, double price, int publishYear, int pages, String ganre) {
		super(isbn, title, price, publishYear, pages);
		this.ganre = ganre;
		// TODO Auto-generated constructor stub
	}


	public LiteratureBook(long isbn, String title, double price, int publishYear, int pages, Set<Author> authors,
			Publisher publisher, String ganre) {
		super(isbn, title, price, publishYear, pages);
		this.ganre = ganre;
	}


	public String getGanre() {
		return ganre;
	}


	public void setGanre(String ganre) {
		this.ganre = ganre;
	}


	@Override
	public String toString() {
		return "LiteratureBook [ganre=" + ganre + ", isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", publishYear=" + publishYear + ", pages=" + pages + ", authors=" + authors + ", deals=" + deals
				+ ", publisher=" + publisher + "]";
	}



}
