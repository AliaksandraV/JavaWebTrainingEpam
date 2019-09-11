package by.training.xml_xsd_web_parsing.controller;

import by.training.xml_xsd_web_parsing.posts.Post;
import by.training.xml_xsd_web_parsing.service.AbstractPostsBuilder;
import by.training.xml_xsd_web_parsing.service.PostBuilderFactory;

import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        PostBuilderFactory sFactory = new PostBuilderFactory();
        AbstractPostsBuilder builder = sFactory.createPostBuilder("sax");
        builder.buildSetPosts("data/posts.xml");
        Set<Post> posts = builder.getStudents();
        System.out.println(posts);
        System.out.println(builder.getStudents());
    }
}
