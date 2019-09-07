package by.training.xml_xsd_web_parsing.service.papser.sax;

import by.training.xml_xsd_web_parsing.posts.Post;
import by.training.xml_xsd_web_parsing.service.AbstractPostsBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class PostsSAXBuilder extends AbstractPostsBuilder {

//    private Set<Post> posts;
    private PostSAXHandler sh;
    private XMLReader reader;

    public PostsSAXBuilder() {
        // создание SAX-анализатора
        sh = new PostSAXHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public PostsSAXBuilder (Set<Post> posts) {
        super(posts);
        sh = new PostSAXHandler();
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

    @Override
    public void buildSetPosts(String fileName) {
        System.out.println("SAX");

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

