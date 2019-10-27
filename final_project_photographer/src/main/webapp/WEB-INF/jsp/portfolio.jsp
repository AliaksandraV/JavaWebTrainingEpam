<%@include file="common/headers.jsp" %>

<%--<%@ taglib prefix="ctg" uri="customtags" %>--%>
<html lang="${language}">
<head>
    <title>Portfolio</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/fonts/icomoonstyle.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/magnific-popup.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/owl.carousel.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/owl.theme.default.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/swiper.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/aos.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/portfolio/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">
    <!-- Java script -->
    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
<%--    <script src="//code.jquery.com/jquery-3.3.1.js"></script>--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<hr>
<div class="container-fluid aos-init aos-animate" data-aos-delay="500">
    <div class="swiper-container images-carousel swiper-container-horizontal swiper-container-free-mode">
        <div class="swiper-wrapper" style="transform: translate3d(-2425px, 0px, 0px); transition-duration: 0ms;">
            <c:forEach items="${categories}" var="category">
                <div class="swiper-slide" style="width: 465px; margin-right: 20px;">
                    <div class="image-wrap">
                        <div class="image-info">
                            <h2 class="mb-3">${category.localizedName.russian}</h2>
                            <a href="album/${category.id}" class="btn btn-outline-white py-2 px-4"><fmt:message key="more_photos" bundle="${lang}"/></a>
                        </div>
                        <img src="<%=request.getContextPath()%>${category.coverImagePath}" alt="Image">
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets">
            <span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 1"></span>
            <span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 2"></span>
            <span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 3"></span>
            <span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 4"></span>
            <span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 5"></span>
            <span class="swiper-pagination-bullet swiper-pagination-bullet-active" tabindex="0" role="button"
                aria-label="Go to slide 6"></span>
        </div>

        <div class="swiper-button-prev" tabindex="0" role="button" aria-label="Previous slide"
             aria-disabled="false"></div>
        <div class="swiper-button-next swiper-button-disabled" tabindex="0" role="button" aria-label="Next slide"
             aria-disabled="true"></div>
        <div class="swiper-scrollbar"></div>
        <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>
</div>

<script src="<c:url value="/js/portfolio/jquery-migrate-3.0.1.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/jquery.stellar.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/jquery.countdown.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/jquery.magnific-popup.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/swiper.min.js"/>"></script>
<script src="<c:url value="/js/portfolio/aos.js"/>"></script>
<script src="<c:url value="/js/portfolio/main.js"/>"></script>

</body>
</html>




