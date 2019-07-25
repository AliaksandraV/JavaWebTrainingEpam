package by.training.taxistation.repository.factory;

public class InvalidCarDataException extends Exception {
    /**
     * exeption.
     */
    public InvalidCarDataException() {
        this("Неккоректные данные.");
    }

    /**
     * exeption.
     * @param message exeption message.
     */
    public InvalidCarDataException(final String message) {
        super(message);
    }

}
