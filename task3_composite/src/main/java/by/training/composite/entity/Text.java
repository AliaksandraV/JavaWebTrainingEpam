package by.training.composite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Text implements Component {
    /**
     * List of word And Punctuation mark.
     */
    private List<Component> paragraphs = new ArrayList<>();

    /**
     * Gathers lexeme.
     *
     * @return
     */
    @Override
    public String compose() {
        System.out.print("\t");
        return paragraphs.stream()
                .map(Component::compose)
                .collect(Collectors.joining("\n\t"));
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param c element to be appended to this list
     */
    @Override
    public void add(final Component c) {
        paragraphs.add(c);
    }

    /**
     * Removes the first occurrence of the specified element from list.
     *
     * @param c element to be removed from this list, if present
     */
    @Override
    public void remove(final Component c) {
        paragraphs.remove(c);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public Object getChild(final int index) {
        return paragraphs.get(index);
    }
}
