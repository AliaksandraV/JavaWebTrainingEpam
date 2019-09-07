package by.training.xml_xsd_web_parsing.service.papser.stax;

public class StAXRunner {

    public static void main(String[] args) {
        PostsStAXBuilder staxBuilder = new PostsStAXBuilder();
        staxBuilder.buildSetPosts("data/posts.xml");
        System.out.println(staxBuilder.getPosts());
    }
}
