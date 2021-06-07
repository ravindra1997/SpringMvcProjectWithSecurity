package com.techouts.myconfig;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityFilter extends WebSecurityConfigurerAdapter {
	@Autowired
	private BasicDataSource datSource;
	

	public BasicDataSource getDatSource() {
		return datSource;
	}

	public void setDatSource(BasicDataSource datSource) {
		this.datSource = datSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
		.withUser("ravindra")
		.password("ravi123")
		.roles("user");*/
		
		auth.jdbcAuthentication().dataSource(datSource)
		.usersByUsernameQuery("select phoneNumber,password,enabled from userinfo where phoneNumber=?")
		.authoritiesByUsernameQuery("select phoneNumber,emailId from userinfo where phoneNumber=?")
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	/*@SuppressWarnings("deprecation")
	@Bean
	PasswordEncoder gePasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/check")
		.authenticated()
		.antMatchers("/loginToShop").authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.httpBasic()
		.and()
		.logout()
		;
	}
	
}
