package by.training.composite.entity;

import java.util.Objects;

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

    /**
     * equals.
     * @param o object
     * @return true if equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol symbol = (Symbol) o;
        return character.equals(symbol.character);
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}
