package by.training.composite.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Word component. Should contains list of symbols.
 */
public class Word extends Composite {
    /**
     * Default constructs.
     */
    public Word() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param components the collection whose elements are to be placed
     *                   into this list
     */
    public Word(final List<Component> components) {
        super(components);
    }

    /**
     * Gathers lexeme.
     *
     * @return gather element
     */
    @Override
    public String compose() {
        return components.stream()
                .map(Component::compose)
                .collect(Collectors.joining(""));
    }
}
