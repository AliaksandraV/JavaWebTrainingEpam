package by.training.photographer.exception;

public class UserDuplicateException extends PersistenceException {

    public UserDuplicateException() {
        super();
    }

    public UserDuplicateException(final String message) {
        super(message);
    }

    public UserDuplicateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserDuplicateException(final Throwable cause) {
        super(cause);
    }
}
