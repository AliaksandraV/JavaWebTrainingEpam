<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n.messages" var="lang"/>
<html lang="${language}">
<head>
    <title>menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css"/>">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.1.0/css/flag-icon.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#submitLogin').click(function(){
                var dataBack = ('#loginModal #inputEmail').val().trim();
                $('#result').html(dataBack);

            });
        });
    </script>
</head>
<body class="home">
<header>
    <div class="container">
        <div id="result">

        </div>
        <div class="row justify-content-center align-self-center">
            <a class="justify-content-center" href="home">
                <img src="<%=request.getContextPath()%>/img/logo.png" class="img-responsive"/></a>
        </div>
        <div class="mynavbar">
            <ul class="nav justify-content-center nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-home-tab" href="home"
                       role="tab" aria-controls="pills-home"
                       aria-selected="true"><fmt:message key="menu_home" bundle="${lang}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-profile-tab" href="portfolio"
                       role="tab" aria-controls="pills-profile" aria-selected="false"><fmt:message key="menu_portfolio" bundle="${lang}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="pills-contact-tab" href="contact"
                       role="tab"
                       aria-controls="pills-contact"
                       aria-selected="false"><fmt:message key="menu_contact" bundle="${lang}"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="modal" data-target="#loginModal" id="pills-login-tab" href="#"
                       role="tab" aria-controls="pills-login"
                       aria-selected="false"><fmt:message key="menu_login" bundle="${lang}"/></a>
                </li>
            </ul>
        </div>
        <div class="row">
            <form>
                <select id="language" name="language" onchange="submit()">
                    <option value="ru" ${language == 'ru' ? 'selected' : ''} data-content='<span class="flag-icon flag-icon-us"></span> English'>Russian</option>
                    <option value="en" ${language == 'en' ? 'selected' : ''} data-content='<span class="flag-icon flag-icon-ru"></span> Russian'></span>English</option>
                </select>
            </form>
        </div>
    </div>
</header>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">

                        <h5 class="modal-title w-100" id="modalLabel">Вход</h5>

                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>


            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="form-group">
                            <label for="inputEmail">
                                Email address
                            </label>
                            <input class="form-control" id="inputEmail" name="email" type="email"
                                   aria-describedby="emailHelp" placeholder="Email">
                            <small id="emailHelp" class="form-text text-muted">
                                Enter your email
                            </small>
                        </div>
                        <div class="form-group">
                            <label for="inputPass">
                                Password
                            </label>
                            <input class="form-control" id="inputPass" name="password" type="password"
                                   placeholder="Password">
                            <small id="passHelp" class="form-text text-muted">
                                Password must contain 10 symbols
                            </small>
                        </div>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" class="form-check-input">
                                Remember me
                            </label>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" id="submitLogin" type="submit">
                                Enter
                            </button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                Close
                            </button>
                        </div>
                        <hr>
                        <h5>text</h5>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>
