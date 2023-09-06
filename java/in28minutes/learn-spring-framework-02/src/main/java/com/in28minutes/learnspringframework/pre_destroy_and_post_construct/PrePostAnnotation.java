package com.in28minutes.learnspringframework.pre_destroy_and_post_construct;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@ComponentScan
@Configuration
public class PrePostAnnotation {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotation.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }
    }

}

@Component
class SomeClass {
    SomeDependency dp;

    SomeClass(SomeDependency dp) {
        super();
        this.dp = dp;
        System.out.println("All dependency are ready");
    }

    @PostConstruct
    public void initialized() {
        dp.getReady();
    }

    @PreDestroy
    void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }

}