package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Sentence;

/**
 * Sentence Parser class.
 */
public class SentenceParserService extends BaseParser {
    /**
     * regex for lexeme split.
     */
    private static final String LEXEME_SPLIT_REGEX = " ";

    /**
     * parser for string.
     *
     * @param sSentence string for parsing
     * @return component
     */
    @Override
    public Component parse(final String sSentence) {
        Sentence sentence = new Sentence();
        String[] lexemes = sSentence.split(LEXEME_SPLIT_REGEX);
        for (String lexeme : lexemes) {
            sentence.add(getNext().parse(lexeme));
        }
        return sentence;
    }
}
