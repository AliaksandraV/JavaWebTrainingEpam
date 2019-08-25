package by.training.composite.service.action;

import by.training.composite.dao.FileException;
import by.training.composite.dao.FileReader;
import by.training.composite.entity.Component;
import by.training.composite.service.parser.Parser;
import by.training.composite.service.parser.ParserInitializer;

public class PrintTextFromFileService {

    public String readText() throws FileException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();
        Parser textParser = ParserInitializer.gather();
        Component text = textParser.parse(string);
        return text.compose();
    }
}
