package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Input your name and favourite sport");
        handler.handleUser();
        System.out.println("Input bet value and risk");
        handler.handleBet();
    }
}
