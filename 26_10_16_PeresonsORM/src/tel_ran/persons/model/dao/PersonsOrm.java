package tel_ran.persons.model.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import tel_ran.persons.model.entities.Address;
import tel_ran.persons.model.entities.Person;

public class PersonsOrm {
	@PersistenceContext(unitName = "springHibernate")
	EntityManager em;

	@Transactional
	public boolean addPerson(Person person) {

		if (em.find(Person.class, person.getId()) != null) {
			return false;
		}
		em.persist(person);
		return true;

	}

	@Transactional
	public boolean updateAddress(int id, Address newAddress) {
		Person person = em.find(Person.class, id);
		if (person == null) {

			return false;
		}

		person.setAddress(newAddress);
		return true;
	}

	@Transactional
	public Person removePerson(int id) {

		Person res = em.find(Person.class, id);

		if (res != null)
			em.remove(res);
		return res;

	}

	@Transactional
	public Person getPerson(int id) {

		return em.find(Person.class, id);

	}

	public List<Person> getPersonsByMonth(int month) {

		Query query = em.createQuery(String.format("select p from Person p where month(p.birthdate) = %d", month));
		return query.getResultList();
	}

}