package com.coderains.world.instaclone.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coderains.world.instaclone.jwt.JwtTokenResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserJpaResource {
    private UserRepository service;
    private RestTemplate restTemplate;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registerUser.ss")
    private ResponseEntity<JwtTokenResponse> registerUser(@RequestBody User user) {

        User foundUser = service.findByUsername(user.getUsername());
        String password = user.getPassword();
        System.out.println(passwordEncoder.encode(password));
        user.setPassword(passwordEncoder.encode(password));
        if (foundUser == null) {
            service.save(user);
        }

        String loginUrl = "http://localhost:8080/authenticate.ss";
        User loginRequest = new User(user.getUsername(), password);
        HttpEntity<User> requestEntity = new HttpEntity<>(loginRequest);
        ResponseEntity<JwtTokenResponse> response = restTemplate.postForEntity(loginUrl, requestEntity,
                JwtTokenResponse.class);
        return response;

    }
}
