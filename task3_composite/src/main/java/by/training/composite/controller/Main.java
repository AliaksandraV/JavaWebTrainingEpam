package by.training.composite.controller;

import by.training.composite.dao.FileReader;
import by.training.composite.entity.*;
import by.training.composite.dao.FileException;
import by.training.composite.service.ComponentFinderService;
import by.training.composite.service.parser.Parser;
import by.training.composite.service.parser.ParserInitializer;
import by.training.composite.service.parser.TextParserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    private static String s = "В данном! случае мы-преобразовали  чисел... в Stream. чисел, умноженных? на два,";

    public static void main(String[] args) throws FileException, ComponentException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();


        Parser textParser = ParserInitializer.gather();
        Component text = textParser.parse(string);
        System.out.println("------------------");
        System.out.println(text.compose());

        Comparator<Component> comparator = Comparator.comparingInt(o -> ((Composite) o).getImmutableComponents().size());
        Text sorted = sortParagraphs(text, comparator);

        System.out.println("--------sorted by paragraph length----------");
        System.out.println(sorted.compose());

        sorted = sortSentences(text, comparator);

        System.out.println("--------sorted by sentence length----------");
        System.out.println(sorted.compose());

        comparator = Comparator.comparingInt(o -> ((Composite)((Composite) o).getImmutableComponents().get(0)).getImmutableComponents().size());
        sorted = sortWords(text, comparator);

        System.out.println("--------sorted by words length----------");
        System.out.println(sorted.compose());


//        List<Component> paragraphs = new ArrayList<>();
//        paragraphs.addAll(new ComponentFinderService().find(text, Word.class));
//        paragraphs.forEach(System.out::println);


    }


    public static Text sortParagraphs(Component text, Comparator<Component> comparator) {
        return new Text(getSortedComponents(comparator, text));
    }

    public static Text sortSentences(Component text, Comparator<Component> comparator) {
        List<Component> paragraphs = new ArrayList<>();

        ((Text)text).getImmutableComponents().forEach(paragraph -> {
            List<Component> components = getSortedComponents(comparator, ((Composite) paragraph));
            paragraphs.add(new Paragraph(components));
        });

        return new Text(paragraphs);
    }

    public static Text sortWords(Component text, Comparator<Component> comparator) {
        List<Component> paragraphs = new ArrayList<>();

        ((Text)text).getImmutableComponents()
                .forEach(
                        paragraph -> {
                            List<Component> sentences = new ArrayList<>();
                            ((Composite) paragraph).getImmutableComponents()
                                    .forEach(
                                            sentence -> {
                                                List<Component> components = getSortedComponents(comparator, ((Composite) sentence));
                                                sentences.add(new Sentence(components));
                                            });
                            paragraphs.add(new Paragraph(sentences));
                        });
        return new Text(paragraphs);
    }

    private static List<Component> getSortedComponents(final Comparator<Component> comparator, final Component composite) {
        return ((Composite)composite).getImmutableComponents()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private static String joinTest() {
//        List<Person> list = Arrays.asList(
//                new Person("John"),
//                new Person("Anna"),
//                new Person ("Paul")
//        );
        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add(".");
        strings.add("three");

        System.out.println(strings.size());
        strings.get(4);

//        String str = null;
//        str = String.join("!", strings);
        String str = strings.stream().collect(Collectors.joining("?"));

//        for (int i=0; i<strings.size(); i++) {
//            punctuation += String.join("!", strings.get(i));
//        }
        return str;
    }

    private static void parserTest() {
        String WORD_SPLIT_REGEX = "\\s*(\\s|,|!|\\.)\\s*";
//        String PUNCTUATION_SPLIT_REGEX = "([!.,;:?])|(\\.{3})";
        String PUNCTUATION_SPLIT_REGEX = "(\\.{3})|([.,!?])";

//        String punct_red = PUNCTUATION_SPLIT_REGEX;
        String s = "kuku, hdhf... he!";
//        List<String> words = Arrays.asList(s.split(punct_red));
//        for (String word: words){
//            System.out.println(word);
//        }


        Pattern p = Pattern.compile(PUNCTUATION_SPLIT_REGEX);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.start() + " " + m.group() + " ");
        }
    }


}
