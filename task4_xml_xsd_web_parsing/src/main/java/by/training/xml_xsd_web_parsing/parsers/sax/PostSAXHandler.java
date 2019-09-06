package by.training.xml_xsd_web_parsing.parsers.sax;

import by.training.xml_xsd_web_parsing.parsers.PostEnum;
import by.training.xml_xsd_web_parsing.posts.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.text.ParseException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static by.training.xml_xsd_web_parsing.service.DataConverter.stringToDataXMLGregorianCalendar;

public class PostSAXHandler extends DefaultHandler {
    private Set<Post> posts;
    private Post current = null;
    private Address address = null;
    private Type type = null;
    private ArtistList artistList = null;
    private PostEnum postEnum = null;
    private EnumSet<PostEnum> withText;

    public PostSAXHandler() {
        posts = new HashSet<Post>();
        withText = EnumSet.range(PostEnum.IS_SENT, PostEnum.PRODUCT);
    }

    public Set<Post> getPosts() {
        return posts;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if ("post".equals(localName)) {
            current = new Post();
            current.setId(attrs.getValue(0));

            if (attrs.getLength() == 3) {
                current.setIsSent(Boolean.valueOf(attrs.getValue(1)));
                try {
                    current.setYear(DatatypeFactory.newInstance().newXMLGregorianCalendar(attrs.getValue(2)));
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
            }
        } else {
            PostEnum temp = PostEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                postEnum = temp;
            }
        }

        if ("type".equals(localName)) {
            if (attrs.getValue(0).equals("Congratulation")) {
                type = new Congratulation();
            } else if (attrs.getValue(0).equals("Advertising")) {
                type = new Advertising();
            } else if (attrs.getValue(0).equals("Ordinary")) {
                type = new Ordinary();
            }
        }

        if ("address_to".equals(localName)) {
            address = new Address();
        }

        if ("address_from".equals(localName)) {
            address = new Address();
        }

        if ("artists".equals(localName)) {
            artistList = new ArtistList();
        }

    }

    @Override
    public void characters(final char[] ch, final int start, final int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (postEnum != null) {
            switch (postEnum) {
                case IMAGE_THEME:
                    current.setImageTheme(ImageTheme.fromValue(s));
                    break;
                case COUNTRY:
                    if (current.getCountry() == null) {
                        current.setCountry(s);
                    }
                    if (address != null) {
                        address.setCountry(s);
                    }
                    break;
                case VALUABLE:
                    current.setValuable(s);
                    break;
                case ADDRESS_TO:
                    break;
                case RECIPIENT:
                    current.setRecipient(s);
                    break;
                case ARTISTS:
                    break;
                case ARTIST:
                    artistList.getArtists().add(s);
                    break;
                case TYPE:
                    current.setType(type);
                    break;
                case ADDRESS_FROM:
                    break;
                case TEXT:
                    type.setText(s);
                    break;
                case AUTHOR:
                    type.setAuthor(s);
                    break;
                case DATE:
                    try {
                        type.setDate(stringToDataXMLGregorianCalendar(s));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (DatatypeConfigurationException e) {
                        e.printStackTrace();
                    }
                    break;
                case EVENT:
                    ((Congratulation) type).setEvent(s);
                    break;
                case THEME:
                    ((Ordinary) type).setTheme(s);
                    break;
                case PRODUCT:
                    ((Advertising) type).setProduct(s);
                    break;
                case ZIP_CODE:
                    address.setZipCode(s);
                    break;
                case CITY:
                    address.setCity(s);
                    break;
                case STREET:
                    address.setStreet(s);
                    break;
                case HOUSE:
                    address.setHouse(Integer.valueOf(s));
                    break;
                case APARTMENTS:
                    address.setApartments(Integer.valueOf(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(postEnum.getDeclaringClass(), postEnum.name());
            }
        }
        postEnum = null;
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if ("post".equals(localName)) {
            posts.add(current);
        }
        if ("address_to".equals(localName)) {
            current.setAddressTo(address);
            address = null;
        }
        if ("address_from".equals(localName)) {
            type.setAddressFrom(address);
            address = null;
        }
        if ("artists".equals(localName)) {
            current.setArtists(artistList);
            artistList = null;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nParsing ended");
    }

}
