package by.training.composite.entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Paragraph component. Should contains list of sentences.
 */
public class Paragraph extends Composite {

    /**
     * Default constructs.
     */
    public Paragraph() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param components the collection whose elements are to be placed
     *                   into this list
     */
    public Paragraph(final List<Component> components) {
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
                .collect(Collectors.joining(" "));
    }
}
