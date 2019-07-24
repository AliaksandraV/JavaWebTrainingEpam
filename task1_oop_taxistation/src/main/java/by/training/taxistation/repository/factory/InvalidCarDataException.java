package by.training.taxistation.repository.factory;

public class InvalidCarDataException extends Exception {
    /**
     * .
     */
    public InvalidCarDataException() {
        this("Неккоректные данные.");
    }
    /**
     * .
     */
    public InvalidCarDataException(String message) {
        super(message);
    }

}
