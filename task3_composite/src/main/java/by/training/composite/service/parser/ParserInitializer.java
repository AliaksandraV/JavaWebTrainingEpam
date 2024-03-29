package by.training.composite.service.parser;

/**
 * parser initializer.
 */
public final class ParserInitializer {
    /**
     * default constructor for singleton.
     */
    private ParserInitializer() {

    }

    /**
     * gather chain of parsers.
     *
     * @return text parser with chain
     */
    public static Parser gather() {
        TextParserService textParser = new TextParserService();
        ParagraphParserService paragraphParser = new ParagraphParserService();
        SentenceParserService sentencesParser = new SentenceParserService();
        LexemeParserService lexemeParser = new LexemeParserService();
        WordParserService wordParser = new WordParserService();
        SymbolParserService symbolParser = new SymbolParserService();

        textParser.setNext(paragraphParser);
        paragraphParser.setNext(sentencesParser);
        sentencesParser.setNext(lexemeParser);
        lexemeParser.setNext(wordParser);
        wordParser.setNext(symbolParser);

        return textParser;
    }
}
