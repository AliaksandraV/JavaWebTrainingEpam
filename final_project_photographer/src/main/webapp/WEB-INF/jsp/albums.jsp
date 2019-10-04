<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<html>
<head>
    <title>Albums</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio-page.css"/>">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    <hr>
    <h3> Albums information: </h3>
    <c:forEach items="${albums}" var="albums">
        <%--        ${albums.date}<br>--%>
        ${albums.nameEntity.russian}<br>
        ${albums.descriptionEntity.russian}<br>
        ${albums.photoCategory.localizedName.russian}<br>
    </c:forEach>

    <div>
        <ctg:table-revenue rows="${ album_list.size }" head="Revenue">
            ${ album_list.album}
        </ctg:table-revenue>
    </div>
</div>


</body>
</html>
