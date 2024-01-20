package com.coderains.rainsbank.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.coderains.rainsbank.constants.SecurityConstants;
import com.coderains.rainsbank.filter.JWTTokenGeneratorFilter;
import com.coderains.rainsbank.filter.JWTTokenValidatorFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		CsrfTokenRequestAttributeHandler csrfHandler = new CsrfTokenRequestAttributeHandler();
		csrfHandler.setCsrfRequestAttributeName("_csrf");

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.cors(t -> t.configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(@NonNull HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();
						config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
						config.setAllowedMethods(Arrays.asList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Arrays.asList("*"));
						config.setExposedHeaders(Arrays.asList(SecurityConstants.JWT_HEADER));
						config.setMaxAge(3600L);
						return config;
					}
				}))
				.csrf(csrf -> csrf
						.disable()
				// csrfTokenRequestHandler(csrfHandler)
				// .ignoringRequestMatchers("/contact.ss", "/register.ss")
				// .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()
				)
				// .addFilterBefore(new RequestValidationBeforeFilter(),
				// BasicAuthenticationFilter.class)
				.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
				// .addFilterAt(new AuthoritiesLoggingAtFilter(),
				// BasicAuthenticationFilter.class)
				// .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
				// .addFilterAfter(new AuthoritiesLoggingAfterFilter(),
				// BasicAuthenticationFilter.class)
				.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.authorizeHttpRequests(
						(request) -> request
								// .requestMatchers("/myBalance.ss").hasAnyRole("USER", "ADMIN")
								// .requestMatchers("/myCards.ss", "/myBalance.ss", "/myAccount.ss")
								// .hasRole("USER")
								// .requestMatchers()
								// "myCards.ss", "/myBalance.ss", "/myAccount.ss","user.ss","/myLoans.ss"
								// .requestMatchers("/myBalance.ss").hasAnyAuthority("USER", "ROLE_USER")
								.requestMatchers("/myBalance.ss", "/myCards.ss", "/myAccount.ss", "/myLoans.ss")
								.hasAnyRole("USER", "ADMIN")
								.requestMatchers("user.ss")
								.authenticated()
								.requestMatchers("/notices.ss", "/contact.ss", "/register.ss").permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		return http.build();

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
