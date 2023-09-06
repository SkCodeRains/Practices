package com.in28minutes.learnspringframework.cdi_annotation;

import java.util.Arrays;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@ComponentScan
@Configuration
public class CDIAnnotation {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CDIAnnotation.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }
    }

}

@Named
class BusinessService {
    private DataService dataService;

    @Inject
    public DataService getDataService() {
        System.out.println("setter injection");
        return dataService;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}

@Named
class DataService {

}