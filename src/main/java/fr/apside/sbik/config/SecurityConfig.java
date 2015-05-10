package fr.apside.sbik.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .jdbcAuthentication()
      .dataSource(dataSource)
      .usersByUsernameQuery(
        "select username, password, enabled from users where username = ?")
      .authoritiesByUsernameQuery(
        "SELECT username, role FROM USERS u inner join user_roles r on u.user_role_id = r.user_role_id where username =?");
  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsMode.SAMEORIGIN)).and()
		    .authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login.xhtml").permitAll()
				.failureUrl("/login.xhtml?error=fail").permitAll()
				.defaultSuccessUrl("/project/projectList.xhtml", true)
				.usernameParameter("username").passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login.xhtml")
				.permitAll().and().exceptionHandling()
				.accessDeniedPage("/error/403").and().csrf().disable();
	}

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/javax.faces.resource/**", "/resources/**");
  }

}
