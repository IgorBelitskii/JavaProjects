package tel_ran.books.controller;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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
import tel_ran.books.entities.Buyer;
import tel_ran.books.entities.Deal;
import tel_ran.books.entities.LiteratureBook;
import tel_ran.books.entities.Publisher;
import tel_ran.books.entities.TechnicalBook;

public class RandomBooksCreation {
	private static final int N_BOOKS = 100;
	private static final int N_AUTHORS = 20;
	private static final int N_CITIES = 50;
	private static final int N_PUBLISHERS = 100;
	private static final int N_DEALS = 50;
	private static final int N_BUYERS = 50;
	static Random gen=new Random();
	static BooksAuthPublishOrm booksOrm;
	private static int isbn=0;
	private static List<Buyer> buyers = new LinkedList<>();
	private static List<Book> books = new LinkedList<>();
	public static void main(String[] args) throws AuthorNotFoundException, PublisherNotFoundException {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		booksOrm = ctx.getBean(BooksAuthPublishOrm.class);
		createRandomBooks();
		createRandomBuyers();
		createRandomDeals();
		ctx.close();
	}

	private static void createRandomDeals() {
		for (int i = 0; i < N_DEALS; i++) {
			booksOrm.addDeal(new Deal(gen.nextInt(50),getRandomBirthDate(),getRandomBuyer(), getRandomBook()));
		}
		
	}

	private static Book getRandomBook() {
		return books.get(gen.nextInt(N_BOOKS));
	}

	private static Buyer getRandomBuyer() {
		return buyers.get(gen.nextInt(N_BUYERS));
	}

	private static void createRandomBuyers() {
		for (int i = 0; i < N_BUYERS; i++) {
			Buyer buyer = new Buyer(gen.nextInt(1000000),"buyer"+i, getRandomYear(),getRandomAdress(), getRandomPhoneNumber(), gerRandomEmail());
			booksOrm.addBuyer(buyer);
			buyers.add(buyer);
		}	
	}

	private static String gerRandomEmail() {
		return "mail"+gen.nextInt(100)+"@"+"domain"+gen.nextInt(500)+".co.il";
	}

	private static String getRandomPhoneNumber() {
		return "058"+gen.nextInt(100000);
	}

	private static Address getRandomAdress() {
		Address address = new Address(getRandomCity(), "Street "+gen.nextInt(200), gen.nextInt(100),"aprt"+gen.nextInt(10));
		return address;
	}

	private static void createRandomBooks() throws AuthorNotFoundException, PublisherNotFoundException {
		createAuthors();
		createPublishers();
		for(int i=0; i<N_BOOKS; i++) {
			int x = gen.nextInt(2);
			if (x==1) createRandomLiteratureBook();
			else createRandomTechnicalBook();
		} 
		
	}

	private static void createRandomTechnicalBook() throws AuthorNotFoundException, PublisherNotFoundException {
		TechnicalBook book = new TechnicalBook(++isbn,getRandomTitle(),getRandomPrice(), getRandomYear(), getRandomPages(), getRandomSubject(),getRandomEdition());
		booksOrm.addBook(book, getAuthorNames(), getPublisherName());
		books.add(book);
		
	}

	private static int getRandomEdition() {
		return gen.nextInt(5);
	}

	private static String getRandomSubject() {
		return "subject"+gen.nextInt(100);
	}

	private static void createRandomLiteratureBook() throws AuthorNotFoundException, PublisherNotFoundException {
		LiteratureBook book = new LiteratureBook(++isbn,getRandomTitle(),getRandomPrice(), getRandomYear(), getRandomPages(), getRandomGanre());
		booksOrm.addBook(book, getAuthorNames(), getPublisherName());
		books.add(book);
		
	}

	private static String getRandomGanre() {
		return "ganre"+gen.nextInt(100);
	}

	private static int getRandomPages() {
		// TODO Auto-generated method stub
		return gen.nextInt(500);
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
			booksOrm.addPublisher(new Publisher("publisher"+i, getRandomCity()));
		}
		
	}

	private static String getRandomCity() {
		return "city"+gen.nextInt(N_CITIES);
	}

	private static void createAuthors() {
		for (int i = 0; i < N_AUTHORS; i++) {
			booksOrm.addAuthor(new Author("author"+i, getRandomBirthDate()));
		}
		
	}

	private static Date getRandomBirthDate() {
		int year = 1940+gen.nextInt(77);
		int month = gen.nextInt(11);
		int day = gen.nextInt(28);
		Calendar cld = new GregorianCalendar(year, month, day);		
		Date date = cld.getTime();
		return date;
	}

	private static int getRandomYear() {
		
		return 1940+gen.nextInt(77);
	}

	/*private static Address getRandomAddress() {
		return new Address("country"+gen.nextInt(N_COUNTRIES), "city"+gen.nextInt(N_CITIES));
	}*/
}
