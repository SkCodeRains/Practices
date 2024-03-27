package com.github.oauth2.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

	@GetMapping("/")
	public String authLogin(OAuth2AuthenticationToken token) {
		System.out.println(token.toString());
		System.out.println(token.getPrincipal());
		return "secure.html";
	}

}