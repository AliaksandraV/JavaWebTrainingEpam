package by.training.xml_xsd_web_parsing.parsers.sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXSimpleMain {
    public static void main(String[] args) {
        try {
            // создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            PostHandler handler = new PostHandler();
            reader.setContentHandler(handler);
            reader.parse("data/posts.xml");
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }
    }
}
