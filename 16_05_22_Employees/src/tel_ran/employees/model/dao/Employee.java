package tel_ran.employees.model.dao;

public class Employee {



int id;
String name;
String postition;
int basicSalary;

public Employee(int id, String name, String postition, int basicSalary) {
	
	this.id = id;
	this.name = name;
	this.postition = postition;
	this.basicSalary = basicSalary;
}


public Employee(int id) {
	this.id = id;
}


public String getPostition() {
	return postition;
}

public void setPostition(String postition) {
	this.postition = postition;
}

public int getBasicSalary() {
	return basicSalary;
}

public void setBasicSalary(int basicSalary) {
	this.basicSalary = basicSalary;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public boolean equals(Object obj) {
	
	return id==((Employee)obj).id;
}


@Override
public String toString() {
	return "id=" + id + ", name=" + name + ", postition=" + postition + ", basicSalary=" + basicSalary;
}

public int computeSallary (){
	return basicSalary;
}
}
/** Реализовать всю схему UML которую мы описали
Manager, interface,
Class имплементирующий interface  - new class (add -> interface ... add) !!!
и класс имплементирующий интерфейс
**/