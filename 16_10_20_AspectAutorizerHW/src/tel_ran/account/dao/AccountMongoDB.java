package tel_ran.account.dao;

import org.springframework.beans.factory.annotation.Autowired;

import tel_ran.entities.Account;
import tel_ran.users.repo.UsersRepository;

public class AccountMongoDB {

	public AccountMongoDB() {
		super();
	}

	public AccountMongoDB(UsersRepository accounts) {
		super();
		this.accounts = accounts;
	}

	@Autowired
	UsersRepository accounts;

	public boolean addAccount(Account account) {

		if (account == null || accounts.exists(account.getId()))
			return false;
		accounts.save(account);
		return true;
	}

	public Iterable<Account> getAllAccounts() {
		return accounts.findAll();
	}

	public boolean removeAccount(String username) {
		if (!accounts.exists(username))
			return false;
		accounts.delete(username);
		return true;
	}

	public Account getAccount(String username) {
		return accounts.findOne(username);
	}

	public String getRole(String id, String password) {
		Account acc = accounts.findOne(id);
		if (acc != null) {
			if ((acc.getPassword()).equals(password))
				return acc.getRole();
		}
		return null;

	}

}
