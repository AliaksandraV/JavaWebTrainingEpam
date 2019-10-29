<%@include file="common/headers.jsp" %>
<html>
<head>
    <title>Contact</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/webfonts/all.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">
    <style>
        .parent-row {
            -ms-flex-align: center !important
        }
    </style>
    <!-- Java script -->
    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<hr>
<div class="container-fluid">
    <div class="row h-75 justify-content-center align-items-center parent-row">
        <div class="col-md-9 col-lg-6 flex-xs-middle">
            <div>
                <p class="text-center contact-text align-items-center">
                    <fmt:message key="contact-text-1" bundle="${lang}"/><br><br>
                    <fmt:message key="contact-text-2" bundle="${lang}"/><br><br>
                    <fmt:message key="contact-text-3" bundle="${lang}"/><br><br>
                </p>
            </div>
            <div class="text-center contact-text">
                    <fmt:message key="contact-me" bundle="${lang}"/>:<br>
                    <fmt:message key="contact-phone" bundle="${lang}"/>: &nbsp
                    <a href="tel: +11111111111"> +1 (111) 111-11-11</a><br>
                    <fmt:message key="contact-mail" bundle="${lang}"/>: &nbsp
                    <a href="mailto: example@mail.ru">example@mail.ru</a><br>
            </div>
            <div class="text-center m-2">
                <!--Instagram-->
                <a href="https://www.instagram.com/nantali_photograph/" class="btn-lg btn-primary"><i class="fab fa-instagram"></i></a>
                <!--Vkontakte-->
                <a href="https://vk.com/id33137636" class="btn-lg btn-primary"><i class="fab fa-vk"></i></a>
                <!--Facebook-->
                <a href="https://www.facebook.com/natallia.gerasimova.56" class="btn-lg btn-primary"><i class="fab fa-facebook"></i></a>
            </div>
        </div>
        <div class="col-sm-9 col-md-8 col-lg-6">
            <div class="thumbnail" style="height: 100%">
                <img class="img-responsive " src="<%=request.getContextPath()%>/img/contacts-page-img.jpg"
                     alt="Image"/>
            </div>
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
</html>
