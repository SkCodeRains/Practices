package com.in28minutes.learnspringframework.scop;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class BeansScop {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeansScop.class)) {

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(ScopePrototypeClass.class));
            System.out.println(context.getBean(ScopePrototypeClass.class));
            System.out.println(context.getBean(ScopePrototypeClass.class));
            System.out.println(context.getBean(ScopePrototypeClass.class));
            System.out.println(context.getBean(ScopePrototypeClass.class));

        }

    }

}

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ScopePrototypeClass {

}