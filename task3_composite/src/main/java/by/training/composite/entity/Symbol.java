package by.training.composite.entity;

/**
 * Symbol component.
 */
public class Symbol implements Component {
    /**
     * List of word And Punctuation mark.
     */
    private Character character;

    /**
     * Constructor.
     *
     * @param newSymbol character
     */
    public Symbol(final Character newSymbol) {
        character = newSymbol;
    }

    /**
     * Gathers lexeme.
     *
     * @return gather element
     */
    @Override
    public String compose() {
        return String.valueOf(character);
    }
}
