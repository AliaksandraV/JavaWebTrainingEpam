<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<html>
<head>
    <title>Portfolio</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio-page.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/swiper.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/aos.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<hr>

<div class="container-fluid">
    <div class="swiper-container">
        <div class="row swiper-wrapper " <%--style="transform: translate3d(0px, 0px, 0px);"--%>>

            <div class=" col-md-6 col-xl-4 swiper-slide " <%-- style="width: 456.667px; margin-right: 20px;"--%>>
                <div class="image-wrap">
<%--                    <div class="image-info">--%>
<%--                        <h2 class="mb-3">Nature</h2>--%>
<%--                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>--%>
<%--                    </div>--%>
                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="Responsive image">
                </div>
            </div>
            <div class="col-md-6 col-xl-4 swiper-slide swiper-slide-next" <%--style="width: 456.667px; margin-right: 20px;"--%>>
                <div class="image-wrap">
<%--                    <div class="image-info">--%>
<%--                        <h2 class="mb-3">Portrait</h2>--%>
<%--                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>--%>
<%--                    </div>--%>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Responsive image">
                </div>
            </div>
            <div class=" col-md-4 col-xl-4 swiper-slide " <%--style="width: 456.667px; margin-right: 20px;"--%>>
                <div class="image-wrap">
<%--                    <div class="image-info">--%>
<%--                        <h2 class="mb-3">Nature</h2>--%>
<%--                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>--%>
<%--                    </div>--%>
                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="Responsive image">
                </div>
            </div>
        </div>

    </div>
</div>

<hr>

<div class="container-fluid">
    <div class="row  p-wraper">
        <div class="col-md-5 col-xl-4">
            <div class="image-wrap" style="object-fit: cover">
                <img src="<%=request.getContextPath()%>/img/img1.jpg" class="img-fluid" alt="Responsive image">
            </div>
        </div>
        <div class="col-md-6 col-xl-4">
            <div class="image-wrap" style="object-fit: cover">
                <img src="<%=request.getContextPath()%>/img/wedding.jpg" class="img-fluid" alt="Responsive image">
            </div>
        </div>
        <div class="col-md-6 col-xl-4">
            <div class="image-wrap" style="object-fit: cover">
                <img src="<%=request.getContextPath()%>/img/img1.jpg" class="img-fluid" alt="Responsive image">
            </div>
        </div>
    </div>



</div>

<div class="view overlay zoom">
    <img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/6-col/img%20(131).jpg" class="img-fluid " alt="zoom">
    <div class="mask flex-center waves-effect waves-light">
        <p class="white-text">Zoom effect</p>
    </div>
</div>
<!-- Hoverable -->
<img src="https://mdbootstrap.com/img/Photos/Horizontal/Nature/6-col/img%20(132).jpg" class="img-fluid rounded-circle hoverable"
     alt="hoverable">





<%--<div class="container-fluid">--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-4 col-xl-4 swiper-wrapper">--%>
<%--            <div class="swiper-slide">--%>
<%--                <div class="image-wrap" style="object-fit: cover">--%>
<%--                    <div class="image-info">--%>
<%--                        <h2>Свадьба</h2>--%>
<%--                        <a href="" class="btn btn-outline-white py-2 px-4">Больше фото</a>--%>
<%--                    </div>--%>
<%--                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" class="img-fluid w-100"--%>
<%--                         alt="Responsive image">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-4 col-xl-4">--%>
<%--            <div class="image-wrap">--%>
<%--                <div class="image-info">--%>
<%--                    <h2>Природа</h2>--%>
<%--                    <a href="" class="btn btn-outline-white py-2 px-4">Больше фото</a>--%>
<%--                </div>--%>
<%--                <img src="<%=request.getContextPath()%>/img/img1.jpg" class="img-fluid" alt="Responsive image">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-4 col-xl-4">--%>
<%--            <div class="image-wrap">--%>
<%--                <div class="image-info">--%>
<%--                    <h2>Природа</h2>--%>
<%--                    <a href="" class="btn btn-outline-white py-2 px-4">Больше фото</a>--%>
<%--                </div>--%>
<%--                <img src="<%=request.getContextPath()%>/img/img1.jpg" class="img-fluid img-r" alt="Responsive image">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</div>--%>


<%--<hr>--%>
<%--<div class="container-fluid">--%>
<%--    <h3> Cetegories information: </h3>--%>
<%--    <c:forEach items="${categories}" var="category">--%>
<%--        <a href="album" class=""> ${category.localizedName.russian}<br></a>--%>
<%--        ${category.coverImagePath}<br>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<script>
    $(function () {
        $("#mdb-lightbox-ui").load("mdb-addons/mdb-lightbox-ui.html");
    });
</script>


</body>
</html>




