package tel_ran.employees.dao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import tel_ran.employees.entities.Employee;

public class EmployeesOrm {
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
	EntityManager em;

	@Transactional
	public boolean addGeneralManager(Employee employee) {
		if (employee == null)
			return false;
		employee.setManager(null);
		em.persist(employee);
		System.out.println(employee + " added as General Manager");
		return true;
	}

	@Transactional
	public boolean addEmployee(Employee employee, int managerId) {
		Employee manager = null;
		if ((employee == null) || (em.find(Employee.class, employee.getId()) != null)
				|| ((manager = em.find(Employee.class, managerId)) == null))
			return false;
		employee.setManager(manager);
		em.persist(employee);
		System.out.println(employee + " added as employee");
		return true;
	}

	public Set<Employee> getSubordinates(int id) {
		Employee employee = em.find(Employee.class, id);
		Set<Employee> result = new HashSet<>();
		if (employee != null) {
			em.refresh(employee);
			result = employee.getSubordinates();
		}
		return result;
	}

	public List<Employee> getGeneralManagers() {
		String jpql = "SELECT e FROM Employee e WHERE e.manager IS NULL";
		Query query = em.createQuery(jpql);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	public List<Employee> getLineManagers() {
		// String jpql = "SELECT DISTINCT e FROM Employee e join e.subordinates
		// f WHERE f IS NOT NULL";
		String jpql = "SELECT e FROM Employee e WHERE size(e.subordinates)>0";
		Query query = em.createQuery(jpql);
		List<Employee> employees = query.getResultList();
		List<Employee> result = new LinkedList<>();
		for (Employee employee : employees) {
			if ((employee.getManager() != null)) {
				result.add(employee);
			}
		}
		return result;
	}

	public List<Employee> getEmployees() {
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.subordinates IS EMPTY ");
		return query.getResultList();

	}

	public List<Employee> getEmployeesWithSalaryGreaterThanManager() {
		String jpql = "SELECT e FROM Employee e join e.manager m WHERE m.salary<e.salary";
		Query query = em.createQuery(jpql);
		List<Employee> employees = query.getResultList();
		/*
		 * List<Employee> result = new LinkedList<>(); for (Employee employee :
		 * employees) { if (employee.getManager() != null) { if
		 * (employee.getSalary() > employee.getManager().getSalary()) {
		 * result.add(employee); } } }
		 */
		return employees;
	}

	@Transactional
	public void deleteGeneral(int id) {
		Employee general = em.find(Employee.class, id);
		if (general != null) {
			em.remove(general);
			System.out.println("removed " + general);
		}
	}
}