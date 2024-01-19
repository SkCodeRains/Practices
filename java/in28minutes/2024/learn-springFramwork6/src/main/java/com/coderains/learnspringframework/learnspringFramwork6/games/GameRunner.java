package com.coderains.learnspringframework.learnspringFramwork6.games;

public class GameRunner {
    GaminConsole console;

    public GameRunner(GaminConsole console) {
        this.console = console;
    }

    public void run() {
        console.up();
        console.down();
        console.left();
        console.right();
    }
}
