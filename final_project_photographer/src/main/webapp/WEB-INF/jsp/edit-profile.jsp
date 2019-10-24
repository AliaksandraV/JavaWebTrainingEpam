<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n.messages" var="lang"/>
<html lang="${language}">
<head>
    <title>Edit</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">
    <!-- Java script -->
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
            <form class="needs-validation" action="${pageContext.request.contextPath}/confirm-edit-profile" method="post"
                  oninput='repeatPassword.setCustomValidity(repeatPassword.value != password.value ? "Passwords do not match." : "")'
                  onsubmit="submitRegistrationForm(event)"
                  id="editProfile"
                  novalidate>

                <div class="form-group row">
                    <label for="inputEmailProfile" class="col-sm-4 col-form-label px-0 py-0 align-self-center">
                        <fmt:message key="profile_your_email_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-8 px-0 py-0 align-self-center">
                        <input name="email" type="email" class="form-control form-control-lg" id="inputEmailProfile"
                               value="${user.email}"
                               pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                               placeholder="<fmt:message key="profile_your_email_placeholder" bundle="${lang}"/>" required>
                    </div>
                    <div class="invalid-feedback text-center" id="emailClientFeedback">
                        <fmt:message key="profile_your_email_empty" bundle="${lang}"/>
                    </div>
                    <%--                    <div class="invalid-feedback text-center" id="emailServerFeedback">--%>
                    <%--                        <fmt:message key="reg_email_exist" bundle="${lang}"/>--%>
                    <%--                    </div>--%>
                </div>

                <div class="form-group row">
                    <label for="inputNameProfile" class="col-sm-4 col-form-label px-0 py-0 align-self-center">
                        <fmt:message key="profile_your_name_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-8 px-0 py-0 align-self-center">
                        <input name="name" type="text" class="form-control form-control-lg align-self-center"
                               id="inputNameProfile"
                               value="${user.name}"
                               pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                               placeholder="<fmt:message key="profile_your_name_placeholder" bundle="${lang}"/>" required>
                    </div>
                    <div class="invalid-feedback text-center" id="inputNameWrong">
                        <fmt:message key="profile_your_name_wrong" bundle="${lang}"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputPhoneProfile" class="col-sm-4 col-form-label px-0 py-0 align-self-center">
                        <fmt:message key="profile_your_phone_label" bundle="${lang}"/>:
                    </label>
                    <div class="col-sm-8 px-0 py-0 align-self-center">
                        <input name="phone" type="text" class="form-control form-control-lg" id="inputPhoneProfile"
                               value="${user.phoneNumber}"
                               pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$"
                               placeholder="<fmt:message key="profile_your_phone_placeholder" bundle="${lang}"/>" required>
                    </div>
                    <div class="invalid-feedback text-center" id="inputPhoneWrong">
                        <fmt:message key="profile_your_phone_wrong" bundle="${lang}"/>
                    </div>
                </div>
                <p>
                <div class="row text-center">
                    <div class="col-4">
                    </div>
                    <div class="col-8 px-0 py-0">
                        <button class="btn btn-info btn-sm btn-block" type="button" data-toggle="collapse" data-target="#collapseExample"
                                aria-expanded="false" aria-controls="collapseExample">
                            <fmt:message key="profile_change_pass_btn" bundle="${lang}"/>
                        </button>
                    </div>
                </div>
                </p>
                <div class="collapse" id="collapseExample">
                    <div class="form-group row">
                        <label for="inputNewPassProfile" class="col-sm-4 col-form-label px-0 py-0 align-self-center">
                            <fmt:message key="profile_new_pass_label" bundle="${lang}"/>:
                        </label>
                        <div class="col-sm-8 px-0 py-0 align-self-center">
                            <input name="new-password" type="password" class="form-control form-control-lg"
                                   id="inputNewPassProfile"
                                   minlength="8"
                                   placeholder="<fmt:message key="profile_new_pass_placeholder" bundle="${lang}"/>" required>
                        </div>
                        <div class="invalid-feedback text-center" id="inputNewPassWrong">
                            <fmt:message key="profile_new_pass_wrong" bundle="${lang}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="inputRepeatPassProfile" class="col-sm-4 col-form-label px-0 py-0 align-self-center">
                            <fmt:message key="profile_repeat_new_pass_label" bundle="${lang}"/>:
                        </label>
                        <div class="col-sm-8 px-0 py-0 align-self-center">
                            <input name="new-password" type="password" class="form-control form-control-lg"
                                   id="inputRepeatPassProfile"
                                   placeholder="<fmt:message key="profile_repeat_new_pass_placeholder" bundle="${lang}"/>"
                                   required>
                        </div>
                        <div class="invalid-feedback text-center" id="inputRepeatPassWrong">
                            <fmt:message key="profile_repeat_new_pass_wrong" bundle="${lang}"/>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="row text-center">
                    <div class="col">
                        <c:url value="/home" var="homeUrl"/>
                        <a href="${homeUrl}" id="cancel" name="cancel" class="btn btn-primary">
                            <fmt:message key="profile_btn_cancel" bundle="${lang}"/>
                        </a>
                        <button class="btn btn-primary" type="submit">
                            <fmt:message key="profile_btn_save" bundle="${lang}"/>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
