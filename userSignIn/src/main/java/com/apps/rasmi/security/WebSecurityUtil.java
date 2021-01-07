package com.apps.rasmi.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.apps.rasmi.userServiceImpl.UserServiceImpl;
import com.apps.rasmi.ws.service.UserDetailService;

@EnableWebSecurity
public class WebSecurityUtil extends WebSecurityConfigurerAdapter {

	private final UserDetailService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityUtil(UserDetailService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users").permitAll()
				.anyRequest().authenticated().and().addFilter(authenticatiionFilter());
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}
	
	
		
	public UserAuthenticationFilter authenticatiionFilter() throws Exception {
		
		UserAuthenticationFilter userAuthenticationFilter	=new UserAuthenticationFilter(authenticationManager());
		userAuthenticationFilter.setFilterProcessesUrl("/users/login");

		return userAuthenticationFilter;
	}

}