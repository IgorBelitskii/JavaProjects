package tel_ran.personproducts.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.personproducts.dao.PersonProductOrm;
import tel_ran.personproducts.entities.Person;
import tel_ran.personproducts.entities.Product;

public class PersonProductCreationsAppl {
	private static final int N_Persons = 10;
	private static final int N_Products = 10;
	static Random gen = new Random();
	static PersonProductOrm personProductOrm;
	static List<Long> productsList = new LinkedList<>();

	public static void main(String[] args) {
		try (AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");) {
			personProductOrm = ctx.getBean(PersonProductOrm.class);
			createRandomPersonProducts();
		}
	}

	private static void createRandomPersonProducts() {
		createProducts();
		for (int i = 0; i < N_Persons; i++) {
			createRandomPerson();
		}
	}

	private static void createRandomPerson() {
		String[] colors = { "Igor", "Vasya", "Kolya", "Lionya", "Sanya" };
		Long id = gen.nextLong();
		String name = colors[gen.nextInt(5)] + gen.nextInt(100);
		Person person = new Person(id, name);
		personProductOrm.addPerson(person);
		List<Long> barcodes = new LinkedList<>();
		for (int i = 0; i < gen.nextInt(5); i++) {
			barcodes.add(productsList.get(gen.nextInt(productsList.size())));
		}
		personProductOrm.setOwnership(id, barcodes);
		List<Long> barcodes2 = new LinkedList<>();
		for (int i = 0; i < gen.nextInt(5); i++) {
			barcodes2.add(productsList.get(gen.nextInt(productsList.size())));
		}
		personProductOrm.setRentship(id, barcodes2);
	}

	private static void createProducts() {
		String[] models = { "PHILIPS", "SONY", "PANASONIC", "LG", "Samsung" };
		for (int i = 0; i < N_Products; i++) {
			int n = gen.nextInt(5);
			long m = gen.nextLong();
			productsList.add(m);
			personProductOrm.addProduct(new Product(m, models[n]));
		}
	}

}
