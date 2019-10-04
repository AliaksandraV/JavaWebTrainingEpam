<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css"/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body class="home">
<header>
    <div class="container">
        <div class="row justify-content-center align-self-center">
            <a class="justify-content-center" href="home">
                <img src="<%=request.getContextPath()%>/img/logo.png" class="img-responsive"/></a>
        </div>
        <div class="mynavbar">
            <ul class="nav justify-content-center nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-home-tab" href="home"
                       role="tab" aria-controls="pills-home"
                       aria-selected="true">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-profile-tab" href="portfolio"
                       role="tab" aria-controls="pills-profile" aria-selected="false">Портфолио</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-contact-tab" href="contact"
                       role="tab"
                       aria-controls="pills-contact"
                       aria-selected="false">Контакты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-login-tab" href="#pills-login" role="tab" aria-controls="pills-login"
                       aria-selected="false">Вход</a>
                </li>
            </ul>
        </div>
    </div>
</header>

</body>
</html>
