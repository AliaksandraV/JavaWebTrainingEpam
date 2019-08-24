package by.training.composite.controller;

import by.training.composite.dao.FileException;
import by.training.composite.dao.FileReader;
import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Composite;
import by.training.composite.entity.Text;
import by.training.composite.service.ParagraphsBySentencesNumberSort;
import by.training.composite.service.SentenceInParagraphByWordsNumberSort;
import by.training.composite.service.WordsByLengthInSentenceSort;
import by.training.composite.service.parser.Parser;
import by.training.composite.service.parser.ParserInitializer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileException, ComponentException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();
        Parser textParser = ParserInitializer.gather();
        Component text = textParser.parse(string);
        System.out.println("------------------");
        System.out.println(text.compose());
        System.out.println("--------sorted by paragraph length----------");
        ParagraphsBySentencesNumberSort sortParagraphs = new ParagraphsBySentencesNumberSort();
        Text sorted = sortParagraphs.sort(text);
        System.out.println(sorted.compose());
        System.out.println("--------sorted by sentence length слова в предложении по длинне----------");
        SentenceInParagraphByWordsNumberSort sortSentences = new SentenceInParagraphByWordsNumberSort();
        sorted = sortSentences.sort(text);
        System.out.println(sorted.compose());
        System.out.println("--------sorted by words length предложения в абзаце по количеству слов ----------");
        WordsByLengthInSentenceSort sortWords = new WordsByLengthInSentenceSort();
        sorted = sortWords.sort(text);
        System.out.println(sorted.compose());
    }
}
