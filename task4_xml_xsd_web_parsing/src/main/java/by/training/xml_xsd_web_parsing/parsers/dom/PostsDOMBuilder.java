package by.training.xml_xsd_web_parsing.parsers.dom;

import by.training.xml_xsd_web_parsing.posts.Address;
import by.training.xml_xsd_web_parsing.posts.ImageTheme;
import by.training.xml_xsd_web_parsing.posts.Post;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PostsDOMBuilder {
    private Set<Post> posts;
    private DocumentBuilder docBuilder;

    public PostsDOMBuilder() {
        this.posts = new HashSet<Post>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void buildSetPosts(String fileName) {
        try {
            //parsingXML-документа и создание древовидной структуры
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList postsList = root.getElementsByTagName("post");
            for (int i = 0; i < postsList.getLength(); i++) {
                Element postElement = (Element) postsList.item(i);
                Post post = buildPost(postElement);
                posts.add(post);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Post buildPost(Element postElement) {
        Post post = new Post();
        // заполнение объекта student
        post.setId(postElement.getAttribute("id"));
        post.setIsSent(Boolean.valueOf(postElement.getAttribute("is_sent")));
        post.setImageTheme(ImageTheme.fromValue(getElementTextContent(postElement, "image_theme")));
        post.setCountry(getElementTextContent(postElement, "country"));
        post.setValuable(getElementTextContent(postElement, "valuable"));
        Address address = new Address();
        Element addressElement = (Element) postElement.getElementsByTagName("address_to").item(0);
        address.setZipCode(getElementTextContent(addressElement, "zip_code"));
        address.setCountry(getElementTextContent(addressElement, "country"));
        address.setCity(getElementTextContent(addressElement, "city"));
        address.setStreet(getElementTextContent(addressElement, "street"));
        Integer house = Integer.parseInt(getElementTextContent(addressElement, "house"));
        address.setHouse(house);
        Integer ap = Integer.parseInt(getElementTextContent(addressElement, "apartments"));
        address.setApartments(ap);
        post.setAddressTo(address);
        post.setRecipient(getElementTextContent(postElement, "recipient"));
        //TODO заполнение поля Artists
        return post;
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
