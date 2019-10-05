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
    <%--    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/fonts/icomoonstyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/magnific-popup.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/jquery-ui.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/owl.carousel.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/owl.theme.default.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/lightgallery.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/bootstrap-datepicker.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/swiper.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/aos.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/portfolio-page.css"/>">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<hr>

<div class="container-fluid aos-init aos-animate" data-aos-delay="500">
    <div class="swiper-container images-carousel swiper-container-horizontal swiper-container-free-mode">
        <div class="swiper-wrapper" style="transform: translate3d(-2425px, 0px, 0px); transition-duration: 0ms;">
            <div class="swiper-slide" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Nature</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>
            <div class="swiper-slide" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">People</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>

            <div class="swiper-slide" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Portrait</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>
            <div class="swiper-slide" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Architecture</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>
            <div class="swiper-slide swiper-slide-prev" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Animals</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>
            <div class="swiper-slide swiper-slide-active" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Sports</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="Image">
                </div>
            </div>
            <div class="swiper-slide swiper-slide-next" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Travel</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>
            <div class="swiper-slide swiper-slide-next" style="width: 465px; margin-right: 20px;">
                <div class="image-wrap">
                    <div class="image-info">
                        <h2 class="mb-3">Travel</h2>
                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
                    </div>
                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Image">
                </div>
            </div>
        </div>
        <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets"><span
                class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 1"></span><span
                class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 2"></span><span
                class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 3"></span><span
                class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 4"></span><span
                class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 5"></span><span
                class="swiper-pagination-bullet swiper-pagination-bullet-active" tabindex="0" role="button"
                aria-label="Go to slide 6"></span></div>
        <div class="swiper-button-prev" tabindex="0" role="button" aria-label="Previous slide"
             aria-disabled="false"></div>
        <div class="swiper-button-next swiper-button-disabled" tabindex="0" role="button" aria-label="Next slide"
             aria-disabled="true"></div>
        <div class="swiper-scrollbar"></div>
        <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
</div>

<%--<hr>--%>


<%--<div class="container-fluid">--%>
<%--    <div class="swiper-container">--%>
<%--        <div class="row swiper-wrapper " &lt;%&ndash;style="transform: translate3d(0px, 0px, 0px);"&ndash;%&gt;>--%>

<%--            <div class=" col-md-6 col-xl-4 swiper-slide " &lt;%&ndash; style="width: 456.667px; margin-right: 20px;"&ndash;%&gt;>--%>
<%--                <div class="image-wrap">--%>
<%--                    &lt;%&ndash;                    <div class="image-info">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <h2 class="mb-3">Nature</h2>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="Responsive image">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-md-6 col-xl-4 swiper-slide swiper-slide-next" &lt;%&ndash;style="width: 456.667px; margin-right: 20px;"&ndash;%&gt;>--%>
<%--                <div class="image-wrap">--%>
<%--                    &lt;%&ndash;                    <div class="image-info">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <h2 class="mb-3">Portrait</h2>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    <img src="<%=request.getContextPath()%>/img/img1.jpg" alt="Responsive image">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class=" col-md-4 col-xl-4 swiper-slide " &lt;%&ndash;style="width: 456.667px; margin-right: 20px;"&ndash;%&gt;>--%>
<%--                <div class="image-wrap">--%>
<%--                    &lt;%&ndash;                    <div class="image-info">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <h2 class="mb-3">Nature</h2>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="Responsive image">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</div>--%>

<%--<hr>--%>

<%--<div class="container-fluid">--%>
<%--    <div class="row  p-wraper">--%>
<%--        <div class="col-md-5 col-xl-4">--%>
<%--            <div class="image-wrap" style="object-fit: cover">--%>
<%--                <img src="<%=request.getContextPath()%>/img/img1.jpg" class="img-fluid" alt="Responsive image">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-6 col-xl-4">--%>
<%--            <div class="image-wrap" style="object-fit: cover">--%>
<%--                <img src="<%=request.getContextPath()%>/img/wedding.jpg" class="img-fluid" alt="Responsive image">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-6 col-xl-4">--%>
<%--            <div class="image-wrap" style="object-fit: cover">--%>
<%--                <img src="<%=request.getContextPath()%>/img/img1.jpg" class="img-fluid" alt="Responsive image">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--</div>--%>

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



<script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/js/jquery-migrate-3.0.1.min.js"/>"></script>
<script src="<c:url value="/js/jquery-ui.js"/>"></script>
<script src="<c:url value="/js/popper.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/js/jquery.stellar.min.js"/>"></script>
<script src="<c:url value="/js/jquery.countdown.min.js"/>"></script>
<script src="<c:url value="/js/jquery.magnific-popup.min.js"/>"></script>
<script src="<c:url value="/js/swiper.min.js"/>"></script>
<script src="<c:url value="/js/aos.js"/>"></script>
<script src="<c:url value="/js/picturefill.min.js"/>"></script>
<script src="<c:url value="/js/lightgallery-all.min.js"/>"></script>
<script src="<c:url value="/js/jquery.mousewheel.min.js"/>"></script>

<script src="<c:url value="/js/main.js"/>"></script>

<script>
    $(document).ready(function () {
        $('#lightgallery').lightGallery();
    });
</script>


</body>
</html>




