package by.training.composite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PunctuationMark implements Component {
    /**
     * List of word And Punctuation mark.
     */
    private List<Component> symbols = new ArrayList<>();

    /**
     * Gathers lexeme.
     *
     * @return
     */
    @Override
    public String compose() {
        return symbols.stream()
                .map(Component::compose)
                .collect(Collectors.joining(""));
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param c element to be appended to this list
     */
    @Override
    public void add(final Component c) {
        symbols.add(c);
    }

    /**
     * Removes the first occurrence of the specified element from list.
     *
     * @param c element to be removed from this list, if present
     */
    @Override
    public void remove(final Component c) {
        symbols.remove(c);
    }
}
