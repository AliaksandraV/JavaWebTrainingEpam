package by.training.composite.entity;

/**
 * Thrown when an exceptional component condition has occurred.
 */
public class ComponentException extends Exception {
    /**
     * default empty constructor.
     */
    public ComponentException() {
    }

    /**
     * constructor with message.
     *
     * @param message exception message.
     */
    public ComponentException(final String message) {
        super(message);
    }
}

