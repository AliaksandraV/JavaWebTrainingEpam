package by.training.composite.service.parser;

import by.training.composite.entity.Component;

/**
 * interface for parser.
 */
public interface Parser {

    /**
     * parser for string.
     *
     * @param string string for parsing
     * @return component
     */
    Component parse(String string);

    /**
     * set next parser.
     *
     * @param parser next parser
     */
    void setNext(Parser parser);

    Parser getNext();
}
