package com.in28minutes.learnspringframework.game3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacManGame;

@Configuration
public class GameConfiguration {

    @Bean
    GamingConsole game() {
        return new PacManGame();
    }

    @Bean
    GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

}
