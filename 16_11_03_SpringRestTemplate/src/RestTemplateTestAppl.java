import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTestAppl {
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://api.fixer.io/latest";

	public static void main(String[] args) {
		// String json = restTemplate.getForObject(url, String.class);
		// Map<String, Object> json = restTemplate.getForObject(url, Map.class);
		Currency currency = restTemplate.getForObject(url, Currency.class);
		HttpEntity<Map<String, Object>> map = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<Map<String, Object>>() {
				});
		// Map<String, Object> json = restTemplate.getForObject(url, new
		// TypeReference<Map<String,Object>>(){});
		System.out.println(currency);
		System.out.println(currency.getRates().get("ILS")/currency.getRates().get("USD"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// Запрос все названия валют которые есть
		// Дать значение кол-ва единиц данной валюты в 1 Евро
		// Преобразуй 
		// наимнование запроса, пробел данные
		// currencies
		// currency ILS  - > курс шекеля
		// convert ILS RUB 100
		while(true) {
			System.out.println("Please type: 'currencies' to know all the currencies");
			System.out.println("Please type: 'currency ILS - to know currency of Israel Sheckel");
			System.out.println("Please type: 'convert ILS RUB 100' to know how much 100 Sheckel in rubels");
			System.out.println("Please type 'exit' for exit");
		}	
	}

	private static Date getDate(Map<String, Object> json) {
		return (Date) json.get("date");
	}

	private static double getValue(String currency, Map<String, Object> json) {
		Map<String, Double> rates = (Map<String, Double>) json.get("rates");
		Double result = rates.get(currency);
		return result == null ? 0 : result;
		// return (double)((Map)json.get("rates")).get(string);
	}

}
/**
 * private static double getCurrencyValue(String string, Currency json)
 * { @SuppressWarnings("unchecked") Map<String,Double> rates=(Map<String,
 * Double>) json.get("rates"); return rates.get(string); }
 **/
