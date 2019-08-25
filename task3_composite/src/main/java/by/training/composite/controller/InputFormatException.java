package by.training.composite.controller;


/**
 * Thrown when an exceptional input format condition has occurred.
 */
public class InputFormatException extends Exception {
    /**
     * constructor.
     */
    public InputFormatException() {
        this("Введены данные неверного формата.");
    }

    /**
     * constructor with parameters.
     *
     * @param message message
     */
    public InputFormatException(final String message) {
        super(message);
    }
}
