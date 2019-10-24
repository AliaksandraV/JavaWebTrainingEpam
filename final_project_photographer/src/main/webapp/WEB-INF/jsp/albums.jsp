<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n.messages" var="lang"/>
<html lang="${language}">
<head>
    <title>Albums</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/albums-page.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">
    <!-- Java script -->
    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    <hr>
    тут будут хлебные крошки
    <hr>
</div>

<section class="gallery-block cards-gallery">
    <div class="container">
        <div class="row">
            <c:forEach items="${albums}" var="album" varStatus="loop">
                <div class="col-sm-10 col-md-6 col-lg-4">
                    <div class="card border-0 transform-on-hover">
                        <c:url value="/photos" var="photosUrl"/>
                        <a class="lightbox" href="${photosUrl}/${album.id}?page=1">
                            <div class="thumbnail">
                                <img src="<%=request.getContextPath()%>${album.coverImagePath}"
                                     alt="Image"/>
                            </div>
                        </a>
                        <div class="card-body">
                            <h6>
                                <c:if test="${album.nameEntity==null}">
                                    <fmt:message key="no_name" bundle="${lang}"/>
                                </c:if>
                                    ${album.nameEntity.russian}
                            </h6>
                                <%--<p class="text-muted card-text">${album.descriptionEntity.russian}</p>--%>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>


<section class="gallery-block cards-gallery">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/img/wedding.jpg"
                             alt="Image"/>
                    </div>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit
                            amet, consectetur
                            adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/img/pregnancy.jpg"
                             alt="Image"/>
                    </div>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit
                            amet</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/img/baby.jpg"
                             alt="Image"/>
                    </div>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit
                            amet, consectetur
                            adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-10 col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/img/wedding.jpg"
                             alt="Image"/>
                    </div>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit
                            amet, consectetur
                            adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/img/pregnancy.jpg"
                             alt="Image"/>
                    </div>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit
                            amet</p>
                    </div>
                </div>
            </div>
            <div class="col-sm-10 col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="thumbnail">
                        <img src="<%=request.getContextPath()%>/img/baby.jpg"
                             alt="Image"/>
                    </div>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit
                            amet, consectetur
                            adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>

</section>


<script>
    $('img').each(function (_, img) {
        var $this = $(this);

        if ($this.height() > $this.width()) {
            $this.addClass('portrait');
        }
    });
</script>

</body>
</html>
