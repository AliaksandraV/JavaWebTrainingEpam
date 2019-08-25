package by.training.composite.service.action;

import by.training.composite.dao.FileException;
import by.training.composite.dao.FileReader;
import by.training.composite.entity.Component;
import by.training.composite.service.parser.Parser;
import by.training.composite.service.parser.ParserInitializer;

/**
 * Print Text From File Service.
 */
public class PrintTextFromFileService {

    /**
     * Print Text From File handler.
     * @return string of compose text
     * @throws FileException if file exception
     */
    public String readText() throws FileException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();
        Parser textParser = ParserInitializer.gather();
        Component text = textParser.parse(string);
        return text.compose();
    }
}
