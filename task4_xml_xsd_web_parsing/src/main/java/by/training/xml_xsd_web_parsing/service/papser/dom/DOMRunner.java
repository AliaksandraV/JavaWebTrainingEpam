package by.training.xml_xsd_web_parsing.service.papser.dom;

public class DOMRunner {

    public static void main(String[] args) {
        PostsDOMBuilder domBuilder = new PostsDOMBuilder();
        domBuilder.buildSetPosts("data/posts.xml");
        System.out.println(domBuilder.getPosts());
    }


}
