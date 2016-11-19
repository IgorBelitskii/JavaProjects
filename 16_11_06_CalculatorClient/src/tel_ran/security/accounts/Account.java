package tel_ran.security.accounts;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="accounts")
public class Account {
@Id
String username;
String password;
String[] roles;
public Account(String username, String password, String[] roles) {
	super();
	this.username = username;
	this.password = password;
	this.roles = roles;
}
public Account() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public String getPassword() {
	return password;
}
public String[] getRoles() {
	return roles;
}

}
