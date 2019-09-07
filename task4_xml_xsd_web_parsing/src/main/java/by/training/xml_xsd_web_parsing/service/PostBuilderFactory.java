package by.training.xml_xsd_web_parsing.service;

import by.training.xml_xsd_web_parsing.service.papser.dom.PostsDOMBuilder;
import by.training.xml_xsd_web_parsing.service.papser.sax.PostsSAXBuilder;
import by.training.xml_xsd_web_parsing.service.papser.stax.PostsStAXBuilder;

public class PostBuilderFactory {

    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractPostsBuilder createPostBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new PostsDOMBuilder();
            case STAX:
                return new PostsStAXBuilder();
            case SAX:
                return new PostsSAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());

        }
    }
}
