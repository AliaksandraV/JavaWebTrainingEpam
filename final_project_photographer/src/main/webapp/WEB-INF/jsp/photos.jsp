<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.messages" var="lang"/>
<html lang="${language}">
<head>
    <title>Photos</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/tether.min.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/style.css"/>">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/mobirise-icons.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/bootstrap-grid.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/bootstrap-reboot.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/gallery-style.css"/>">

    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/dropdown-style.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/minicart-theme.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/theme-style.css"/>">--%>
    <%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/photos/mbr-additional.css"/>">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">



</head>
<body>


<div class="container">
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    <hr>
    тут будут хлебные крошки
    <hr>
</div>

<section class="mbr-gallery mbr-gallery-filter" id="gallery2-53"
         data-rv-view="5406">
    <div class="container">
        <div><!-- Filter -->
            <div class="mbr-gallery-row">
                <div class="mbr-gallery-layout-default">
                    <div>
                        <div>
                            <c:forEach items="${photos}" var="photo" varStatus="loop">
                                <div class="mbr-gallery-item mbr-gallery-item--p5">
                                    <div href="#lb-gallery2-53" data-slide-to="${loop.index}" data-toggle="modal">
                                        <img src="<%=request.getContextPath()%>${photo.path}" alt="Image not found">
                                        <span class="icon-focus"></span>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

            <div data-app-prevent-settings="" class="mbr-slider modal fade carousel slide" tabindex="-1"
                 data-keyboard="true" data-interval="false" id="lb-gallery2-53">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
                            <div class="carousel-inner">
                                <c:forEach items="${photos}" var="photo" varStatus="loop">
                                    <div class="carousel-item">
                                        <img src="<%=request.getContextPath()%>${photo.path}" alt="Image not found">
                                    </div>
                                </c:forEach>
                            </div>

                            <a class="carousel-control carousel-control-prev" role="button" data-slide="prev"
                               href="#lb-gallery2-53">
                                <span class="mbri-left mbr-iconfont"
                                      aria-hidden="true">

                                </span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control carousel-control-next"
                               role="button" data-slide="next"
                               href="#lb-gallery2-53">
                                <span
                                        class="mbri-right mbr-iconfont"
                                        aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                            <a
                                    class="close" href="#" role="button"
                                    data-dismiss="modal">
                                <span class="sr-only">Close</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

        <ul class="pagination justify-content-center" style="margin:20px">
            <c:forEach begin="1" end="${pagination.totalPages}" varStatus="loop">
                <li class="page-item <c:if test="${pagination.currentPage == loop.index}">active</c:if>" ><a class="page-link" href="?page=${loop.index}">${loop.index}</a></li>
            </c:forEach>
        </ul>



<%--<section class="mbr-gallery mbr-gallery-filter" id="gallery2-53"--%>
<%--         data-rv-view="5406">--%>
<%--    <div class="container">--%>
<%--        <div><!-- Filter -->--%>
<%--            <div class="mbr-gallery-row">--%>
<%--                <div class="mbr-gallery-layout-default">--%>
<%--                    <div>--%>
<%--                        <div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="0" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="7" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/brooke-lark-207271-2000x1333.jpg" alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="1" data-toggle="modal">--%>
<%--                                    <img src="http://static1.gophotoweb.com/u8852/11210/photos/888615/1500-21206241022d04e51c75b9f680d297fe.jpg"--%>
<%--                                         alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="2" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/jake-young-168598.jpg" alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="3" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/timothy-paul-smith-351366.jpg" alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="4" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/ken-cheung-256045-2000x1333.jpg" alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="5" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/carlos-dominguez-342207-2000x1333.jpg"--%>
<%--                                         alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="mbr-gallery-item mbr-gallery-item--p2">--%>
<%--                                <div href="#lb-gallery2-53" data-slide-to="6" data-toggle="modal">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/maranatha-pizarras-342562-2000x1333.jpg"--%>
<%--                                         alt="">--%>
<%--                                    <span class="icon-focus"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clearfix"></div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div data-app-prevent-settings="" class="mbr-slider modal fade carousel slide" tabindex="-1"--%>
<%--                 data-keyboard="true" data-interval="false" id="lb-gallery2-53">--%>
<%--                <div class="modal-dialog">--%>
<%--                    <div class="modal-content">--%>
<%--                        <div class="modal-body">--%>
<%--                            <div class="carousel-inner">--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/hannah-busing-307816.jpg" alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/andre-thomas-weller-333032-800x1200.jpg"--%>
<%--                                         alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/jake-young-168598.jpg" alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/timothy-paul-smith-351366.jpg" alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item active">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/ken-cheung-256045-2000x1333.jpg" alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/carlos-dominguez-342207-2000x1333.jpg"--%>
<%--                                         alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/maranatha-pizarras-342562-2000x1333.jpg"--%>
<%--                                         alt="">--%>
<%--                                </div>--%>
<%--                                <div class="carousel-item">--%>
<%--                                    <img src="<%=request.getContextPath()%>/img/brooke-lark-207271-2000x1333.jpg" alt="">--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <a class="carousel-control carousel-control-prev" role="button" data-slide="prev"--%>
<%--                               href="#lb-gallery2-53">--%>
<%--                                <span class="mbri-left mbr-iconfont"--%>
<%--                                      aria-hidden="true">--%>

<%--                                </span>--%>
<%--                                <span class="sr-only">Previous</span>--%>
<%--                            </a>--%>
<%--                            <a class="carousel-control carousel-control-next"--%>
<%--                               role="button" data-slide="next"--%>
<%--                               href="#lb-gallery2-53">--%>
<%--                                <span--%>
<%--                                        class="mbri-right mbr-iconfont"--%>
<%--                                        aria-hidden="true"></span>--%>
<%--                                <span class="sr-only">Next</span>--%>
<%--                            </a>--%>
<%--                            <a--%>
<%--                                    class="close" href="#" role="button"--%>
<%--                                    data-dismiss="modal">--%>
<%--                                <span class="sr-only">Close</span>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>

<script src="<c:url value="/js/photos/jquery.min.js"/>"></script>
<script src="<c:url value="/js/photos/popper.min.js"/>"></script>
<%--<script src="<c:url value="/js/photos/tether.min.js"/>"></script>--%>
<script src="<c:url value="/js/photos/bootstrap.min.js"/>"></script>
<%--<script src="<c:url value="/js/photos/dropdown-script.min.js"/>"></script>--%>
<%--<script src="<c:url value="/js/photos/minicart.js"/>"></script>--%>
<%--<script src="<c:url value="/js/photos/jquery.easing.min.js"/>"></script>--%>
<%--<script src="<c:url value="/js/photos/minicart-customizer.js"/>"></script>--%>
<%--<script src="<c:url value="/js/photos/jquery.mb.vimeo_player.js"/>"></script>--%>
<%--<script src="<c:url value="/js/photos/smooth-scroll.js"/>"></script>--%>
<script src="<c:url value="/js/photos/masonry.pkgd.min.js"/>"></script>
<script src="<c:url value="/js/photos/imagesloaded.pkgd.min.js"/>"></script>
<script src="<c:url value="/js/photos/bootstrap-carousel-swipe.js"/>"></script>
<%--<script src="<c:url value="/js/photos/jquery.touch-swipe.min.js"/>"></script>--%>
<script src="<c:url value="/js/photos/themes-script.js"/>"></script>
<%--<script src="<c:url value="/js/photos/player.min.js"/>"></script>--%>
<script src="<c:url value="/js/photos/gallery-script.js"/>"></script>
<%--<script src="<c:url value="/js/photos/slidervideo-script.js"/>"></script>--%>

</body>
</html>
