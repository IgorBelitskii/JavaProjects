import java.util.Base64;
import java.util.LinkedList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import tel_ran.currency.api.CurrencyRequest;
import tel_ran.currency.api.CurrencyStatisticsRequest;
import tel_ran.security.accounts.Account;
public class CurrencyTestAppl {
static final String URL="http://localhost:8080/";
static RestTemplate restTemplate= new RestTemplate();
	public static void main(String[] args) {
		CurrencyRequest requestBody = new CurrencyRequest("USD", "ILS", 1500);
		HttpHeaders headers = new HttpHeaders();
		String token="admin:12345.com";
		String authToken=Base64.getEncoder().encodeToString(token.getBytes());
		headers.add("Authorization", "Basic "+authToken);
		HttpHeaders headersBroker = new HttpHeaders();
		String tokenBroker="broker:broker";
		String authTokenBroker=Base64.getEncoder().encodeToString(tokenBroker.getBytes());
		headersBroker.add("Authorization", "Basic "+authTokenBroker);
		HttpEntity <CurrencyRequest> request = new HttpEntity<>(requestBody, headersBroker);
		double res= restTemplate.postForObject(URL+"convertPost", request, Double.class);
		System.out.println(res);
		
		CurrencyStatisticsRequest request1 = new CurrencyStatisticsRequest("USD","2010","2016");
		HttpEntity <CurrencyStatisticsRequest> request2 = new HttpEntity<>(request1, headersBroker);
		
		@SuppressWarnings("unchecked")
		Iterable<String> result= restTemplate.postForObject(URL+"statisticsPost", request2, LinkedList.class);
		for (String string : result) {
			System.out.println(string);
		}
		String[] arrString = {"ROLE_BROKER"};
		Account newUser = new Account("superbroker1","broker", arrString);
		HttpEntity <Account> requestAccount = new HttpEntity<>(newUser, headers);
		restTemplate.put(URL+"account", requestAccount);
		
	}

}
