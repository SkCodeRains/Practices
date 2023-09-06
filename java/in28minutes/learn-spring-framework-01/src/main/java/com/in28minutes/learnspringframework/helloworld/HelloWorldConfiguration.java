package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

record Address(String firsLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    String name() {
        return "CodeRains";
    }

    @Bean
    int age() {
        return 25;
    }

    @Bean
    Person person() {
        return new Person("Rains", 25, address());
    }

    @Bean(name = "address1")
    @Primary
    Address address() {
        return new Address("University Road ", "Amravati");
    }

    @Bean
    Person person2() {
        return new Person(name(), age(), address());
    }

    @Bean
    Person person3(String name, int age, @Qualifier("address3") Address address) {
        return new Person(name, age, address);
    }

    @Bean 
    Address address3() {
        return new Address("Inorbit mall", "Hyderabad");
    }
}
