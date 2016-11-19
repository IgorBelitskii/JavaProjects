package tel_ran.orm.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.personproducts.dao.PersonProductOrm;
import tel_ran.personproducts.entities.Person;
import tel_ran.personproducts.entities.Product;

public class OrmTest {
	private static final int N_Persons = 10;
	private static final int N_Products = 10;
	static Random gen = new Random();
	static PersonProductOrm personProductOrm;
	static List<Long> productsList = new LinkedList<>();

	@Before
	public void setUp() throws Exception {
		
			try {
				AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
				personProductOrm = ctx.getBean(PersonProductOrm.class);
		//		createRandomPersonProducts();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	@Test
	public void addPerson() {
		Person person = new Person(613L, "Moshe");
		Product product = new Product(613L, "TorahMiktav");
		Product product2 = new Product(613613L, "ToraBaalPe");
		List<Product> products = new ArrayList<>();
		products.add(product);
		person.setProducts(products);
		personProductOrm.addProduct(product);
		personProductOrm.addPerson(person);
		personProductOrm.addProduct(product2);
		List<Long> barcodes = new ArrayList<>();
		barcodes.add(product2.getBarcode());
		personProductOrm.setOwnership(person.getId(), barcodes);
		List<Product> pr= personProductOrm.getOwnedProducts(person.getId());
		assertTrue(pr.size()==2);
		assertTrue(pr.contains(product));
		assertTrue(pr.contains(product2));
		
		

		// fail("Not yet implemented");
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
