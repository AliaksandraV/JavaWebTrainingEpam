package by.training.composite.service.parser;

import by.training.composite.entity.Component;
import by.training.composite.entity.Text;

import java.util.ArrayList;
import java.util.List;

public class TextParserService extends BaseParser {

    private static final String PARAGRAPH_SPLIT_REGEX = "\n";

    @Override
    public Text parse(final String string) {
        String[] paragraphs = string.split(PARAGRAPH_SPLIT_REGEX);
        List<Component> paragraphList = new ArrayList<>();
        for (String paragraph : paragraphs) {
            paragraphList.add(next.parse(paragraph));
        }
        return new Text(paragraphList);
    }
}
