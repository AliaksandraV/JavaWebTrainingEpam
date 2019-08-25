package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Paragraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Paragraph Parser class.
 */
public class ParagraphParserService extends BaseParser {
    /**
     * regex for sentence split.
     */
    private static final String SENTENCE_SPLIT_REGEX =
            "([^.!?\\n]+[(\\.{1,3})*\\?*\\!*]+)";

    /**
     * parser for string.
     *
     * @param sParagraph string for parsing
     * @return component
     */
    @Override
    public Component parse(final String sParagraph) {
        Paragraph paragraph = new Paragraph();
        Matcher sentenceMatcher = Pattern.compile(SENTENCE_SPLIT_REGEX)
                .matcher(sParagraph);
        while (sentenceMatcher.find()) {
            paragraph.add(getNext().parse(sentenceMatcher.group().trim()));
        }
        return paragraph;
    }
}
