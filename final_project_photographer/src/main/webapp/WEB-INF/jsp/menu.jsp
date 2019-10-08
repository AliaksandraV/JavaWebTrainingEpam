<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css"/>">
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
                    <a class="nav-link" data-toggle="modal" data-target="#loginModal" id="pills-login-tab" href="#"
                       role="tab" aria-controls="pills-login"
                       aria-selected="false">Вход</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Вход</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form>
                        <div class="form-group">
                            <label for="inputEmail">
                                Email address
                            </label>
                            <input class="form-control" id="inputEmail" type="email"
                                   aria-describedby="emailHelp" placeholder="Email">
                            <small id="emailHelp" class="form-text text-muted">
                                Enter your email
                            </small>
                        </div>
                        <div class="form-group">
                            <label for="inputPass">
                                Password
                            </label>
                            <input class="form-control" id="inputPass" type="password"
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
                    </form>
                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>
