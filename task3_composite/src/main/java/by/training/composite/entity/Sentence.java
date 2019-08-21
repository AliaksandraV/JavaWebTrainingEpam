package by.training.composite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence implements Component {
    /**
     * List of lexemes.
     */
    private List<Component> lexemes = new ArrayList<>();

    /**
     * Gathers lexeme.
     *
     * @return
     */
    @Override
    public String compose() {
        return lexemes.stream()
                .map(Component::compose)
                .collect(Collectors.joining(" "));
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param c element to be appended to this list
     */
    @Override
    public void add(final Component c) {
        lexemes.add(c);
    }

    /**
     * Removes the first occurrence of the specified element from list.
     *
     * @param c element to be removed from this list, if present
     */
    @Override
    public void remove(final Component c) {
        lexemes.remove(c);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public Object getChild(final int index) {
        return lexemes.get(index);
    }
}
