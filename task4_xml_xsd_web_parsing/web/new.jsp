<%@ page import="by.training.xml_xsd_web_parsing.posts.Post" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 2019-09-09
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Тело
<%
    Set<Post> posts = (Set<Post>) request.getAttribute("userNames");
    if (posts != null && !posts.isEmpty()) {
        for (Post s : posts) {
            out.println("<li>" + s.getId() + "</li>");
        }
    } else out.println("<p>There are no users yet!</p>");
//    List<String> names = (List<String>) request.getAttribute("userNames");
//    if (names != null && !names.isEmpty()) {
//        out.println("<ui>");
//        for (String s : names) {
//            out.println("<li>" + s + "</li>");
//        }
//        out.println("</ui>");
//    } else out.println("<p>There are no users yet!</p>");
%>
</body>
</html>
