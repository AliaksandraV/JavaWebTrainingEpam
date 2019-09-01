package by.training.xml_xsd_web_parsing.parsers.sax;

import by.training.xml_xsd_web_parsing.posts.Post;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class PostsSAXBuilder {

    private Set<Post> posts;
    private PostHandler sh;
    private XMLReader reader;

    public PostsSAXBuilder() {
// создание SAX-анализатора
        sh = new PostHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void buildSetStudents(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        posts = sh.getPosts();

    }
}

