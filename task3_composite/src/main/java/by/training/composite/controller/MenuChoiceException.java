package by.training.composite.controller;

/**
 * Thrown when an exceptional menu choice condition has occurred.
 */
public class MenuChoiceException extends InputFormatException {
    /**
     * constructor.
     */
    public MenuChoiceException() {
        super("Выбран несуществующий пункт меню.");
    }

    /**
     * constructor with parameters.
     *
     * @param message message
     */
    public MenuChoiceException(final String message) {
        super(message);
    }
}
