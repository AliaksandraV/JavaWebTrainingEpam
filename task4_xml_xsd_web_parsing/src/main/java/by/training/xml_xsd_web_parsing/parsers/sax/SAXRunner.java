package by.training.xml_xsd_web_parsing.parsers.sax;

public class SAXRunner {

    public static void main(String[] args) {
        PostsSAXBuilder saxBuilder = new PostsSAXBuilder();
        saxBuilder.buildSetPosts("data/posts.xml");
        System.out.println(saxBuilder.getPosts());
    }
}
