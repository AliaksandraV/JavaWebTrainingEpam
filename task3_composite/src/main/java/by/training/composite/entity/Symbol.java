package by.training.composite.entity;

public class Symbol implements Component {
    /**
     * List of word And Punctuation mark.
     */
    private Character symbol;

    /**
     * Constructor.
     *
     * @param newSymbol
     */
    public Symbol(Character newSymbol) {
        symbol = newSymbol;
    }


    @Override
    public String compose() {
        return String.valueOf(symbol);
    }
}
