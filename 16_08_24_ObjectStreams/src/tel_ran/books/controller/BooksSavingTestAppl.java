package tel_ran.books.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tel_ran.books.entities.Author;
import tel_ran.books.entities.Book;
import tel_ran.books.entities.LiteratureBook;
import tel_ran.books.entities.Publisher;
import tel_ran.books.entities.TecnicalBook;

public class BooksSavingTestAppl {

	private static long isbn=123;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Book[] books = {getLiteratureBook(), getTechnicalBook()};
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("books"));
		books[0].count=100;
		books[1].count=200;
		for (Book book : books) {
			output.writeObject(book);
		}

	}

	private static Book getTechnicalBook() {
	
		List<Author> authors = new ArrayList<>();
		authors.add(new Author("Bolt", LocalDate.of(1980, 12, 5)));
		authors.add(new Author("Blake",LocalDate.of(1982, 3, 3)));
		return new TecnicalBook(isbn++, 200, "Big Data in Action", authors , new Publisher("O'Relly","USA"), 2, "BIG DATA");
	}

	private static Book getLiteratureBook() {
		List<Author> authors=new ArrayList<>();
		authors.add(new Author("Lev Tolstoy", LocalDate.of(1928, 8, 28)));
		return new LiteratureBook(isbn, 100, "War and Peace", authors, new Publisher("Mir", "Russia"), 1000);
	}

}
