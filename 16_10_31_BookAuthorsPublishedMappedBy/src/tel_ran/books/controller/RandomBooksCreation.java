package tel_ran.books.controller;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.books.dao.AuthorNotFoundException;
import tel_ran.books.dao.BooksAuthPublishOrm;
import tel_ran.books.dao.PublisherNotFoundException;
import tel_ran.books.entities.Address;
import tel_ran.books.entities.Author;
import tel_ran.books.entities.Book;
import tel_ran.books.entities.Publisher;

public class RandomBooksCreation {
	private static final int N_BOOKS = 100;
	private static final int N_AUTHORS = 20;
	private static final int N_COUNTRIES = 10;
	private static final int N_CITIES = 50;
	private static final int N_PUBLISHERS = 100;
	static Random gen=new Random();
	static BooksAuthPublishOrm booksOrm;
	private static int isbn=0;

	public static void main(String[] args) throws AuthorNotFoundException, PublisherNotFoundException {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		booksOrm = ctx.getBean(BooksAuthPublishOrm.class);
		createRandomBooks();
		ctx.close();
	}

	private static void createRandomBooks() throws AuthorNotFoundException, PublisherNotFoundException {
		createAuthors();
		createPublishers();
		for(int i=0; i<N_BOOKS; i++) {
			createRandomBook();
		}
		
	}

	private static void createRandomBook() throws AuthorNotFoundException, PublisherNotFoundException {
		booksOrm.addBook(new Book(++isbn,getRandomTitle(),getRandomPrice()), getAuthorNames(), getPublisherName());
		
	}

	private static String getPublisherName() {
		
		return "publisher"+gen.nextInt(N_PUBLISHERS);
	}

	private static Set<String> getAuthorNames() {
		Set<String> res = new LinkedHashSet<>();
		int nAuthors=1+gen.nextInt(5);
		for (int i = 0; i < nAuthors; i++) {
			res.add("Author"+gen.nextInt(N_AUTHORS));
		}
		return res;
	}

	private static float getRandomPrice() {
		return (float) (100.5+gen.nextInt(400));
	}

	private static String getRandomTitle() {
		
		return "title"+gen.nextInt(N_BOOKS);
	}

	private static void createPublishers() {
		for (int i = 0; i < N_PUBLISHERS; i++) {
			booksOrm.addPublisher(new Publisher("publisher"+i, getRandomAddress()));
		}
		
	}

	private static void createAuthors() {
		for (int i = 0; i < N_AUTHORS; i++) {
			booksOrm.addAuthor(new Author("author"+i, getRandomAddress(), getRandomYear()));
		}
		
	}

	private static int getRandomYear() {
		
		return 1940+gen.nextInt(77);
	}

	private static Address getRandomAddress() {
		return new Address("country"+gen.nextInt(N_COUNTRIES), "city"+gen.nextInt(N_CITIES));
	}
}
