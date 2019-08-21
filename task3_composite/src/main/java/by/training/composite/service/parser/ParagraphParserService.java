package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Paragraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParserService implements Parser {

    private static final String SENTENCE_SPLIT_REGEX ="([^.!?\\n]+[(\\.{1,3})*\\?*\\!*]+)";//"([^.!?]+[.!?])";
    private SentencesParserService sentenceParser = new SentencesParserService();

    @Override
    public Component parse(final String sParagraph) {
        Paragraph paragraph = new Paragraph();
        Matcher sentenceMatcher = Pattern.compile(SENTENCE_SPLIT_REGEX).matcher(sParagraph);
        while (sentenceMatcher.find()) {
            paragraph.add(sentenceParser.parse(sentenceMatcher.group().trim()));
        }
        return paragraph;
    }
}
