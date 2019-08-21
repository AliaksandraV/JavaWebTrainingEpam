package by.training.composite.service.parser;

import by.training.composite.entity.Word;

import java.util.Arrays;
import java.util.List;

public class WordParserService implements Parser {
    private static final String SYMBOL_SPLIT_REGEX = "";
    private SymbolParserService symbolParser = new SymbolParserService();

    @Override
    public Word parse(String sWord) {
        Word word = new Word();
        List<String> symbols = Arrays.asList(sWord.split(SYMBOL_SPLIT_REGEX));
        for (String simbol: symbols){
            word.add(symbolParser.parse(simbol));
        }
        return word;
    }
}
