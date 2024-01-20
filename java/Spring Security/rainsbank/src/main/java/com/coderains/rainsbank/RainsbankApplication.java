package com.coderains.rainsbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; 

@SpringBootApplication
// @EnableJpaRepositories("com.coderains.repository")
// @EntityScan("com.coderains")
// @CrossOrigin(origins = "http://localhost:4200")// To allow specific class on
// cross origin
// @EnableWebSecurity(debug = true)
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class RainsbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RainsbankApplication.class, args);
	}

}
