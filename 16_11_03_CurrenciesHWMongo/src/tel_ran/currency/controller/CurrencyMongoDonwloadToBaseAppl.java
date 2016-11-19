package tel_ran.currency.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import tel_ran.currency.entities.Currency;
import tel_ran.currency.model.dao.CurrencyMongoDB;

public class CurrencyMongoDonwloadToBaseAppl {
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://api.fixer.io/latest";
	static Currency currency;
	static CurrencyMongoDB currenciesMongo;

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		currenciesMongo = ctx.getBean(CurrencyMongoDB.class);
		Calendar from = new GregorianCalendar(2016, 10, 1);
		Calendar to = new GregorianCalendar(2016, 10, 3);
		List<Currency> currencies = new LinkedList<>();
		while ((from.getTime()).getTime() <= (to.getTime()).getTime()) {
			Currency cur = restTemplate.getForObject("http://api.fixer.io/" + getDate(from.getTime()), Currency.class);
			cur.setDate(from.getTime());
			System.out.println(cur);
			currencies.add(cur);
			from.add(Calendar.DATE, 1);
		}
		currenciesMongo.addCurrencies(currencies);

		Calendar from1 = new GregorianCalendar(2016, 10, 01);
		Calendar to1 = new GregorianCalendar(2016, 10, 04);
		Iterable<Currency> currenciesFrom = getCurrenciesFrom(from1, to1);
		for (Currency currency : currenciesFrom) {
			System.out.println(currency);
		}
		ctx.close();
	}

	private static String getDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(calendar.getTime());
		System.out.println(currentDate);
		return currentDate;
	}

	private static Iterable<Currency> getCurrenciesFrom(Calendar from1, Calendar to1) {
		from1.add(Calendar.DATE, -1);
		to1.add(Calendar.DATE, 1);
		return currenciesMongo.getCurrencies(from1.getTime(), to1.getTime());
	}

}
