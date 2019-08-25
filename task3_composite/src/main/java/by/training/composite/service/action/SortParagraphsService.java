package by.training.composite.service.action;

import by.training.composite.dao.FileException;
import by.training.composite.dao.FileReader;
import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Text;
import by.training.composite.service.ParagraphsBySentencesNumberSort;
import by.training.composite.service.parser.Parser;
import by.training.composite.service.parser.ParserInitializer;

public class SortParagraphsService {

    public String sort() throws FileException, ComponentException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();
        Parser textParser = ParserInitializer.gather();
        Component text = textParser.parse(string);
        ParagraphsBySentencesNumberSort sortParagraphs = new ParagraphsBySentencesNumberSort();
        Text sorted = sortParagraphs.sort(text);
        return sorted.compose();
    }
}
