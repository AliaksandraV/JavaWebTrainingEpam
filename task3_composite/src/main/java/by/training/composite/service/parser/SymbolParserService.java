package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Symbol;

/**
 * Symbol Parser class.
 */
public class SymbolParserService extends BaseParser {

    /**
     * parser for symbol.
     *
     * @param symbol string symbol
     * @return component symbol
     */
    @Override
    public Component parse(final String symbol) {
        return new Symbol(symbol.charAt(0));
    }
}
