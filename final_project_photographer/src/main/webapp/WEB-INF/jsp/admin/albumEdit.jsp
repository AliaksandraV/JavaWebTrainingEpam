<%@include file="../common/headers.jsp" %>
<html>
<head>
    <title>Album</title>
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
            <form class="needs-validation" action="${pageContext.request.contextPath}/admin/album/add"
                  method="post"
                  enctype="multipart/form-data"
                  id="createAlbum"
                  novalidate>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Name</label>
                        <input type="text" class="form-control" id="inputName" value="${album.nameEntity.russian}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputCategory">Category</label>
                        <select id="inputCategory" class="form-control" required>
                            <c:forEach items="${categories}" var="album" varStatus="loop">
                                <c:choose>
                                    <c:when test="${album.photoCategory.id == album.id}">
                                        <option selected>${album.localizedName.russian}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${album.localizedName.russian}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDescroption">Description</label>
                    <textarea class="form-control" id="inputDescroption" rows="3"
                              name="descriotionText">${album.descriptionEntity.russian}</textarea>
                </div>
                <div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Photo path</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${album.photoList}" var="photo" varStatus="loop">
                            <tr>
                                <th scope="row">${loop.index+1}</th>
                                <td>
                                        ${photo.path}
                                </td>
                                <td>
<%--                                    <a href="#" class="btn btn-danger btn-size mb-1" id="deleteAlbumBtn">--%>
<%--                                        <i class="far fa-trash-alt"></i>--%>
<%--                                    </a>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group">
                    <label for="inputPhotos">Choose photos: </label>
                    <input type="file" name="photos" multiple="multiple" id="inputPhotos"/>
                    <%--                <input type="submit" value="start"/>--%>
                </div>

                <div class="text-right">
                    <c:url value="/admin/album" var="adminAlbumUrl"/>
                    <a href="${adminAlbumUrl}" id="cancel" name="cancel" class="btn btn-secondary">
                        <fmt:message key="profile_btn_cancel" bundle="${lang}"/>
                    </a>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>

    </div>
</div>

</body>
</html>
