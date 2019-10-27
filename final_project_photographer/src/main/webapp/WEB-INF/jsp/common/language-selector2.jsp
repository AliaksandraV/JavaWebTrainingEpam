<%@include file="headers.jsp" %>

<html>
<head>
    <title>Language selector</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css">

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/menu.css"/>">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(function () {
                $('.selectpicker').selectpicker();
            });
        });
    </script>
</head>
<body>
<form class="language-form ">
    <select id="language" name="language" onchange="submit()" class="selectpicker" data-width="fit">
        <option value="ru" ${language == 'ru' ? 'selected' : ''}
                data-content='<span class="flag-icon flag-icon-ru"></span> Russian'>Russian
        </option>
        <option value="en" ${language == 'en' ? 'selected' : ''}
                data-content='<span class="flag-icon flag-icon-us"></span> English'>English
        </option>
    </select>
</form>
</body>
</html>
