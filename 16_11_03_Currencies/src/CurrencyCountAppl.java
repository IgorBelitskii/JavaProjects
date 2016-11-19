import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Set;
import org.springframework.web.client.RestTemplate;

public class CurrencyCountAppl {
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://api.fixer.io/latest";
	static Currency currency;
/*
 * System.out.println("Please type: 'currencies' to know all the currencies");
			System.out.println("Please type: 'currency ILS - to know currency of Israel Sheckel");
			System.out.println("Please type: 'convert ILS RUB 100' to know how much 100 Sheckel in rubels");
			Statistic years 2016 2010 - по годам 7 значений
			среднее значение за год статистика валют
			Statistic year 2016
			определяем для конкретного вида валюты среднее значение на конкретный месяц
			12 значений - средняя по годам
			
			Строим базу данных
			с 2010 по 2016
			MongoDB
			Используем InsertMany;		
 */
	public static void main(String[] args) {
		long time0 = System.currentTimeMillis();
		currency = restTemplate.getForObject(url, Currency.class);
		long time1 = System.currentTimeMillis();
		System.out.println(time1-time0);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		while (!exit) {
			System.out.println("Please type: 'currencies' to know all the currencies");
			System.out.println("Please type: 'currency ILS - to know currency of Israel Sheckel");
			System.out.println("Please type: 'convert ILS RUB 100' to know how much 100 Sheckel in rubels");
			System.out.println("Please type 'exit' for exit");
			Date currentDate = new Date(System.currentTimeMillis());
			Date currencyDate = currency.getDate();
			System.out.println(currentDate);
			System.out.println(currencyDate);
			System.out.println((currentDate.getTime() - currencyDate.getTime()) / (1000 * 60 * 60 * 60));
			try {
				if (((currentDate.getTime() - currencyDate.getTime()) / (1000 * 60 * 60 * 60)) >= 1)
					DownloadNewCurrency();
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
				case "exit":
					exit = true;
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void DownloadNewCurrency() {
		currency = restTemplate.getForObject(url, Currency.class);
		System.out.println("Currency downloaded");
	}

	private static void convertCurrencies(String cur1, String cur2, String count) {
		double money = Double.parseDouble(count);
		System.out.println(money * (currency.getRates().get(cur2) / currency.getRates().get(cur1)));

	}

	private static void getValueOfCurrency(String string) {
		System.out.println(currency.getRates().get(string));

	}

	private static void showAllcurrencies() {
		Set<String> set = (currency.getRates()).keySet();
		for (String string : set) {
			System.out.print(string + " ");
		}
		System.out.println();
	}

}
