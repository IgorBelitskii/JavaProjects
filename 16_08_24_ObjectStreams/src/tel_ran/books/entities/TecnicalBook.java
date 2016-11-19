package tel_ran.books.entities;

import java.util.List;

public class TecnicalBook extends Book {
int edition;
String subject;
public TecnicalBook(long isbn, float cost, String tittle, List<Author> authors, Publisher publisher, int edition,
		String subject) {
	super(isbn, cost, tittle, authors, publisher);
	this.edition = edition;
	this.subject = subject;
}
@Override
public String toString() {
	return "TecnicalBook [edition=" + edition + ", subject=" + subject + ", isbn=" + isbn + ", cost=" + cost
			+ ", tittle=" + tittle + ", authors=" + authors + ", publisher=" + publisher + "]";
}




}
