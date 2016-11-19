package tel_ran.books.entity;

import javax.persistence.Entity;

@Entity
public class LiteratureBook extends Book {
	int publishyear;

	public LiteratureBook() {

	}

	public LiteratureBook(int publishyear) {
		super();
		this.publishyear = publishyear;
	}

}
