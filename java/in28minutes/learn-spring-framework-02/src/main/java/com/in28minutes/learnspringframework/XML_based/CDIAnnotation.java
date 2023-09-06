package com.in28minutes.learnspringframework.XML_based;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDIAnnotation {

    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach((name) -> {
                System.out.print(name+"   :  ");
                System.out.println(context.getBean(name));
            });

        }
    }

}