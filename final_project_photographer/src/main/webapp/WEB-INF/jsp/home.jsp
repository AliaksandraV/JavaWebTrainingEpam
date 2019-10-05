<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="ctgmy" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Home</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link type="text/css" href="<c:url value="/css/home-page.css" />" rel="stylesheet">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="main-page fullscreen-preview">

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<div class="container fixed-bottom">
<div class="row">
    <div class="position-sticky fixed-bottom">
        <h2 class="element-heading-title">
            “Запечатляй моменты<br>
            своей жизни!”
        </h2>
    </div>
</div>
</div>
<%--<ctg:info-time/>--%>

<%--<ctgmy:hellotag message="hooray">--%>

<%--</ctgmy:hellotag>--%>

</body>
</html>
