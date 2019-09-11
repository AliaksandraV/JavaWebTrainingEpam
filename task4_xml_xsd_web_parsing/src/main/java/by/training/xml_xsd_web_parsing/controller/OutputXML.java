package by.training.xml_xsd_web_parsing.controller;

import by.training.xml_xsd_web_parsing.model.BuilderModel;
import by.training.xml_xsd_web_parsing.posts.Post;
import by.training.xml_xsd_web_parsing.service.AbstractPostsBuilder;
import by.training.xml_xsd_web_parsing.service.PostBuilderFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/home")
public class OutputXML extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PostBuilderFactory sFactory = new PostBuilderFactory();
        AbstractPostsBuilder builder = sFactory.createPostBuilder("sax");


//        builder.buildSetPosts(getServletContext().getRealPath("")+"data/posts.xml");
        builder.buildSetPosts(getServletContext().getRealPath("")+"WEB-INF/posts.xml");
        builder.buildSetPosts(getServletContext().getResource("data/posts.xml").getPath());
        Set<Post> posts = builder.getStudents();
        System.out.println();

//        BuilderModel model = new BuilderModel("sax");
//        Set<Post> posts = model.getPosts();
        request.setAttribute("userNames", posts);


//        List<String> names = new ArrayList<>();
//        names.add("one");
//        names.add("two");
//        names.add("three");
//        request.setAttribute("userNames", names);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("new.jsp");
        requestDispatcher.forward(request, response);
    }

}
