package tel_ran.books.controller;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tel_ran.books.dao.BooksAuthPublishOrm;
import tel_ran.books.entities.Book;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
@RestController

public class BooksOrmService {
	private static final String PACKAGE_PERSON = "tel_ran.persons.model.entities.";
	@Autowired
	BooksAuthPublishOrm booksOrm;

/*	@RequestMapping(value = ADD_PERSON, method=RequestMethod.POST)
	public String addPerson(@RequestBody Map<String, Object> data) {
		String type = (String) data.get(TYPE);
		if (type == null)
			return "Type missing";
		try {
			Person person = (Person) Class.forName(PACKAGE_PERSON+type).newInstance();
			try {
				person.setData(data);
			} catch (Exception e) {
				return e.getMessage();
			}
			boolean res = booksOrm.addPerson(person);
			if(res==false) return "Not adding - person exists";
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return "Wrong Type of Persons "+type;
		}
		return "Success";		
	}

	@RequestMapping(value=UPDATE_ADDRESS)
	public String updateAdress(@RequestBody IdAddress idAddress) {
	boolean res=booksOrm.updateAddress(idAddress.getId(), 
			new Address(idAddress.getCity(), idAddress.getStreet(), idAddress.getBld()));
		return res?"update success":"person not found with id:"+idAddress.getId();
	}*/
	@RequestMapping(value="getAllBooks")
	public String getBooks() {	
		return booksOrm.getAllBooks();
	}
	
	@RequestMapping(value="getAllAuthors")
	public String getAuthors() {	
		return booksOrm.getAllAuthors();
	}
	@RequestMapping(value="getBooksFromYear")
	public String getBooksFromYear(int year) {
		return booksOrm.getBooksFromYear(year);
	}
	@RequestMapping(value="getBooksBetweenYears") 
	public String getBooksBetweenYears(int yearFrom, int yearTo) {
		return booksOrm.getBooksBetweenYears(yearFrom, yearTo);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BooksOrmService.class, args);
	}
}
