/* package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP or Database
    // In Memory
    // InMemoryUserDetailsManager
    // InMemoryUserDetailsManager (UserDetails... users)
    @Bean
    InMemoryUserDetailsManager createUserDetailsManager() {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails superadmin = getUserDetails(passwordEncoder, "superadmin", "Test@123");
        UserDetails rains = getUserDetails(passwordEncoder, "rains", "Test@123");
        UserDetails admin = getUserDetails(passwordEncoder, "admin", "Test@123");
        return new InMemoryUserDetailsManager(superadmin, rains, admin);
    }

    private UserDetails getUserDetails(Function<String, String> passwordEncoder, String username, String password) {
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        // http.csrf(csrf -> csrf.disable());
        // http.headers(headers -> headers.frameOptions(frame -> frame.disable()));
        return http.build();
    }
}
 */