package com.coderains.rainsbank.config;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.coderains.rainsbank.model.Authority;
import com.coderains.rainsbank.model.Customer;
import com.coderains.rainsbank.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RainsBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && passwordEncoder.matches(password, customer.getPwd())) {
            return new UsernamePasswordAuthenticationToken(username, password, getAuthority(customer.getAuthority()));
        } else {
            throw new BadCredentialsException("username or password not valid");
        }
    }

    private Collection<? extends GrantedAuthority> getAuthority(Set<Authority> authorities) {
        List<GrantedAuthority> gAuthority = new ArrayList<>();
        for (Authority authority : authorities) {
            gAuthority.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return gAuthority;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
