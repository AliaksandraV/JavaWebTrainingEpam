package by.training.composite.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Lexeme component. Should contains list of word and punctuation.
 */
public class Lexeme extends Composite {
    /**
     * Default constructs.
     */
    public Lexeme() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param components the collection whose elements are to be placed
     *                   into this list
     */
    public Lexeme(final List<Component> components) {
        super(components);
    }

    /**
     * Gathers lexeme.
     *
     * @return
     */
    @Override
    public String compose() {
        return components.stream()
                .map(Component::compose)
                .collect(Collectors.joining(""));
    }
}
