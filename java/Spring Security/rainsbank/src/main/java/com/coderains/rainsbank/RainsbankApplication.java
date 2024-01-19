package com.coderains.rainsbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication
// @EnableJpaRepositories("com.coderains.repository")
// @EntityScan("com.coderains")
// @CrossOrigin(origins = "http://localhost:4200")// To allow specific class on
// cross origin
//@EnableWebSecurity(debug = true)
public class RainsbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RainsbankApplication.class, args);
	}

}
