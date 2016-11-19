package tel_ran.currency.model.dao;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import tel_ran.currency.entities.Currency;
import tel_ran.currency.repo.CurrencyRepository;

public class CurrencyMongoDB {

	@Autowired
	CurrencyRepository currencies;

	public boolean addCurrency(Currency currency) {

		if (currency == null || currencies.exists(currency.getTime()))
			return false;
		currencies.save(currency);
		return true;
	}

	public boolean addCurrencies(Iterable<Currency> currencies) {
		/*
		 * for (Currency currency2 : currencies) { if (currency2 == null ||
		 * (this.currencies).exists(currency2.getTime())) return false; }
		 */
		this.currencies.save(currencies);
		return true;
	}

	public Iterable<Currency> getAllCurrencies() {
		return currencies.findAll();
	}

	public Iterable<Currency> getCurrencies(Date from, Date to) {
		return currencies.findByTimeBetweenOrderByTime(from.getTime(), to.getTime());

	}

	public boolean removeCurrency(long date) {
		if (!currencies.exists(date))
			return false;
		currencies.delete(date);
		return true;
	}

	public Currency getCurrency(long date) {
		return currencies.findOne(date);
	}

}
