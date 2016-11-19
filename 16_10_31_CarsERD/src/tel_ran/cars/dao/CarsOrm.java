package tel_ran.cars.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;
import tel_ran.cars.entities.Car;
import tel_ran.cars.entities.Model;
import tel_ran.cars.entities.Owner;

public class CarsOrm {
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
	EntityManager em;

	@Transactional
	public boolean addOwner(Owner owner) {
		if ((owner == null) || (em.find(Owner.class, owner.getId()) != null))
			return false;
		em.persist(owner);
		return true;
	}

	@Transactional
	public boolean addCar(Car car, List<Integer> ownerIds, String modelName) {
		if ((car == null) || em.find(Car.class, car.getRegNumber()) != null)
			return false;
		Set<Owner> owners = new HashSet<>();
		for (Integer ownerId : ownerIds) {
			Owner own1 = em.find(Owner.class, ownerId);
			if (own1 != null)
				owners.add(own1);
		}
		car.setOwners(owners);
		car.setModel(this.getModel(modelName));
		em.persist(car);
		return true;
	}

	@Transactional
	public boolean addModel(Model model) {
		if ((model == null) || em.find(Model.class, model.getModelName()) != null)
			return false;
		em.persist(model);
		return true;
	}

	@Transactional
	public boolean updateOwners(long regNumber, Set<Integer> ownerIds) {
			Car car = em.find(Car.class, regNumber);
			if (car==null) return false;
			Set<Owner> owners = new HashSet<>();
			for (Integer ownerId : ownerIds) {
				Owner own1 = em.find(Owner.class, ownerId);
				if (own1 != null)
					owners.add(own1);
			}
			car.setOwners(owners);
			em.persist(car);
		return true;
	}

	public Owner getOwner(int id) {
		Owner owner = em.find(Owner.class,id);
		return owner;	
	}
	
	public Model getModel(String modelName) {
		Model model = em.find(Model.class, modelName);
		return model;	
	}

}
