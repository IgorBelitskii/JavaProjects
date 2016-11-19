package tel_ran.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="accounts")

public class Account {
	@Id
	String userName; // ключ
	String password;
	String role;

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	public Account(){
		super();
	}
	public Account(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return userName;
	}
}
