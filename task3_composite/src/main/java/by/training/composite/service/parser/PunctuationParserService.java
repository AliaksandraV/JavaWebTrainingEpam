package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.PunctuationMark;

/**
 * Punctuation Parser class.
 */
public class PunctuationParserService extends BaseParser {
    /**
     * regex for symbol split.
     */
    private static final String SYMBOL_SPLIT_REGEX = "";

    /**
     * parser for string.
     *
     * @param sPunctuation string for parsing
     * @return component
     */
    @Override
    public Component parse(final String sPunctuation) {
        PunctuationMark punctuation = new PunctuationMark();
        String[] symbols = sPunctuation.split(SYMBOL_SPLIT_REGEX);
        for (String simbol : symbols) {
            punctuation.add(getNext().parse(simbol));
        }
        return punctuation;
    }
}
