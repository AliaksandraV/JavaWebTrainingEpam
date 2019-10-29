<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.messages" var="lang"/>
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/webfonts/all.css"/>">
    <!-- Java script -->
    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 col-lg-3 navbar-container bg-light">
            <jsp:include page="leftMenu.jsp"/>
<%--            <!-- Вертикальное меню -->--%>
<%--            <nav class="navbar navbar-expand-md navbar-light">--%>
<%--                <c:url value="/home" var="homeUrl"/>--%>
<%--                <a class="navbar-brand" href="${homeUrl}">← <fmt:message key="menu_back_to_site" bundle="${lang}"/></a>--%>
<%--                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar"--%>
<%--                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--                    <span class="navbar-toggler-icon"></span>--%>
<%--                </button>--%>
<%--                <div class="collapse navbar-collapse" id="navbar">--%>
<%--                    <!-- Пункты вертикального меню -->--%>
<%--                    <ul class="navbar-nav">--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#link-1"><fmt:message key="menu_admin_portfolio" bundle="${lang}"/></a>--%>
<%--                        </li>--%>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#link-2"><fmt:message key="menu_admin_album" bundle="${lang}"/></a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </nav>--%>
        </div>
        <div class="col-md-9 col-lg-9 container">
            <!-- Основной контент страницы  -->
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Photo preview</th>
                    <th scope="col">Name</th>
                    <th scope="col">List of albums</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="category" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td class="w-25">
                            <div class="thumbnail">
                                <img class="img-fluid" src="<%=request.getContextPath()%>${category.coverImagePath}"
                                     alt="Image"/>
                            </div>
                        </td>
                        <td>
                                ${category.localizedName.russian}
                        </td>
                        <td>
                            <c:forEach items="${category.albumList}" var="album" varStatus="loop">
                                ${album.nameEntity.russian}
                                <br>
                            </c:forEach>
                        </td>
                        <td>
                            <a href="#" class="btn btn-primary btn-size"><i class="far fa-eye"></i></a>
                            <a href="#" class="btn btn-success btn-size"><i class="fas fa-edit"></i></a>
                            <a href="#" class="btn btn-danger btn-size"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    $('img').each(function (_, img) {
        var $this = $(this);

        if ($this.height() > $this.width()) {
            $this.addClass('portrait');
        }
    });
</script>

</body>
