package by.training.composite.service.parser;

/**
 * Base class for parsers.
 */
public abstract class BaseParser implements Parser {

    /**
     * Next parser chain of parsers.
     */
    private Parser next;

    /**
     * set next parser in chain.
     *
     * @param parser next parser
     */
    @Override
    public void setNext(final Parser parser) {
        next = parser;
    }

    /**
     * Return next parser.
     *
     * @return next parser
     */
    @Override
    public Parser getNext() {
        return next;
    }
}
