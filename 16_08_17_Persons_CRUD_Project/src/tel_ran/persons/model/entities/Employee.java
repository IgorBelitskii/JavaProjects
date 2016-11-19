package tel_ran.persons.model.entities;

public class Employee extends Person {
String company;
int salary;

public Employee(String company, int salary) {
	super();
	this.company = company;
	this.salary = salary;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [company=" + company + ", salary=" + salary + ", id=" + id + ", name=" + name + ", birthYear="
			+ birthYear + ", adress=" + adress + "]";
}



}
