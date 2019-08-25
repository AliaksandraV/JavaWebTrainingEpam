package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Word;

/**
 * Word Parser class.
 */
public class WordParserService extends BaseParser {
    /**
     * regex for symbol split.
     */
    private static final String SYMBOL_SPLIT_REGEX = "";

    /**
     * parser for string.
     *
     * @param sWord string for parsing
     * @return component
     */
    @Override
    public Component parse(final String sWord) {
        Word word = new Word();
        String[] symbols = sWord.split(SYMBOL_SPLIT_REGEX);
        for (String simbol : symbols) {
            word.add(getNext().parse(simbol));
        }
        return word;
    }
}
