package by.training.composite.exception;

/**
 * Thrown when an exceptional file condition has occurred.
 */
public class FileException extends Exception {

    /**
     * default empty constructor.
     */
    public FileException() {
    }

    /**
     * constructor with message.
     *
     * @param message exception message.
     */
    public FileException(final String message) {
        super(message);
    }
}