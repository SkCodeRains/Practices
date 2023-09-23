package com.in28minutes.learnspringsecurity.security;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class BasicAuthentication {
	@Bean
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).csrf(csrf -> csrf.disable())
				.httpBasic(withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

	}

	@Bean
	UserDetailsService detailsService() {
		var user = User.withUsername("rains").password("{noop}Test@123").roles("user").build();
		var admin = User.withUsername("superadmin").password("{noop}Test@123").roles("admin").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	DataSource dataSource() {
		
	}

}
