package com.springboot.best.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.best.services.AuthUserService;
import com.springboot.best.services.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthUserService userService;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http 
			.csrf() 
			.disable()
			.authorizeRequests()
			.antMatchers("/register","/login").permitAll()
			.antMatchers("/save_item","/items/**","/item_param_save").permitAll()
			.antMatchers("/teacher/**").hasAuthority("MG_TEACHER")
			.antMatchers("/books/**").hasAuthority("MG_BOOK")
			//.antMatchers("/admin/manage_permission","/admin/user_list","/admin/privilege/**").permitAll()
			.antMatchers("/admin/**").hasAuthority("MG_ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/info").hasAuthority("USER")
			.antMatchers("/admin_info").hasAuthority("ADMIN")
			.antMatchers("/department/**").hasAuthority("MG_DEPARTMENT")
			.antMatchers("/**").fullyAuthenticated()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login?error=1").defaultSuccessUrl("/", true)
			.and().exceptionHandling().accessDeniedPage("/accessdenied")
			.and()
			.logout().logoutUrl("/logout.htm").logoutSuccessUrl("/login").deleteCookies("JSESSIONID").invalidateHttpSession(true);

	}
}
