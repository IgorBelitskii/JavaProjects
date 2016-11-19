package tel_ran.currency.repo;

import org.springframework.data.repository.CrudRepository;

import tel_ran.currency.entities.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

	Iterable<Currency> findByTimeBetweenOrderByTime(long time, long time2);

}
