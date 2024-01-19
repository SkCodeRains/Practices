package com.coderains.rainsbank.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.coderains.rainsbank.filter.AuthoritiesLoggingAfterFilter;
import com.coderains.rainsbank.filter.CsrfCookieFilter;
import com.coderains.rainsbank.filter.RequestValidationBeforeFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	String[] uri() {
		var list = new ArrayList<String>();
		list.add("/myAccount.ss");
		list.add("/myCards.ss");
		list.add("/myLoans.ss");
		list.add("/myBalance.ss");
		list.add("/user.ss");
		return list.toArray(new String[0]);
	}

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		CsrfTokenRequestAttributeHandler csrfHandler = new CsrfTokenRequestAttributeHandler();
		csrfHandler.setCsrfRequestAttributeName("_csrf");

		return http.securityContext(sc -> sc.requireExplicitSave(false))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
				.cors(t -> t.configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(@NonNull HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();
						config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
						config.setAllowedMethods(Arrays.asList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Arrays.asList("*"));
						config.setMaxAge(3600L);
						return config;
					}
				}))
				.csrf(csrf -> csrf.csrfTokenRequestHandler(csrfHandler)
						.ignoringRequestMatchers("/contact.ss", "/register.ss")
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

				).addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
				.authorizeHttpRequests(
						(request) -> request.requestMatchers("/notices.ss", "/contact.ss", "/register.ss").permitAll()
								// requestMatchers ("/myAccount"). hasAuthority (VIEWACCOUNT")
								// requestMatchers("/myBalance").hasAnyAuthority ("VIEWACCOUNT", "VIEWBALANCE")
								// requestMatchers("/myLoans"). hasAuthority ("VIEWLOANS")
								// requestMatchers"/myCards").hasAuthority ("VIEWCARDS"
								.requestMatchers(" /myBalance.ss").hasAnyRole("USER", "ADMIN")
								.requestMatchers("/myCards.ss", " /myAccount.ss", " /myLoans.ss").hasRole("USER")
								.requestMatchers(uri()).authenticated())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(15);
	}

}
