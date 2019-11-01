<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/headers.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Вертикальное меню -->
<div class="navbar-container bg-light">
    <nav class="navbar navbar-expand-md navbar-light">
        <c:url value="/home" var="homeUrl"/>
        <a class="navbar-brand" href="${homeUrl}">← <fmt:message key="menu_back_to_site" bundle="${lang}"/></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar">
            <!-- Пункты вертикального меню -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <c:url value="/admin/album" var="adminAlbumUrl"/>
                    <a class="nav-link" href="${adminAlbumUrl}"><fmt:message key="menu_admin_album" bundle="${lang}"/></a>
                </li>
                <li class="nav-item">
                    <c:url value="/admin/category" var="adminCategoryUrl"/>
                    <a class="nav-link" href="${adminCategoryUrl}"><fmt:message key="menu_admin_portfolio"
                                                                                bundle="${lang}"/></a>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
