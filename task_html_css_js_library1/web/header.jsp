<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Header</title>

    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header-container">

    <div class="site-name">Models Shop</div>
    <div class="header-bar">

    <c:if test="${pageContext.request.userPrincipal == null}">
        <a href="${pageContext.request.contextPath}/login">Login</a>
        |
        <a href="${pageContext.request.contextPath}/registration">Registration</a>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal != null}">
        Hello
        <a href="${pageContext.request.contextPath}/accountInfo">${pageContext.request.userPrincipal.name} </a>
            |
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>

    </div>
</div>

</body>
</html>
