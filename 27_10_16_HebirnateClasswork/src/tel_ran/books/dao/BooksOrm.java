package tel_ran.books.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import tel_ran.books.entity.Book;

public class BooksOrm {

	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	@Transactional
	public boolean addBook(Book book) {

		if (em.find(Book.class, book.getId()) != null) {
			return false;
		}
		em.persist(book);
		return true;

	}
}
