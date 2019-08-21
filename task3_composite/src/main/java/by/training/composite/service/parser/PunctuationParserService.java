package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.PunctuationMark;

import java.util.Arrays;
import java.util.List;

public class PunctuationParserService implements Parser {
    private static final String SYMBOL_SPLIT_REGEX = "";
    private SymbolParserService symbolParser = new SymbolParserService();

    @Override
    public Component parse(final String sPunctuation) {
        PunctuationMark punctuation = new PunctuationMark();
        List<String> symbols = Arrays.asList(sPunctuation.split(SYMBOL_SPLIT_REGEX));
        for (String simbol : symbols) {
            punctuation.add(symbolParser.parse(simbol));
        }
        return punctuation;
    }
}
