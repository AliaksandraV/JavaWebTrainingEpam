package by.training.xml_xsd_web_parsing.controller;

import by.training.xml_xsd_web_parsing.service.AbstractPostsBuilder;
import by.training.xml_xsd_web_parsing.service.PostBuilderFactory;

public class Runner {

    public static void main(String[] args) {
        PostBuilderFactory sFactory = new PostBuilderFactory();
        AbstractPostsBuilder builder = sFactory.createPostBuilder("sax");
        builder.buildSetPosts("data/posts.xml");
        System.out.println(builder.getStudents());
    }
}
