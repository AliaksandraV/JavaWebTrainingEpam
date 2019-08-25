package by.training.composite.controller;

/**
 * Start application point.
 */
public final class Runner {
    /**
     * Default constructor.
     */
    private Runner() {
    }
    /**
     * @param args args command line values
     */
    public static void main(final String[] args) {
        MainMenuController menuController = new MainMenuController();
        menuController.run();
    }
}
