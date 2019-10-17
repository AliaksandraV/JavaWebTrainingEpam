<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.messages" var="lang"/>
<html lang="${language}">
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">

    <script src="<c:url value="/js/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/popper.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<hr>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-8">

            <form class="needs-validation" action="${pageContext.request.contextPath}/signup" method="post" novalidate>

                <div class="form-group row">
                    <label for="inputEmail" class="col-sm-2 col-form-label">
                        <fmt:message key="reg_email_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-10">
                        <input name="email" type="text" class="form-control" id="inputEmail"
                               placeholder="<fmt:message key="reg_email_label" bundle="${lang}"/>">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputPassword" class="col-sm-2 col-form-label">
                        <fmt:message key="reg_pass_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-10">
                        <input name="password" type="text" class="form-control" id="inputPassword"
                               placeholder="<fmt:message key="reg_pass_label" bundle="${lang}"/>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="repeatPassword" class="col-sm-2 col-form-label">
                        <fmt:message key="reg_repeat_pass_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-10">
                        <input name="repeatPassword" type="text" class="form-control" id="repeatPassword"
                               placeholder="<fmt:message key="reg_repeat_pass_label" bundle="${lang}"/>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputName" class="col-sm-2 col-form-label">
                        <fmt:message key="reg_name_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-10">
                        <input name="name" type="text" class="form-control" id="inputName"
                               placeholder="<fmt:message key="reg_name_label" bundle="${lang}"/>">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPhone" class="col-sm-2 col-form-label">
                        <fmt:message key="reg_phone_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-10">
                        <input name="phone" type="text" class="form-control" id="inputPhone"
                               placeholder="<fmt:message key="reg_phone_label" bundle="${lang}"/>">
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Submit form</button>
            </form>
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
