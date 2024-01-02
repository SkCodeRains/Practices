package com.coderains.world.instaclone.user;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return Arrays.asList(new User[] { new User(1, "shaikh", LocalDate.of(1997, 6, 5)) });
    }

    @GetMapping("/s")
    public String login() {
        return "index.html";
    }
}
