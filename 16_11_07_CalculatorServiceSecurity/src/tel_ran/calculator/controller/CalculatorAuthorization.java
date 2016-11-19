package tel_ran.calculator.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
@Configuration
public class CalculatorAuthorization extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            //All PUTs authorized only for users with role ROLE_ADMIN
            .antMatchers("/account").hasRole("ADMIN") //HttpMethod.PUT //   .antMatchers(HttpMethod.PUT).hasRole("ADMIN") 
            //All POSTs authorized only for users with role ROLE_USER
        .and()
        .authorizeRequests()
            .antMatchers(HttpMethod.POST).hasRole("USER")
    //http.authorizeRequests()
        .and()
        .authorizeRequests()
            //All other requests are permitted wo auth
            .anyRequest().permitAll();

    //Disable CSRF attack prevention
    http
        .csrf()
            .disable();

    http.httpBasic();

		// But we can override
		// http.authorizeRequests().antMatchers(HttpMethod.PUT).hasRole("USER")

	}

}
