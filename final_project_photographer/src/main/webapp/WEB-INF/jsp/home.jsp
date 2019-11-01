<%@include file="common/headers.jsp" %>

<html lang="${language}">
<head>
    <title>Home</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link type="text/css" href="<c:url value="/css/home-page.css" />" rel="stylesheet">
    <!-- Java script -->
    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
</head>
<body class="main-page fullscreen-preview">

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<div class="container fixed-bottom" style="margin-left: 20px">
<div class="row">
    <div class="position-sticky fixed-bottom">
        <h2 class="element-heading-title">
            <fmt:message key="home_text_1" bundle="${lang}"/><br>
            <fmt:message key="home_text_2" bundle="${lang}"/><br>
        </h2>
    </div>
</div>
</div>
</body>
</html>
