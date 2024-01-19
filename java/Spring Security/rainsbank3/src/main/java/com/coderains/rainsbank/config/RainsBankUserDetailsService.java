// package com.coderains.rainsbank.config;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.coderains.rainsbank.model.Customer;
// import com.coderains.rainsbank.repository.CustomerRepository;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class RainsBankUserDetailsService implements UserDetailsService {

//     CustomerRepository customerRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//         List<GrantedAuthority> authority = null;

//         Customer customer = customerRepository.findByUsername(username);

//         if (customer == null) {
//             throw new UsernameNotFoundException("User not Found");
//         } else {
//             authority = new ArrayList<>();
//             authority.add(new SimpleGrantedAuthority(customer.getRole()));
//         }
//         return new User(customer.getUsername(), customer.getPwd(), authority);
//     }

// }
