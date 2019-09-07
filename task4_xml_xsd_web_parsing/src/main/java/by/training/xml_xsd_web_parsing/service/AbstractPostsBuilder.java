package by.training.xml_xsd_web_parsing.service;

import by.training.xml_xsd_web_parsing.posts.Post;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPostsBuilder {
    protected Set<Post> posts;

    public AbstractPostsBuilder() {
        posts = new HashSet<Post>();
    }

    public AbstractPostsBuilder(Set<Post> students) {
        this.posts = students;
    }

    public Set<Post> getStudents() {
        return posts;
    }

    abstract public void buildSetPosts(String fileName);
}
