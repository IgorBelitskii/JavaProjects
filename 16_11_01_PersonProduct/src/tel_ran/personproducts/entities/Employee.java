package tel_ran.personproducts.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {
@Id
int id;
String name;
int salary;
@ManyToOne
Employee manager;

@OneToMany(mappedBy="manager")
Set<Employee> subordinates;

}
