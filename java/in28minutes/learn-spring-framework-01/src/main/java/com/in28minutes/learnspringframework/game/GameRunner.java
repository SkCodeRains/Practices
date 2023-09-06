package com.in28minutes.learnspringframework.game;

public class GameRunner {

    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;

        game.up();
        game.down();
        game.left();
        game.right();

    }

    public void run() {
        System.out.println("Game is running now" + game);
    }

}
