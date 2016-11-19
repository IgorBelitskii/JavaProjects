package tel_ran.personproducts.dao;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import tel_ran.personproducts.entities.Person;
import tel_ran.personproducts.entities.Product;

public class PersonProductOrm {
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
	EntityManager em;


	@Transactional
	public boolean addPerson(Person person) {
		if ((person == null) || (em.find(Person.class, person.getId()) != null))
			return false;
		em.persist(person);
		return true;
	}
	
	@Transactional
	public boolean addProduct(Product product) {
		if ((product == null) || (em.find(Product.class, product.getBarcode()) != null))
			return false;
		em.persist(product);
		return true;
	}
	
	@Transactional
	public boolean setOwnership(long id, List<Long> barCodes) {
		Person person = em.find(Person.class, id);
		if (person==null) return false;
		List<Product> products = new LinkedList<>();
		products = person.getProducts();
		for (Long long1 : barCodes) {
			Product product = em.find(Product.class, long1);
			if (product!=null) products.add(product);
		}
		person.setProducts(products);
		em.persist(person);
	return true;
	}

	@Transactional
	public boolean setRentship(long id, List<Long> barCodes) {
		Person person = em.find(Person.class, id);
		if (person==null) return false;
		List<Product> rents = new LinkedList<>();
		rents = person.getRents();
		for (Long long1 : barCodes) {
			Product product = em.find(Product.class, long1);
			if (product!=null) rents.add(product);
		}
		person.setRents(rents);
		em.persist(person);
	return true;
	}
	
	public List<Person> getOwners(long barcode) {
		Product product = em.find(Product.class, barcode);
		if (product!=null) return product.getPersons();
	return null;
	}
	
	public List<Product> getOwnedProducts(long id) {
		Person person = em.find(Person.class, id);
		if (person!=null) return person.getProducts();
	return null;
	}
	
	public List<Person> getRentees(long barcode) {
		Product product = em.find(Product.class, barcode);
		if (product!=null) return product.getPersonsRent();
	return null;
	}
	
	public List<Product> getRentedProducts(long id) {
		Person person = em.find(Person.class, id);
		if (person!=null) return person.getRents();
	return null;
	}
	
}
