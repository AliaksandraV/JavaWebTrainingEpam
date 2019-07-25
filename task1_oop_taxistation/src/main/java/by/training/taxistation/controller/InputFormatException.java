package by.training.taxistation.controller;

public class InputFormatException extends Exception {
    /**
     * constructor.
     */
    public InputFormatException() {
        this("Введены данные неверного формата.");
    }

    /**
     * constructor with parameters.
     * @param message message
     */
    public InputFormatException(final String message) {
        super(message);
    }
}
