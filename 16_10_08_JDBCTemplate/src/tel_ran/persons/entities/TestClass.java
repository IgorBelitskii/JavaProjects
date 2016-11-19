package tel_ran.persons.entities;

public class TestClass {
int number;
String name;
int plus;
public int getNumber() {
	return number;
}
public String getName() {
	return name;
}
public int getPlus() {
	return plus;
}
public TestClass(int number, String name, int plus) {
	super();
	this.number = number;
	this.name = name;
	this.plus = plus;
}
@Override
public String toString() {
	return "TestClass [number=" + number + ", name=" + name + ", plus=" + plus + "]";
}
public TestClass() {
	super();
	// TODO Auto-generated constructor stub
}

}
