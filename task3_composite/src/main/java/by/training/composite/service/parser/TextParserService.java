package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Text;

import java.util.Arrays;
import java.util.List;

public class TextParserService implements Parser {

    private static final String PARAGRAPH_SPLIT_REGEX = "\n";//"(?!^)(?m)(?=^\\s{4})";
    private ParagraphParserService paragraphParser = new ParagraphParserService();


    @Override
    public Component parse(final String string) {
        Text text = new Text();
        List<String> paragraphs = Arrays.asList(string.split(PARAGRAPH_SPLIT_REGEX));
        for (String paragraph : paragraphs) {
            text.add(paragraphParser.parse(paragraph));
        }
        return text;
    }
}
