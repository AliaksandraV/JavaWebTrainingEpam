<%@include file="headers.jsp" %>
<html>
<head>
    <title>Language selector</title>
</head>
<body>
    <c:url value="/language" var="languageUrl"/>
    <form class="language-form" method="post" action="${languageUrl}">
        <select id="language" name="language" onchange="submit()">
            <option value="ru" ${language == 'ru' ? 'selected' : ''}
                    data-content='<span class="flag-icon flag-icon-us"></span> Russian'>Russian
            </option>
            <option value="en" ${language == 'en' || language == 'en_US' ? 'selected' : ''}
                    data-content='<span class="flag-icon flag-icon-ru"></span> English'>English
            </option>
        </select>
    </form>
</body>
</html>
