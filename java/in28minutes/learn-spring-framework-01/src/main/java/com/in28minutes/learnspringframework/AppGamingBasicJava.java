package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacManGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var superContraGame = new SuperContraGame();
        var pacMan = new PacManGame();

        new GameRunner(pacMan).run();
        var gameRunner = new GameRunner(marioGame);
        var gameRunner2 = new GameRunner(superContraGame);
        gameRunner.run();
        gameRunner2.run();
    }
}
