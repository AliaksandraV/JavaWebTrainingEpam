<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Home</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">--%>
    <link type="text/css" href="<c:url value="/css/home-page.css" />" rel="stylesheet">
<%--    <link href="../../css/home-page.css" rel="stylesheet" type="text/css"/>--%>
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="main-page fullscreen-preview">
<div class="container-fluid">
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>

    <div class="row align-items-end">
        <h2 class="element-heading-title">
            “Запечатляю моменты<br>
            вашей жизни!”
        </h2>
    </div>
</div>


</body>
</html>
