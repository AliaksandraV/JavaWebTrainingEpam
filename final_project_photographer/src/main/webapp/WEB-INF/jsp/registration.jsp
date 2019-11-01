<%@include file="common/headers.jsp" %>

<html lang="${language}">
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">

    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
    <script src="<c:url value="/js/registration.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>
<hr>

<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-sm-9 col-md-7 col-lg-5">

            <form class="needs-validation" action="${pageContext.request.contextPath}/signup" method="post"
                  oninput='repeatPassword.setCustomValidity(repeatPassword.value != password.value ? "Passwords do not match." : "")'
                  onsubmit="submitRegistrationForm(event)"
                  id="registrationForm"
                  novalidate>

                <div class="form-group">
                    <label for="inputEmail2">
                        <fmt:message key="reg_email_label" bundle="${lang}"/>:
                    </label>
                    <input name="email" type="email" class="form-control form-control-lg" id="inputEmail2"
                           pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                           placeholder="<fmt:message key="reg_email_placeholder" bundle="${lang}"/>" required>
                    <div class="invalid-feedback text-center" id="emailClientFeedback">
                        <fmt:message key="reg_email_not_correct" bundle="${lang}"/>
                    </div>
                    <div class="invalid-feedback text-center" id="emailServerFeedback">
                        <fmt:message key="reg_email_exist" bundle="${lang}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword">
                        <fmt:message key="reg_pass_label" bundle="${lang}"/>:
                    </label>
                    <input name="password" type="password" class="validate form-control form-control-lg" id="inputPassword"
                           minlength="8"
                           placeholder="<fmt:message key="reg_pass_label" bundle="${lang}"/>" required>
                    <div class="invalid-feedback text-center">
                        <fmt:message key="reg_password_wrong" bundle="${lang}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="repeatPassword">
                        <fmt:message key="reg_repeat_pass_label" bundle="${lang}"/>:
                    </label>
                    <input name="repeatPassword" type="password" class="verify form-control form-control-lg"
                           id="repeatPassword"
                           placeholder="<fmt:message key="reg_repeat_pass_label" bundle="${lang}"/>" required>
                    <div class="invalid-feedback text-center">
                        <fmt:message key="reg_repeat_pass_wrong" bundle="${lang}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputName">
                        <fmt:message key="reg_name_label" bundle="${lang}"/>:
                    </label>
                    <input name="name" type="text" class="form-control form-control-lg" id="inputName"
                           placeholder="<fmt:message key="reg_name_label" bundle="${lang}"/>" required>
                    <div class="invalid-feedback text-center">
                        <fmt:message key="reg_name" bundle="${lang}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPhone">
                        <fmt:message key="reg_phone_label" bundle="${lang}"/>:
                    </label>
                    <input name="phone" type="text" class="form-control form-control-lg" id="inputPhone"
                           pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$"
                           placeholder="<fmt:message key="reg_phone_label" bundle="${lang}"/>" required>
                    <div class="invalid-feedback text-center">
                        <fmt:message key="reg_phone" bundle="${lang}"/>
                    </div>
                </div>

                <button class="btn btn-primary float-right" type="submit">Submit form</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
