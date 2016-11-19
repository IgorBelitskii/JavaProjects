package tel_ran.currency.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tel_ran.security.accounts.Account;
import tel_ran.security.accounts.repo.AccountsRepository;

@Configuration
public class CurrencyAuthentication implements UserDetailsService {
@Autowired
AccountsRepository accounts;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account=accounts.findOne(username);
		
		if (account==null) throw new UsernameNotFoundException("wrong user name");
		return new User(username,account.getPassword(),AuthorityUtils.createAuthorityList(account.getRoles()));
	}
// ROLE USER - роль по умолчанию
}
