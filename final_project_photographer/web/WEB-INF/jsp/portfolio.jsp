<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio-page.css"/>">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    <hr>


    <h3> Cetegories information: </h3>
    <c:forEach items="${categories}" var="category">
        ${category.localizedName.russian}<br>
        ${category.coverImagePath}<br>
    </c:forEach>








<%--    <div class="isotope thumb-ruby-wrap wow fadeIn isotope--loaded" data-isotope-layout="masonry"--%>
<%--         data-isotope-group="gallery" data-lightgallery="group"--%>
<%--         style="position: relative; height: 714px; visibility: visible; animation-name: fadeIn;">--%>
<%--        <div class="row">--%>
<%--            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 isotope-item"--%>
<%--                 style="position: absolute; left: 0px; top: 0px;">--%>
<%--                <a class="thumb-ruby thumb-mixed_height-2 thumb-mixed_md"--%>
<%--                   href="" data-lightgallery="item"><img--%>
<%--                        class="thumb-ruby__image" src="../../img/gallery-image-1-440x327.jpg" alt="" width="440"--%>
<%--                        height="327">--%>
<%--                    <div class="thumb-ruby__caption">--%>
<%--                        <p class="thumb-ruby__title heading-3">Jane &amp; James</p>--%>
<%--                        <p class="thumb-ruby__text">If you are looking for high quality wedding photography, I will be--%>
<%--                            glad--%>
<%--                            to help you.--%>
<%--                            <!-- Portfolio-->--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 isotope-item"--%>
<%--                 style="position: absolute; left: 360px; top: 0px;"><a--%>
<%--                    class="thumb-ruby thumb-mixed_height-3 thumb-mixed_md"--%>
<%--                    href="images/gallery-image-9-1200x800-original.jpg" data-lightgallery="item"><img--%>
<%--                    class="thumb-ruby__image" src="images/gallery-image-9-444x683.jpg" alt="" width="444" height="683">--%>
<%--                <div class="thumb-ruby__caption">--%>
<%--                    <p class="thumb-ruby__title heading-3">George &amp; Kate</p>--%>
<%--                    <p class="thumb-ruby__text">If you are looking for high quality wedding photography, I will be glad--%>
<%--                        to--%>
<%--                        help you.--%>
<%--                        <!-- Portfolio-->--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            </div>--%>
<%--            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 isotope-item"--%>
<%--                 style="position: absolute; left: 720px; top: 0px;"><a--%>
<%--                    class="thumb-ruby thumb-mixed_height-2 thumb-mixed_md"--%>
<%--                    href="images/gallery-image-15-1200x801-original.jpg" data-lightgallery="item"><img--%>
<%--                    class="thumb-ruby__image" src="images/gallery-image-15-440x327.jpg" alt="" width="440" height="327">--%>
<%--                <div class="thumb-ruby__caption">--%>
<%--                    <p class="thumb-ruby__title heading-3">Beach Wedding</p>--%>
<%--                    <p class="thumb-ruby__text">If you are looking for high quality wedding photography, I will be glad--%>
<%--                        to--%>
<%--                        help you.--%>
<%--                        <!-- Portfolio-->--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            </div>--%>
<%--            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 isotope-item"--%>
<%--                 style="position: absolute; left: 1080px; top: 0px;"><a--%>
<%--                    class="thumb-ruby thumb-mixed_height-3 thumb-mixed_md"--%>
<%--                    href="images/gallery-image-10-835x1200-original.jpg" data-lightgallery="item"><img--%>
<%--                    class="thumb-ruby__image" src="images/gallery-image-10-444x683.jpg" alt="" width="444" height="683">--%>
<%--                <div class="thumb-ruby__caption">--%>
<%--                    <p class="thumb-ruby__title heading-3">Feelings</p>--%>
<%--                    <p class="thumb-ruby__text">If you are looking for high quality wedding photography, I will be glad--%>
<%--                        to--%>
<%--                        help you.--%>
<%--                        <!-- Portfolio-->--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            </div>--%>
<%--            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 isotope-item"--%>
<%--                 style="position: absolute; left: 0px; top: 357px;"><a--%>
<%--                    class="thumb-ruby thumb-mixed_height-2 thumb-mixed_md"--%>
<%--                    href="images/gallery-image-14-1200x800-original.jpg" data-lightgallery="item"><img--%>
<%--                    class="thumb-ruby__image" src="images/gallery-image-14-440x327.jpg" alt="" width="440" height="327">--%>
<%--                <div class="thumb-ruby__caption">--%>
<%--                    <p class="thumb-ruby__title heading-3">Ann’s Story</p>--%>
<%--                    <p class="thumb-ruby__text">If you are looking for high quality wedding photography, I will be glad--%>
<%--                        to--%>
<%--                        help you.--%>
<%--                        <!-- Portfolio-->--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            </div>--%>
<%--            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 isotope-item"--%>
<%--                 style="position: absolute; left: 720px; top: 357px;"><a--%>
<%--                    class="thumb-ruby thumb-mixed_height-2 thumb-mixed_md"--%>
<%--                    href="images/gallery-image-2-1200x800-original.jpg" data-lightgallery="item"><img--%>
<%--                    class="thumb-ruby__image" src="images/gallery-image-2-440x327.jpg" alt="" width="440" height="327">--%>
<%--                <div class="thumb-ruby__caption">--%>
<%--                    <p class="thumb-ruby__title heading-3">Lisa’s Wedding</p>--%>
<%--                    <p class="thumb-ruby__text">If you are looking for high quality wedding photography, I will be glad--%>
<%--                        to--%>
<%--                        help you.--%>
<%--                        <!-- Portfolio-->--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

</div>
</body>
</html>
