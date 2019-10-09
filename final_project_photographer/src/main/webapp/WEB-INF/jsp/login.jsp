<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link type="text/css" href="<c:url value="/css/common.css" />" rel="stylesheet">
    <link type="text/css" href="<c:url value="/css/login.css" />" rel="stylesheet">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container-fluid h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-sm-6 col-md-5 col-lg-4 col-xl-4">
            <div class="login-form my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Вход</h5>
                    <form class="needs-validation" novalidate>
                        <div class="form-group">
                            <label for="inputName">Введите логин:</label>
                            <input type="text" class="form-control" id="inputName" placeholder="Логин" required
                                   pattern="admin|user">
                            <div class="invalid-feedback">
                                Введен некорректный логин.
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Введите пароль:</label>
                            <input type="password" id="inputPassword" class="form-control" placeholder="Пароль" required
                                   pattern="admin|user">
                            <div class="invalid-feedback">
                                Не пароль.
                            </div>
                        </div>
                        <div class="text-center">
                            <button class="btn btn-outline-secondary text-uppercase" type="submit"
                                    onclick="checkLogIn()">Войти
                            </button>
                        </div>
                        <hr class="my-4">
                        Если вы еще не зарегистрировны перейдите на форму <a href="#">регистрации</a>
                    </form>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>


</body>
</html>
