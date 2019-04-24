package camarra.project.customerCRM;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//add a reference to our security data source which is defined in application.properties
	@Autowired
	private DataSource securityDataSource;

	//configure users (in memory, database, etc...)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//use jdbc authentication
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	
	}
	
	//configure security of web paths in application, login, logout, etc..
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/employee/**").hasAnyRole("EMPLOYEE","ADMIN")
			.and()
			.formLogin().permitAll().defaultSuccessUrl("/employee/customers")
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		}
	
	
}
