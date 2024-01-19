package com.coderains.rainsbank.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    String[] uri() {
        var list = new ArrayList<String>();
        list.add("/myAccount.ss");
        list.add("/myCards.ss");
        list.add("/myLoans");
        list.add("/myBalance");
        return list.toArray(new String[0]);
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/notices.ss", "/contact.ss").permitAll()
                        .requestMatchers(uri()).authenticated())
                .formLogin(Customizer.withDefaults())
                // .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .build();

    }

}
