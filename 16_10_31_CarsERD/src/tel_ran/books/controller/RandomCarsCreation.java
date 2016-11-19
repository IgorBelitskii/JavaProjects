package tel_ran.books.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tel_ran.cars.dao.CarsOrm;
import tel_ran.cars.entities.Car;
import tel_ran.cars.entities.Model;
import tel_ran.cars.entities.Owner;

public class RandomCarsCreation {
	private static final int N_CARS = 100;
	private static final int N_OWNERS = 20;
	private static final int N_MODELS = 10;
	static Random gen = new Random();
	static CarsOrm carsOrm;
	static List<String> modelNames = new LinkedList<>();

	public static void main(String[] args) {

		try (AbstractApplicationContext ctx = 
				new FileSystemXmlApplicationContext("beans.xml");)
		{
			carsOrm = ctx.getBean(CarsOrm.class);
			createRandomCars();
		}
	}

	private static void createRandomCars() {
		createOwners();
		createModels();
		for (int i = 0; i < N_CARS; i++) {
			createRandomCar();
		}
	}

	private static void createRandomCar() {
		String[] colors = { "RED", "GREEN", "BLUE", "BLACK", "WHITE" };
		List<Integer> ownerIds = new LinkedList<>();
		for (int i = 0; i < gen.nextInt(5); i++) {
			ownerIds.add(carsOrm.getOwner(gen.nextInt(N_OWNERS)).getId());
		}
		Car car = new Car();
		String color = colors[gen.nextInt(5)];
		car.setRegNumber(gen.nextLong());
		car.setColor(color);
		String modelName = modelNames.get(gen.nextInt(N_MODELS));
		carsOrm.addCar(car, ownerIds, modelName);
	}

	private static void createModels() {
		String[] models = { "MAZDA", "MITSUBISHI", "RENAULT", "CITROEN", "BMW", "MERCEDES", "PORSCHE", "AUDI", "HONDA",
				"HUINDAI", "FORD" };
		for (int i = 0; i < N_MODELS; i++) {
			int m = gen.nextInt(11);
			modelNames.add("ModelName" + i);
			carsOrm.addModel(new Model("ModelName" + i, models[m], 1000 + gen.nextInt(2000), getRandomCarYear()));
		}

	}

	private static void createOwners() {
		for (int i = 0; i < N_OWNERS; i++) {
			carsOrm.addOwner(new Owner(i, "owner" + i, getRandomCity(), getRandomYear()));
		}

	}

	private static String getRandomCity() {
		String[] cities = { "Tel-Aviv", "Jerusalem", "Haifa", "Beer-Sheva", "Rehovot", "Eilat" };
		int j = gen.nextInt(6);
		return cities[j];
	}

	private static int getRandomYear() {

		return 1940 + gen.nextInt(77);
	}

	private static int getRandomCarYear() {

		return 2000 + gen.nextInt(17);
	}
}
