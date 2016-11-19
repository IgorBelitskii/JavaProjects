package tel_ran.books.controler;

import java.util.ArrayList;
import java.util.List;

import tel_ran.books.entity.Book;
import tel_ran.books.entity.TechnicalBook;

public class RandomBooksCreations {

	private final static int NBOOKS = 10;

	public List<Book> crateBooks() {
		List<Book> list = new ArrayList<Book>();
		list.add(new TechnicalBook(22, 33, "sdfsd", "sdfsd", 1231, 222, "sdadsd", 222, "dasds"));

		return list;

	}

}
