
public class AccountData {

	String username;
	String password;
	String[] roles;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String[] getRoles() {
		return roles;
	}
	public AccountData(String username, String password, String[] roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public AccountData() {
		super();
	}
	
	
}
