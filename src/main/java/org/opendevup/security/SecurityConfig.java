package org.opendevup.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
//Modifying or overriding the default spring boot security.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, actived from users where username=?")
		.authoritiesByUsernameQuery("select users_username as principal, roles_role as role from users_roles where users_username=?")
		.rolePrefix("ROLE_")
		.passwordEncoder(new Md5PasswordEncoder()); 

	}
	
	/*This method is for overriding some configuration of the WebSecurity
	* If you want to ignore some request or request patterns then you can
	* specify that inside this method
	*/
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring() 
				.antMatchers("/", "/index.html", "/app/**", "/authenticate", "/favicon.ico", "/css/**", "/js/**", "/images/**");
				
	}
	
	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			
			// starts authorizing configurations
			.authorizeRequests()
			//.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
			.anyRequest().fullyAuthenticated().and()
			// adding JWT filter
			.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
			// enabling the basic authentication
			.httpBasic().and()
			// configuring the session as state less. Which means there is
			// no session in the server
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			// disabling the CSRF - Cross Site Request Forgery
			.csrf().disable(); // on doit l'activer apres
		
	}
}
