package com.in28minutes.webservices.restfulwebservices.h2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    UserNotFoundException() {
        super("User not found");
    }
}
