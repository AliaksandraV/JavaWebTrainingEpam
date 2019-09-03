package by.training.xml_xsd_web_parsing.parsers.stax;

public class StAXRunner {

    public static void main(String[] args) {
        PostsStAXBuilder staxBuilder = new PostsStAXBuilder();
        staxBuilder.buildSetStudents("data/posts.xml");
        System.out.println(staxBuilder.getPosts());
    }
}
