package com.in28minutes.learnspringframework.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacManGame;

@Component
class MyBusiness {
    Dp1 dp1;
    Dp2 dp2;

    public MyBusiness(Dp1 dp1, Dp2 dp2) {
        System.out.println("Constructor injection");
        this.dp1 = dp1;
        this.dp2 = dp2;
    }
}

@Component
class Dp1 {

}

@Component
class Dp2 {

}

@Configuration
@ComponentScan("com.in28minutes.learnspringframework")
public class GameLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GameLauncher.class)) {

            System.out.println(context.getBean(MyBusiness.class));
            context.getBean(PacManGame.class).down();
            context.getBean(GameRunner.class).run();

        }
    }
}
