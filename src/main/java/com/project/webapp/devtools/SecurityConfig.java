/**
 * 
 */
package com.project.webapp.devtools;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/**
 * @author Vamsi Ravi
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	  Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	     http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/console/**").permitAll(); 
	     //http.authorizeRequests().antMatchers("/imgs/**").permitAll(); 
	     //http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
	     //http.authorizeRequests().antMatchers("/**").hasRole("USER").and().formLogin();
	    
	     // add this line to use H2 web console
	     http.csrf().disable();
	     http.headers().frameOptions().disable();
	     
	   }
	
}




