<%@include file="../common/headers.jsp" %>
<html>
<head>
    <title>Create album</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/admin.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/webfonts/all.css"/>">
    <!-- Java script -->
    <script src="<c:url value="/js/portfolio/jquery-3.4.1.js"/>"></script>
    <script src="<c:url value="/js/portfolio/popper.min.js"/>"></script>
    <script src="<c:url value="/js/portfolio/bootstrap.js"/>"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 col-lg-3 navbar-container bg-light">
            <jsp:include page="leftMenu.jsp"/>
        </div>

        <div class="col-md-9 col-lg-9 container">
            <div class="text-center m-3">
                <h3>Create new album</h3>
                <hr>
            </div>
            <form class="needs-validation" action="${pageContext.request.contextPath}/addAlbum" method="post"
                  enctype="multipart/form-data"
                  id="createAlbum"
                  novalidate>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Name</label>
                        <input type="text" class="form-control" id="inputName">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCategory">Category</label>
                        <select id="inputCategory" class="form-control" required>
                            <c:forEach items="${categories}" var="category" varStatus="loop">
                                <option>${category.localizedName.russian}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDescroption">Description</label>
                    <textarea class="form-control" id="inputDescroption" rows="3"></textarea>
                </div>
<%--                <div class="form-group">--%>
<%--                    <label for="inputFile">Choose photo for album</label>--%>
<%--                    <div class="custom-file">--%>
<%--                        <input type="file" class="custom-file-input" id="inputFile">--%>
<%--                        <label class="custom-file-label" for="inputFile">Click here to load file...</label>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="form-group">
                <input type="file" name="file" value="Select images..."/>
<%--                <input type="submit" value="start"/>--%>
                </div>

                <button type="submit" class="btn btn-primary float-right">Create</button>

            </form>
        </div>
    </div>
</div>

</body>
</html>
