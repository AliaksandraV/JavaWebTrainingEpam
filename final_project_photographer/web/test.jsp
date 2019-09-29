<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 2019-09-25
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home-page.css"/>">
</head>
<body class="home">

<div>
    <img src="../img/gallery-image-1-440x327.jpg" class="img-fluid" alt="Адаптивные изображения">
</div>

<a class="navbar-brand" href="../view/main.html"><img src="img/logo.png"></a>
<a class="navbar-brand" href="../view/main.html"><img src="<%=request.getContextPath()%>img/logo.png"></a>
<a class="navbar-brand" href="../view/main.html"><img src="<%=request.getContextPath()%>/img/logo.png"></a>

    <h2>test</h2>

</body>
</html>
