package by.training.composite.controller;

import by.training.composite.dao.FileReader;
import by.training.composite.entity.Component;
import by.training.composite.exception.FileException;
import by.training.composite.service.parser.TextParserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    private static String s = "В данном! случае мы-преобразовали  чисел... в Stream. чисел, умноженных? на два,";

    public static void main(String[] args) throws FileException {
        FileReader fileReader = new FileReader();
        String string = fileReader.read();

        TextParserService textParser = new TextParserService();
        Component text = textParser.parse(string);
        System.out.println();
        System.out.println(text.compose());

//        String s = joinTest();
//        System.out.println(s);
//        parserTest();

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

    private static void symbolParser(String s) {
        String[] sym = s.split("");
        for (String s1 : sym) {
            System.out.println(s1);
        }
    }


    private static void lexemeParser(String s) {
        String[] stringLexems = s.split(" ");
        Arrays.stream(stringLexems).forEach(System.out::println);
    }

    private static void wordParser(String s) {
//        \p{Punkt}
        String[] words = s.split("\\s*(\\s|,|!|\\.)\\s*");
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void sentenceParser(String s) {
//        Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(s);
        Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(s);
//        Matcher matcher = Pattern.compile("([\\s*(?<!\\.)\\.(?!\\.)\\s*])").matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group(1).trim());
        }
    }
}

class Person {
    String name;
    String surname;

    Person(String name) {
        this.name = name;
    }

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
