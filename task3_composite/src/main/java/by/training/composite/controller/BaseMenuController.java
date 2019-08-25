package by.training.composite.controller;

import java.util.Scanner;

/**
 * Base menu class for all menu controllers.
 */
public abstract class BaseMenuController {
    /**
     * run actions.
     */
    public abstract void run();

    /**
     * read iput from console.
     *
     * @return input
     */
    protected String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /**
     * validate input on int.
     *
     * @param input input
     * @throws InputFormatException if input invalide
     */
    protected void validateInt(final String input) throws InputFormatException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InputFormatException();
        }
    }
}
