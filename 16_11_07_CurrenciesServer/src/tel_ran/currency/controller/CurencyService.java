package tel_ran.currency.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tel_ran.currency.api.CurrencyRequest;
import tel_ran.currency.api.CurrencyStatisticsRequest;
import tel_ran.currency.entities.Currency;
import tel_ran.currency.model.dao.CurrencyMongoDB;
import tel_ran.security.accounts.Account;
import tel_ran.security.accounts.repo.AccountsRepository;

@RestController
@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class CurencyService {
	@Autowired
	AccountsRepository accounts;
	@RequestMapping(value="account", method=RequestMethod.PUT)
	public void addAccount(@RequestBody Account account) {
		accounts.save(account);
	}
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://api.fixer.io/latest";
	@Autowired
	CurrencyMongoDB currenciesMongo;
	Currency currency;
	long time = new GregorianCalendar(2016, 10, 3).getTimeInMillis();

	@RequestMapping(value = "statistics")
	public Iterable<String> statisticforYears(String money, String yearFrom, String yearTo) {
		Collection<String> res = new LinkedList<>();
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
				if (average != 0) {
					String prn = "Average for " + money + " in Year " + year + " =" + average;
					System.out.println(prn);
					res.add(prn);
				} else {
					String prn = "There is no data for " + money + " in Year " + year;
					System.out.println(prn);
					res.add(prn);
				}
			}
		}
		return res;
	}

	@RequestMapping(value = "statisticsPost", method = RequestMethod.POST)
	public Iterable<String> statisticforYearsPost(@RequestBody CurrencyStatisticsRequest request) {

		String money = request.getMoney();
		String yearFrom = request.getYearFrom();
		String yearTo = request.getYearTo();
		LinkedList<String> res = (LinkedList<String>) statisticforYears(money, yearFrom, yearTo);
		return res;
	}

	@RequestMapping(value = "statistic")
	public Iterable<String> statisticforOneYear(String money, String year) {
		int yearInt = Integer.parseInt(year);
		Collection<String> res = new LinkedList<>();
		if (money.equals("EUR"))
			System.out.println("Average for EUR = 1");
		else {
			for (int i = 0; i <= 11; i++) {
				Calendar from = new GregorianCalendar(yearInt, i, 01);
				Calendar to = new GregorianCalendar(yearInt, i, 01);
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
				if (average != 0) {
					String resplus = "Average for " + money + " in Year " + yearInt + " in Month " + (i + 1) + " ="
							+ average;
					res.add(resplus);
					System.out.println(resplus);
				} else {
					String resplus = "There is no data for " + money + " in Year " + yearInt + " in Month " + (i + 1);
					res.add(resplus);
					System.out.println(resplus);
				}
			}
		}
		return res;
	}

	@RequestMapping(value = "convertPost", method = RequestMethod.POST)
	public double convertCurrenciesPost(@RequestBody CurrencyRequest request) {
		double money = request.getCount();
		String count=""+money;
		String cur1 = request.getCur1();
		String cur2 = request.getCur2();
		double res = convertCurrencies(cur1, cur2, count);
		return res;

	}

	@RequestMapping(value = "convert")
	public double convertCurrencies(String cur1, String cur2, String count) {
		currency = currenciesMongo.getCurrency(time);
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
		double res = money * (x2 / x1);
		System.out.println(res);
		return res;

	}

	@RequestMapping(value = "get")
	public void getValueOfCurrency(String money) {
		if (money.equals("EUR"))
			System.out.println("1");
		else
			System.out.println(currency.getRates().get(money));

	}

	@RequestMapping(value = "showall")
	public String showAllcurrencies() {
		currency = currenciesMongo.getCurrency(time);
		System.out.println(time);
		Set<String> set = (currency.getRates()).keySet();
		String res = "";
		for (String string : set) {
			System.out.print(string + " ");
			res += string + " ";
		}
		System.out.println("EUR");
		res += " EUR";
		return res;
	}

	public Iterable<Currency> getCurrenciesFrom(Calendar from1, Calendar to1) {
		from1.add(Calendar.DATE, -1);
		to1.add(Calendar.DATE, 1);
		return currenciesMongo.getCurrencies(from1.getTime(), to1.getTime());
	}

	public static void main(String[] args) {
		SpringApplication.run(CurencyService.class, args);
	}
}
