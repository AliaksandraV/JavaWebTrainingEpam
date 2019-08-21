package by.training.composite.service.parser;

import by.training.composite.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParserService implements Parser {
    private static final String WORD_SPLIT_REGEX = "\\s*(\\s|,|!|\\.)\\s*";
    private static final String PUNCTUATION_SPLIT_REGEX = "(\\.{3})|([.,!?])";
    private WordParserService wordParser = new WordParserService();
    private PunctuationParserService punctuationParser = new PunctuationParserService();

    @Override
    public Component parse(final String sLexeme) {
        Lexeme lexeme = new Lexeme();
        List<String> words = Arrays.asList(sLexeme.split(WORD_SPLIT_REGEX));
        for (String word: words){
            lexeme.add(wordParser.parse(word));
        }
        Pattern pattern = Pattern.compile(PUNCTUATION_SPLIT_REGEX);
        Matcher matcher = pattern.matcher(sLexeme);
        while (matcher.find()){
            lexeme.add(punctuationParser.parse(matcher.group()));
        }
        return lexeme;
    }
}
