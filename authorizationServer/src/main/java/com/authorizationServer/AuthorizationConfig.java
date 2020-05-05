/**
 * 
 */
package com.authorizationServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

/**
 * @author user
 *
 */
@Configuration
public class AuthorizationConfig extends GlobalAuthenticationConfigurerAdapter{

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("user1").password("{noop}password1").roles("USER").and()
		.withUser("user2").password("{noop}password2").roles("USER,ADMIN");
	}
}
