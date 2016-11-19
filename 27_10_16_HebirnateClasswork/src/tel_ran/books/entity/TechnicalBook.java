package tel_ran.books.entity;

import javax.persistence.Entity;

@Entity
public class TechnicalBook extends Book {

	public TechnicalBook(int id, long isbn, String authors, String title, float price, int pages, String publisher,
			int edition, String subject) {
		super(id, isbn, authors, title, price, pages, publisher);
		this.edition = edition;
		this.subject = subject;
	}

	int edition;
	String subject;

}
