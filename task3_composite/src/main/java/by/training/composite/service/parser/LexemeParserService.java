package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lexeme Parser class.
 */
public class LexemeParserService extends BaseParser {
    /**
     * regex for word split.
     */
    private static final String WORD_SPLIT_REGEX = "\\s*(\\s|,|!|\\?|\\.)\\s*";
    /**
     * regex for punctuation split.
     */
    private static final String PUNCTUATION_SPLIT_REGEX = "(\\.{3})|([.,!?])";
    /**
     * punctuation Parser.
     */
    private Parser punctuationParser = new PunctuationParserService();

    /**
     * default constructor.
     */
    public LexemeParserService() {
        punctuationParser.setNext(new SymbolParserService());
    }

    /**
     * parser for string.
     *
     * @param sLexeme string for parsing
     * @return component
     */
    @Override
    public Component parse(final String sLexeme) {
        Lexeme lexeme = new Lexeme();
        String[] words = sLexeme.split(WORD_SPLIT_REGEX);
        for (String word : words) {
            lexeme.add(next.parse(word));
        }
        Pattern pattern = Pattern.compile(PUNCTUATION_SPLIT_REGEX);
        Matcher matcher = pattern.matcher(sLexeme);
        while (matcher.find()) {
            lexeme.add(punctuationParser.parse(matcher.group()));
        }
        return lexeme;
    }
}
