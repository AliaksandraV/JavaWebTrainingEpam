package by.training.xml_xsd_web_parsing.parsers.dom;

import by.training.xml_xsd_web_parsing.posts.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import static by.training.xml_xsd_web_parsing.service.DataConverter.*;

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
        } catch (ParseException | DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Post buildPost(Element postElement) throws ParseException, DatatypeConfigurationException {
        Post post = new Post();
        // заполнение объекта student
        post.setId(postElement.getAttribute("id"));
        post.setIsSent(Boolean.valueOf(postElement.getAttribute("is_sent")));
        post.setYear(stringToYearXMLGregorianCalendar(postElement.getAttribute("year")));

        post.setImageTheme(ImageTheme.fromValue(getElementTextContent(postElement, "image_theme")));
        post.setCountry(getElementTextContent(postElement, "country"));
        post.setValuable(getElementTextContent(postElement, "valuable"));

        post.setAddressTo(getXMLAddress(postElement, "address_to"));
        post.setRecipient(getElementTextContent(postElement, "recipient"));

        post.setArtists(getXMLArtistList(postElement));

        post.setType(getXMLType(postElement));


        return post;
    }

    private static Address getXMLAddress(Element postElement, String addressType) {
        Address address = new Address();
        Element addressElement = (Element) postElement.getElementsByTagName(addressType).item(0);
        address.setZipCode(getElementTextContent(addressElement, "zip_code"));
        address.setCountry(getElementTextContent(addressElement, "country"));
        address.setCity(getElementTextContent(addressElement, "city"));
        address.setStreet(getElementTextContent(addressElement, "street"));
        int house = Integer.parseInt(getElementTextContent(addressElement, "house"));
        address.setHouse(house);
        int ap = Integer.parseInt(getElementTextContent(addressElement, "apartments"));
        address.setApartments(ap);
        return address;
    }

    private static ArtistList getXMLArtistList(Element postElement) {
        ArtistList artistList = new ArtistList();
        Element artistElement = (Element) postElement.getElementsByTagName("artists").item(0);

        NodeList nList = artistElement.getElementsByTagName("artist");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            artistList.getArtists().add(node.getTextContent());
        }

        return artistList;
    }

    private static Type getXMLType(Element postElement) throws ParseException, DatatypeConfigurationException {
        Type type = null;
        Element typeElement = (Element) postElement.getElementsByTagName("type").item(0);
        switch (typeElement.getAttribute("xsi:type")) {
            case "Congratulation":
                type = getXMLCongratulation(typeElement);
                break;
            case "Ordinary":
                type = getXMLOrdinary(typeElement);
                break;
            case "Advertising":
                type = getXMLAdvertising(typeElement);
                break;
        }
        return type;
    }

    private static Congratulation getXMLCongratulation(Element typeElement) throws ParseException, DatatypeConfigurationException {
        Congratulation congratulation = new Congratulation();
        putCommonForType(congratulation, typeElement);
        congratulation.setEvent(getElementTextContent(typeElement, "event"));
        return congratulation;
    }

    private static Ordinary getXMLOrdinary(Element typeElement) throws ParseException, DatatypeConfigurationException {
        Ordinary ordinary = new Ordinary();
        putCommonForType(ordinary, typeElement);
        ordinary.setTheme(getElementTextContent(typeElement,"theme"));
        return ordinary;
    }

    private static Advertising getXMLAdvertising(Element typeElement) throws ParseException, DatatypeConfigurationException {
        Advertising advertising = new Advertising();
        putCommonForType(advertising, typeElement);
        advertising.setProduct(getElementTextContent(typeElement,"product"));
        return advertising;
    }

    private static void putCommonForType(Type type, Element typeElement) throws ParseException, DatatypeConfigurationException {
        type.setAuthor(getElementTextContent(typeElement, "author"));
        type.setText(getElementTextContent(typeElement, "text"));
        type.setAddressFrom(getXMLAddress(typeElement, "address_from"));
        type.setDate(stringToDataXMLGregorianCalendar(getElementTextContent(typeElement, "date")));
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }


}
