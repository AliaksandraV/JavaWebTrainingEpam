package by.training.composite.view;

import java.util.Scanner;

/**
 * Base view class for all menu views were need read input.
 */
public abstract class BaseMenu {
    /**
     * read input from console.
     *
     * @return input
     */
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
