package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingBasicJava {
    public static void main(String[] args) {

        // 1 Launch a spring context

        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2"));
            System.out.println(context.getBean("person3"));
            System.out.println(context.getBean("address1"));
            /*
             * Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
             */
            // System.out.println(context.getBean(Address.class));
        } catch (BeansException e) {
            e.printStackTrace();
        }

        // retrive the name value from the context

    }
}
