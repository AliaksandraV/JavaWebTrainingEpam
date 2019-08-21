package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Sentence;

import java.util.Arrays;
import java.util.List;

public class SentencesParserService implements Parser {
    private static final String LEXEME_SPLIT_REGEX = " ";
    private LexemeParserService lexemeParser = new LexemeParserService();

    @Override
    public Component parse(final String sSentence) {
        Sentence sentence = new Sentence();
        List<String> lexemes = Arrays.asList(sSentence.split(LEXEME_SPLIT_REGEX));
        for (String lexeme : lexemes) {
            sentence.add(lexemeParser.parse(lexeme));
        }
        return sentence;
    }
}
