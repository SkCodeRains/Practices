package com.in28minutes.learnspringframework.game3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

public class App03GamingBasicJava {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GameConfiguration.class)) {

            context.getBean(GamingConsole.class).down();

            context.getBean(GameRunner.class).run();

        }
    }
}
