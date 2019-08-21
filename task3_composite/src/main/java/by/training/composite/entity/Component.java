package by.training.composite.entity;

public interface Component {

    String EXCEPTION_INFO = "This operation is not supported in the current class.";

    /**
     * Gathers component.
     *
     * @return component in string representation
     */
    String compose();

    default void add(Component c) {
        throw new UnsupportedOperationException(EXCEPTION_INFO);
    }

    default void remove(Component c) {
        throw new UnsupportedOperationException(EXCEPTION_INFO);
    }

    default Object getChild(int index) {
        throw new UnsupportedOperationException(EXCEPTION_INFO);
    }
}
