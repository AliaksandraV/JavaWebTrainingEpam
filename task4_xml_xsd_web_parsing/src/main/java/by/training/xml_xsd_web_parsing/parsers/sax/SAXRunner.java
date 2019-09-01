package by.training.xml_xsd_web_parsing.parsers.sax;

import by.training.xml_xsd_web_parsing.posts.Post;

public class SAXRunner {

    public static void main(String[] args) {
        PostsSAXBuilder saxBuilder = new PostsSAXBuilder();
        saxBuilder.buildSetStudents("data/posts.xml");
        for (Post p:saxBuilder.getPosts()) {
            System.out.println(p);
        }
    }
}
