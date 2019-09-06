package by.training.xml_xsd_web_parsing.parsers.stax;

import by.training.xml_xsd_web_parsing.parsers.PostEnum;
import by.training.xml_xsd_web_parsing.posts.Address;
import by.training.xml_xsd_web_parsing.posts.ImageTheme;
import by.training.xml_xsd_web_parsing.posts.Post;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PostsStAXBuilder {

    private HashSet<Post> posts = new HashSet<>();
    private XMLInputFactory inputFactory;

    public PostsStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (PostEnum.valueOf(name.toUpperCase()) == PostEnum.POST) {
                        Post st = buildPost(reader);
                        posts.add(st);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Post buildPost(XMLStreamReader reader) throws XMLStreamException {
        Post post = new Post();
        post.setId(reader.getAttributeValue(null, PostEnum.ID.getValue()));
        post.setIsSent(Boolean.valueOf(reader.getAttributeValue(null, PostEnum.IS_SENT.getValue()))); // проверить на null
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PostEnum.valueOf(name.toUpperCase())) {
                        case IMAGE_THEME:
                            post.setImageTheme(ImageTheme.fromValue(getXMLText(reader)));
                            break;
                        case VALUABLE:
                            post.setValuable(getXMLText(reader));
                            break;
                        case ADDRESS_TO:
                            post.setAddressTo(getXMLAddress(reader));
                            break;
                        case ZIP_CODE:
                            break;
                        case CITY:
                            break;
                        case STREET:
                            break;
                        case HOUSE:
                            break;
                        case APARTMENTS:
                            break;
                        case RECIPIENT:
                            post.setRecipient(getXMLText(reader));
                            break;
                        case ARTISTS:
                            break;
                        case ARTIST:
                            break;
                        case TYPE:
                            break;
                        case ADDRESS_FROM:
                            break;
                        case TEXT:
                            break;
                        case AUTHOR:
                            break;
                        case DATE:
                            break;
                        case EVENT:
                            break;
                        case THEME:
                            break;
                        case PRODUCT:
                            break;
                        case COUNTRY:
                            post.setCountry(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PostEnum.valueOf(name.toUpperCase()) == PostEnum.POST) {
                        return post;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Address getXMLAddress(XMLStreamReader reader) throws XMLStreamException {
        Address address = new Address();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PostEnum.valueOf(name.toUpperCase())) {
                        case COUNTRY:
                            address.setCountry(getXMLText(reader));
                            break;
//                        case CITY:
//                            address.setCity(getXMLText(reader));
//                            break;
//                        case STREET:
//                            address.setStreet(getXMLText(reader));
//                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PostEnum.valueOf(name.toUpperCase()) == PostEnum.ADDRESS_TO) {
                        return address;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
