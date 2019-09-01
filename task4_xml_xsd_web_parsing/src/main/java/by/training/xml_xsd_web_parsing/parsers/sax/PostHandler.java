package by.training.xml_xsd_web_parsing.parsers.sax;

import by.training.xml_xsd_web_parsing.posts.ImageTheme;
import by.training.xml_xsd_web_parsing.posts.Post;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PostHandler extends DefaultHandler {
    private Set<Post> posts;
    private Post current = null;
    private PostEnum currentEnum = null;
    private EnumSet<PostEnum> withText;

    public PostHandler() {
        posts = new HashSet<Post>();
        withText = EnumSet.range(PostEnum.IMAGE_THEME, PostEnum.EVENT);
    }

    public Set<Post> getPosts() {
        return posts;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    //TODO тут пересмотреть работу с атрибутами
    //TODO сделать так что бы атрибуты могли идти в разном порядке
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
                currentEnum = temp;
            }
        }
    }

    @Override
    public void characters(final char[] ch, final int start, final int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case IMAGE_THEME:
                    current.setImageTheme(ImageTheme.fromValue(s));
                    break;
                case VALUABLE:
                    current.setValuable(s);
                    break;
                case ADDRESS_TO:
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
                    current.setRecipient(s);
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
                    current.setCountry(s);
                    break;

                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if ("post".equals(localName)) {
            posts.add(current);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nParsing ended");
    }

}
