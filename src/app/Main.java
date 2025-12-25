package app;

import exception.NotEnoughFoundException;
import ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) throws NotEnoughFoundException {
        ConsoleMenu program = new ConsoleMenu();
        program.start();
    }
}
