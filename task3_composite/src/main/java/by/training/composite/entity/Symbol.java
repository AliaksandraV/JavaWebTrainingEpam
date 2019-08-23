package by.training.composite.entity;

/**
 * Symbol component.
 */
public class Symbol implements Component {
    /**
     * List of word And Punctuation mark.
     */
    private Character symbol;

    /**
     * Constructor.
     *
     * @param newSymbol symbol
     */
    public Symbol(final Character newSymbol) {
        symbol = newSymbol;
    }

    /**
     * Gathers lexeme.
     *
     * @return gather element
     */
    @Override
    public String compose() {
        return String.valueOf(symbol);
    }
}
