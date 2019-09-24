<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 2019-09-23
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Portfolio</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://fonts.fontstorage.com/import/vollkorn.css">
    <link rel="stylesheet" href="../css/portfolio.css">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<%--<jsp:include page="menu.jsp"></jsp:include>--%>
Путь к контексту : ${ pageContext.request.contextPath } <br/>
Имя хоста : ${ header["host"] }<br/>
Тип и кодировка контента : ${pageContext.response.contentType}<br/>
Кодировка ответа : ${pageContext.response.characterEncoding}<br/>
ID сессии : ${pageContext.request.session.id}<br/>
Время создания сессии в мсек : ${pageContext.request.session.creationTime}<br/>
Время последнего доступа к сессии : ${pageContext.request.session.lastAccessedTime}<br/>
Имя сервлета : ${pageContext.servletConfig.servletName}

</body>
</html>
