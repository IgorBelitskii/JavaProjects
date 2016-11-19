package tel_ran.books.entities;

import javax.persistence.Entity;

@Entity
public class TechnicalBook extends Book {
	String subject;
	int edition;
	public TechnicalBook(long isbn, String title, double price, int publishYear, int pages, String subject,
			int edition) {
		super(isbn, title, price, publishYear, pages);
		this.subject = subject;
		this.edition = edition;
	}
	public TechnicalBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TechnicalBook(long isbn, String title, double price, int publishYear, int pages) {
		super(isbn, title, price, publishYear, pages);
		// TODO Auto-generated constructor stub
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	@Override
	public String toString() {
		return "TechnicalBook [subject=" + subject + ", edition=" + edition + ", isbn=" + isbn + ", title=" + title
				+ ", price=" + price + ", publishYear=" + publishYear + ", pages=" + pages +"]";
	}

	

}
