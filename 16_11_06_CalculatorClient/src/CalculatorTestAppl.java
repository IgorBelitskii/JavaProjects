import static tel_ran.calculator.api.UrlConstants.*;

import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import tel_ran.calculator.api.*;
import tel_ran.security.accounts.Account;
public class CalculatorTestAppl {
static final String URL="http://localhost:8080/";
static RestTemplate restTemplate= new RestTemplate();
	public static void main(String[] args) {
		CalculateRequest requestBody = new CalculateRequest(10.5,3.5,"+");
	/*	CalculateRequest request = new CalculateRequest(10.5,0,"/");
		double res= restTemplate.postForObject(URL+CALCULATE, request, Double.class);
		System.out.println(res);*/
		HttpHeaders headers = new HttpHeaders();
		String token="admin:admin";
		String authToken=Base64.getEncoder().encodeToString(token.getBytes());
	/*	String token2 = new String(Base64.getDecoder().decode(authToken));
		System.out.println(token2);*/
		headers.add("Authorization", "Basic "+authToken);
		HttpEntity <CalculateRequest> request = new HttpEntity<>(requestBody, headers);
		ResponseEntity<Double> response= restTemplate.exchange(URL+CALCULATE, HttpMethod.POST, request, Double.class);
		System.out.println(response.getBody());
		HttpEntity<String> requestGet = new HttpEntity<>(headers);
		ResponseEntity<List<String>> responseOperations = restTemplate.exchange(URL+OPERATIONS, HttpMethod.GET, requestGet, 
				new ParameterizedTypeReference<List<String>>(){	});
		System.out.println(responseOperations.getBody());
	/*	Map<String,String> parameters = new LinkedHashMap<>();
		parameters.put("op1", "2.5");
		parameters.put("op2", "2.5");
		parameters.put("operation", "*");*/
		response=restTemplate.exchange(URL+GET_CALCULATE+"?op1=2.5&op2=2.5&operation=*", HttpMethod.GET, requestGet, Double.class);
		System.out.println(response.getBody());
		HttpHeaders headers1 = new HttpHeaders();
		String token1="supervisor:rules";
		String authToken1=Base64.getEncoder().encodeToString(token1.getBytes());
	/*	String token2 = new String(Base64.getDecoder().decode(authToken));
		System.out.println(token2);*/
		headers1.add("Authorization", "Basic "+authToken1);
		String[] arrString = {"ROLE_USER"};
		AccountData newUser = new AccountData("supervisor1","rules1", arrString);
		HttpEntity <AccountData> requestPut = new HttpEntity<>(newUser, headers1);
		restTemplate.put(URL+"account", requestPut);
		
	}

}
