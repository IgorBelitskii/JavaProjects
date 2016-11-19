package tel_ran.books.dao;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import tel_ran.books.entities.Author;
import tel_ran.books.entities.Book;
import tel_ran.books.entities.Buyer;
import tel_ran.books.entities.Deal;
import tel_ran.books.entities.Publisher;

public class BooksAuthPublishOrm {
	@PersistenceContext(unitName = "springHibernate", type=PersistenceContextType.EXTENDED)
	EntityManager em;

	@Transactional
	public boolean addAuthor(Author author) {
		if ((author == null) || (em.find(Author.class, author.getName()) != null))
			return false;
		em.persist(author);
		return true;
	}

	@Transactional
	public boolean addPublisher(Publisher publisher) {
		if ((publisher == null) || em.find(Publisher.class, publisher.getName()) != null)
			return false;
		em.persist(publisher);
		return true;
	}

	@Transactional
	public boolean addBook(Book book, Set<String> authorNames, String publisherName) throws AuthorNotFoundException, PublisherNotFoundException {
	/*	if (em.find(Book.class, book.getIsbn()) != null)
			return false;*/
		Set<Author> authors = getAuthors(authorNames);
		Publisher publisher = getPublisher(publisherName);
		book.setAuthors(authors);
		book.setPublisher(publisher);
		em.persist(book);
		return true;

	}

	private Set<Author> getAuthors(Set<String> authorNames) throws AuthorNotFoundException {
		Set<Author> result = new LinkedHashSet<>();
		for (String name : authorNames) {
			Author author = em.find(Author.class, name);
			if (author != null)
				result.add(author);
			else
				throw new AuthorNotFoundException(name);
		}
		return result;
	}

	private Publisher getPublisher(String publisherName) throws PublisherNotFoundException {
		Publisher result = em.find(Publisher.class, publisherName);
		if (result == null)
			throw new PublisherNotFoundException(publisherName);
		return result;
	}

	@Transactional
	public boolean addBuyer(Buyer buyer) {
		if (buyer==null)
			return false;
		em.persist(buyer);
		System.out.println("Buyer added"+  buyer.toString());
		return true;
		
		
	}
	@Transactional
	public void addDeal(Deal deal) {
		em.persist(deal);
		
	}

}
