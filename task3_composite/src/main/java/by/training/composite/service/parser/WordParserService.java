package by.training.composite.service.parser;

import by.training.composite.entity.Word;

import java.util.Arrays;
import java.util.List;

public class WordParserService extends BaseParser {
    private static final String SYMBOL_SPLIT_REGEX = "";

    @Override
    public Word parse(String sWord) {
        Word word = new Word();
        List<String> symbols = Arrays.asList(sWord.split(SYMBOL_SPLIT_REGEX));
        for (String simbol: symbols){
            word.add(next.parse(simbol));
        }
        return word;
    }
}
