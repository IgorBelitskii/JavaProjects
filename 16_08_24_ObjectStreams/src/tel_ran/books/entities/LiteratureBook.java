package tel_ran.books.entities;

import java.util.List;

public class LiteratureBook extends Book {

int likes;

public LiteratureBook(long isbn, float cost, String tittle, List<Author> authors, Publisher publisher, int likes) {
	super(isbn, cost, tittle, authors, publisher);
	this.likes = likes;
}

@Override
public String toString() {
	return "LiteratureBook [likes=" + likes + ", isbn=" + isbn + ", cost=" + cost + ", tittle=" + tittle + ", authors="
			+ authors + ", publisher=" + publisher +", count="+count+"]";
}



}
