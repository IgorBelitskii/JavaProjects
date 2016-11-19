package tel_ran.persons.client;

import java.util.Date;
import static tel_ran.persons.api.PersonsConstants.*;
import org.springframework.web.client.RestTemplate;

import tel_ran.persons.client.api.ChildData;
import tel_ran.persons.client.api.EmployeeData;

public class PersonsOrmClient {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		final String URL = "http://localhost:8080/";
		EmployeeData empl = new EmployeeData(1233, "Lior", new Date(), "Rehovot", "Plaut", 10, "Tel-Ran", 10000);
		ChildData child = new ChildData(1244, "Avital", new Date(), "Beer Sheva" , "Yaalim", 3, "49");
		String res = restTemplate.postForObject(URL+ADD_PERSON, empl, String.class);
		System.out.println(res);
		res = restTemplate.postForObject(URL+ADD_PERSON, child, String.class);
		System.out.println(res);
	}

}
