package tel_ran.currency.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import tel_ran.currency.entities.Currency;
import tel_ran.currency.model.dao.CurrencyMongoDB;

public class CurrencyBaseReaderConsoleAppl {
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://api.fixer.io/latest";
	static Currency currency;
	static CurrencyMongoDB currenciesMongo;
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		currenciesMongo = ctx.getBean(CurrencyMongoDB.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		long time = new GregorianCalendar(2016, 10, 3).getTimeInMillis();
		currency = currenciesMongo.getCurrency(time);
		System.out.println(currency);
		while (!exit) {
			System.out.println("Please type: 'currencies' to know all the currencies");
			System.out.println("Please type: 'currency ILS - to know currency of Israel Sheckel");
			System.out.println("Please type: 'convert ILS RUB 100' to know how much 100 Sheckel in rubels");
			System.out.println("Please type: 'statistic ILS 2010' to know average cost fo ILS for all month 2010 year");
			System.out.println(
					"Please type: 'statistics ILS 2010 2015' to know average cost fo ILS for all years from 2010 to 2015");
			System.out.println("Please type 'exit' for exit");
			try {
				String line = reader.readLine();
				String[] arg = line.split(" ");

				switch (arg[0]) {
				case "currencies":
					showAllcurrencies();
					break;
				case "currency":
					getValueOfCurrency(arg[1]);
					break;
				case "convert":
					convertCurrencies(arg[1], arg[2], arg[3]);
					break;
				case "statistic":
					statisticforOneYear(arg[1], arg[2]);
					break;
				case "statistics":
					statisticforYears(arg[1], arg[2], arg[3]);
					break;
				case "exit":
					exit = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Wrong command");
			}
		}
		ctx.close();
	}

	private static void statisticforYears(String money, String yearFrom, String yearTo) {
		if (money.equals("EUR"))
			System.out.println("Average for EUR = 1");
		else {

			int yearF = Integer.parseInt(yearFrom);
			int yearT = Integer.parseInt(yearTo);
			for (int year = yearF; year <= yearT; year++) {
				Calendar from = new GregorianCalendar(year, 0, 01);
				Calendar to = new GregorianCalendar(year, 11, 31);
				Iterable<Currency> iterable = getCurrenciesFrom(from, to);
				int count = 0;
				double average = 0;
				double t = 0;
				for (Currency currency : iterable) {
					try {
						t = currency.getRates().get(money);
					} catch (Exception e) {
						t = 0;
					}
					average += t;
					count++;
				}
				average /= count;
				if (average != 0)
					System.out.println("Average for " + money + " in Year " + year + " =" + average);
				else
					System.out.println("There is no data for " + money + " in Year " + year);
			}
		}
	}

	private static void statisticforOneYear(String money, String yearStr) {
		int year = Integer.parseInt(yearStr);
		if (money.equals("EUR"))
			System.out.println("Average for EUR = 1");
		else {
			for (int i = 0; i <= 11; i++) {
				Calendar from = new GregorianCalendar(year, i, 01);
				Calendar to = new GregorianCalendar(year, i, 01);
				to.add(Calendar.MONTH, 1);
				to.add(Calendar.DATE, -1);
				Iterable<Currency> iterable = getCurrenciesFrom(from, to);
				int count = 0;
				double average = 0;
				double t = 0;
				for (Currency currency : iterable) {
					try {
						t = currency.getRates().get(money);
					} catch (Exception e) {
						t = 0;
					}
					average += t;
					count++;
				}
				average /= count;
				// System.out.println(count);
				if (average != 0)
					System.out.println(
							"Average for " + money + " in Year " + year + " in Month " + (i + 1) + " =" + average);
				else
					System.out.println("There is no data for " + money + " in Year " + year + " in Month " + (i + 1));
			}
		}
	}

	private static void convertCurrencies(String cur1, String cur2, String count) {
		double money = Double.parseDouble(count);
		Double x1, x2;
		if (cur1.equals("EUR"))
			x1 = 1D;
		else
			x1 = currency.getRates().get(cur1);
		if (cur2.equals("EUR"))
			x2 = 1D;
		else
			x2 = currency.getRates().get(cur2);

		System.out.println(money * (x2 / x1));

	}

	private static void getValueOfCurrency(String string) {
		if (string.equals("EUR"))
			System.out.println("1");
		else
			System.out.println(currency.getRates().get(string));

	}

	private static void showAllcurrencies() {
		Set<String> set = (currency.getRates()).keySet();
		for (String string : set) {
			System.out.print(string + " ");
		}
		System.out.println("EUR");
	}

	private static Iterable<Currency> getCurrenciesFrom(Calendar from1, Calendar to1) {
		from1.add(Calendar.DATE, -1);
		to1.add(Calendar.DATE, 1);
		return currenciesMongo.getCurrencies(from1.getTime(), to1.getTime());
	}

}
