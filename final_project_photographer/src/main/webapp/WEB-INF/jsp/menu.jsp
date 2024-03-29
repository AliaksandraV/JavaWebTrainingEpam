<%@include file="common/headers.jsp" %>
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css"/>">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.1.0/css/flag-icon.min.css" rel="stylesheet">

    <script type="text/javascript" src="<c:url value="/js/login.js"/>"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#loginModal').on('hidden.bs.modal', function () {
                clearLoginForm();
            })
        });
    </script>
</head>
<body class="home">
<header>
    <div class="container h-15">
        <div id="result">

        </div>
        <div class="row justify-content-center align-self-center">
            <c:url value="/home" var="homeUrl"/>
            <a class="justify-content-center" href="${homeUrl}"><img src="<%=request.getContextPath()%>/img/logo.png" class="img-responsive"/></a>
            <jsp:include page="/WEB-INF/jsp/common/language-selector.jsp"/>
        </div>
        <div class="mynavbar">
            <ul class="nav justify-content-center nav-pills mb-3" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="pills-home-tab" href="${homeUrl}"
                       role="tab" aria-controls="pills-home"
                       aria-selected="true"><fmt:message key="menu_home" bundle="${lang}"/></a>
                </li>
                <li class="nav-item">
                    <c:url value="/portfolio" var="portfolioUrl"/>
                    <a class="nav-link" id="pills-profile-tab" href="${portfolioUrl}"
                       role="tab" aria-controls="pills-profile" aria-selected="false"><fmt:message key="menu_portfolio"
                                                                                                   bundle="${lang}"/></a>
                </li>
                <li class="nav-item">
                    <c:url value="/contact" var="contactUrl"/>
                    <a class="nav-link" id="pills-contact-tab" href="${contactUrl}"
                       role="tab"
                       aria-controls="pills-contact"
                       aria-selected="false"><fmt:message key="menu_contact" bundle="${lang}"/></a>
                </li>
                <c:choose>
                    <c:when test="${empty user}">
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="modal" data-target="#loginModal" id="pills-login-tab" href="#"
                               role="tab" aria-controls="pills-login"
                               aria-selected="false"><fmt:message key="menu_login" bundle="${lang}"/></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarProfileDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <fmt:message key="menu_profile" bundle="${lang}"/>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarProfileDropdown">
                                <c:url value="/profile/edit/${user.id}" var="editProfileUrl"/>
                                <a class="dropdown-item" href="${editProfileUrl}">
                                    <fmt:message key="menu_edit_profile" bundle="${lang}"/>
                                </a>
                                <div class="dropdown-divider"></div>
                                <c:url value="/logout" var="logoutUrl"/>
                                <a class="dropdown-item" href="${logoutUrl}">
                                    <fmt:message key="menu_logout" bundle="${lang}"/>
                                </a>
                            </div>
                        </li>
                        <c:if test="${user.role eq 'ADMIN'}">
                            <li class="nav-item">
                                <c:url value="/admin/album" var="adminUrl"/>
                                <a class="nav-link" id="pills-profile-tab" href="${adminUrl}"
                                   role="tab" aria-controls="pills-profile" aria-selected="false">
                                    <fmt:message key="menu_admin" bundle="${lang}"/>
                                </a>
                            </li>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</header>


<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h5 class="modal-title w-100" id="modalLabel">
                    <fmt:message key="modal_signin_header" bundle="${lang}"/>
                </h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <c:url value="/login" var="loginUrl"/>
                    <form action="${loginUrl}" method="post" id="loginForm" onsubmit="submitLoginForm(event)">
                        <div class="form-group">
                            <label for="inputEmail">
                                <fmt:message key="modal_email_label" bundle="${lang}"/>
                            </label>
                            <input class="form-control" id="inputEmail" name="email" type="email"
                                   aria-describedby="emailHelp"
                                   placeholder="<fmt:message key="modal_email_in" bundle="${lang}"/>">
                            <small id="emailHelp" class="form-text text-muted">
                                <fmt:message key="modal_email_under" bundle="${lang}"/>
                            </small>
                        </div>
                        <div class="form-group">
                            <label for="inputPass">
                                <fmt:message key="modal_password_label" bundle="${lang}"/>
                            </label>
                            <input class="form-control" id="inputPass" name="password" type="password"
                                   placeholder="<fmt:message key="modal_password_in" bundle="${lang}"/>">
                            <small id="passHelp" class="form-text text-muted">
                                <fmt:message key="modal_password_under" bundle="${lang}"/>
                            </small>
                        </div>
                        <div class="invalid-feedback" id="loginFeedback">
                            Invalid username or password!
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" id="submitLogin" type="submit">
                                <fmt:message key="modal_enter_btn" bundle="${lang}"/>
                            </button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                <fmt:message key="modal_close_btn" bundle="${lang}"/>
                            </button>
                        </div>
                        <hr>
                        <c:url value="/registration" var="registrationUrl"/>
                        <a href="${registrationUrl}" class="" role="">
                            <fmt:message key="modal_register" bundle="${lang}"/>
                        </a>
                        <span class="error">${error}</span>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
