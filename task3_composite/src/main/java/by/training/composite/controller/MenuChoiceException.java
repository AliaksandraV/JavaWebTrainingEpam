package by.training.composite.controller;

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
