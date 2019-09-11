package by.training.xml_xsd_web_parsing.model;

import by.training.xml_xsd_web_parsing.posts.Post;
import by.training.xml_xsd_web_parsing.service.AbstractPostsBuilder;
import by.training.xml_xsd_web_parsing.service.PostBuilderFactory;

import java.util.Set;

public class BuilderModel {

    private final AbstractPostsBuilder builder;
    private final Set<Post> posts;

    public BuilderModel(String xmlHandlerType) {
        PostBuilderFactory sFactory = new PostBuilderFactory();
        builder = sFactory.createPostBuilder(xmlHandlerType);
        builder.buildSetPosts("data/posts.xml");
        posts = builder.getStudents();
    }

    public Set<Post> getPosts() {
        return posts;
    }
}
