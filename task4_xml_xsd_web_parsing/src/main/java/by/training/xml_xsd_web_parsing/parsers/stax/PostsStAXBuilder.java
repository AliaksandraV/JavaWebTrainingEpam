package by.training.xml_xsd_web_parsing.parsers.stax;

import by.training.xml_xsd_web_parsing.parsers.PostEnum;
import by.training.xml_xsd_web_parsing.posts.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import static by.training.xml_xsd_web_parsing.service.DataConverter.stringToDataXMLGregorianCalendar;
import static by.training.xml_xsd_web_parsing.service.DataConverter.stringToYearXMLGregorianCalendar;

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
        try {
            post.setYear(stringToYearXMLGregorianCalendar(reader.getAttributeValue(null, PostEnum.YEAR.getValue())));
        } catch (ParseException | DatatypeConfigurationException e) {
            e.printStackTrace();
        }
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
                        case COUNTRY:
                            post.setCountry(getXMLText(reader));
                            break;
                        case VALUABLE:
                            post.setValuable(getXMLText(reader));
                            break;
                        case ADDRESS_TO:
                            post.setAddressTo(getXMLAddress(reader));
                            break;
                        case RECIPIENT:
                            post.setRecipient(getXMLText(reader));
                            break;
                        case ARTISTS:
                            post.setArtists(getXMLArtists(reader));
                            break;
                        case TYPE:
                            post.setType(getXMLType(reader));
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
        throw new XMLStreamException("Unknown element in tag Post");
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
                        case ZIP_CODE:
                            address.setZipCode(getXMLText(reader));
                            break;
                        case COUNTRY:
                            address.setCountry(getXMLText(reader));
                            break;
                        case CITY:
                            address.setCity(getXMLText(reader));
                            break;
                        case STREET:
                            address.setStreet(getXMLText(reader));
                            break;
                        case HOUSE:
                            address.setHouse(Integer.parseInt(getXMLText(reader)));
                            break;
                        case APARTMENTS:
                            address.setApartments(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PostEnum.valueOf(name.toUpperCase()) == PostEnum.ADDRESS_TO
                            || PostEnum.valueOf(name.toUpperCase()) == PostEnum.ADDRESS_FROM) {
                        return address;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private Type getXMLType(XMLStreamReader reader) throws XMLStreamException {
        Type postType = null;
        String nameType = reader.getAttributeValue(null, PostEnum.TYPE.getValue());
        if (nameType.equals("Congratulation")) {
            postType = new Congratulation();
        } else if (nameType.equals("Ordinary")) {
            postType = new Ordinary();
        } else if (nameType.equals("Advertising")) {
            postType = new Advertising();
        }
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PostEnum.valueOf(name.toUpperCase())) {
                        case ADDRESS_FROM:
                            postType.setAddressFrom(getXMLAddress(reader));
                            break;
                        case TEXT:
                            postType.setText(getXMLText(reader));
                            break;
                        case AUTHOR:
                            postType.setAuthor(getXMLText(reader));
                            break;
                        case DATE:
                            try {
                                postType.setDate(stringToDataXMLGregorianCalendar(getXMLText(reader)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            } catch (DatatypeConfigurationException e) {
                                e.printStackTrace();
                            }
                            break;
                        case PRODUCT:
                            ((Advertising) postType).setProduct(getXMLText(reader));
                            break;
                        case EVENT:
                            ((Congratulation) postType).setEvent(getXMLText(reader));
                            break;
                        case THEME:
                            ((Ordinary) postType).setTheme(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PostEnum.valueOf(name.toUpperCase()) == PostEnum.TYPE) {
                        return postType;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Type");
    }

    private ArtistList getXMLArtists(XMLStreamReader reader) throws XMLStreamException {
        ArtistList artistList = new ArtistList();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PostEnum.valueOf(name.toUpperCase())) {
                        case ARTIST:
                            artistList.getArtists().add(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PostEnum.valueOf(name.toUpperCase()) == PostEnum.ARTISTS) {
                        return artistList;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Type");
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
