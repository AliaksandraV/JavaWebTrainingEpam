package by.training.composite.service.action;

import by.training.composite.dao.FileException;
import by.training.composite.dao.FileReader;
import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Text;
import by.training.composite.service.SentenceInParagraphByWordsNumberSort;
import by.training.composite.service.parser.Parser;
import by.training.composite.service.parser.ParserInitializer;

/**
 * SortSentenceService.
 */
public class SortSentenceService {

    /**
     * @return string of sorted compose text
     * @throws FileException if file exception
     * @throws ComponentException if component exception
     */
    public String sort() throws FileException, ComponentException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();
        Parser textParser = ParserInitializer.gather();
        Component text = textParser.parse(string);
        SentenceInParagraphByWordsNumberSort sortSentences =
                new SentenceInParagraphByWordsNumberSort();
        Text sorted = sortSentences.sort(text);
        return sorted.compose();
    }
}
