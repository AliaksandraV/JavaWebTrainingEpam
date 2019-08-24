package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Text Parser class.
 */
public class TextParserService extends BaseParser {
    /**
     * regex for paragraph split.
     */
    private static final String PARAGRAPH_SPLIT_REGEX = "\n";

    /**
     * parser for string.
     * @param string string for parsing
     * @return component
     */
    @Override
    public Component parse(final String string) {
        String[] paragraphs = string.split(PARAGRAPH_SPLIT_REGEX);
        List<Component> paragraphList = new ArrayList<>();
        for (String paragraph : paragraphs) {
            paragraphList.add(next.parse(paragraph));
        }
        return new Text(paragraphList);
    }
}
