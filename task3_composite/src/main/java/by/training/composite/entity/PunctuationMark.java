package by.training.composite.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PunctuationMark component. Should contains list of symbols.
 */
public class PunctuationMark extends Composite {
    /**
     * Default constructs.
     */
    public PunctuationMark() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param components the collection whose elements are to be placed
     *                   into this list
     */
    public PunctuationMark(final List<Component> components) {
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
