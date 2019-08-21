package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Symbol;

public class SymbolParserService implements Parser {

    @Override
    public Component parse(final String symbol) {
        return new Symbol(symbol.charAt(0));
    }
}
