package matrix.exceptions;

public class MatrixException extends Exception {

    /**
     * default empty constructor.
     */
    public MatrixException() {
    }

    /**
     * constructor with message.
     *
     * @param message exception message.
     */
    public MatrixException(final String message) {
        super(message);
    }

}
