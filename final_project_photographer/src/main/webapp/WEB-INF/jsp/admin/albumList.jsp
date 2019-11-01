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
    <title>Admin</title>
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
    <script>
        $(document).ready(function () {
            $('#confirm-delete').on('show.bs.modal', function(e) {
                $(this).find('.btn-primary').attr('href', $(e.relatedTarget).data('href'));
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3 col-lg-3 navbar-container bg-light">
            <jsp:include page="leftMenu.jsp"/>
        </div>
        <div class="col-md-9 col-lg-9 container">
            <div class="text-right m-2">
                <input type="hidden" name="albums" value="${albums}"/>
                <c:url value="/admin/album/create" var="createUrl"/>
                <a href="${createUrl}" class="btn btn-primary align-self-center">+ Create new album</a>
            </div>
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${albums}" var="album" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index+1}</th>
                            <td>
                                    ${album.nameEntity.russian}
                            </td>
                            <td>
                                    ${album.descriptionEntity.russian}
                            </td>
                            <td>
                                    ${album.photoCategory.localizedName.russian}
                            </td>
                            <td>
<%--                                <c:url value="/admin/album/edit/${album.id}" var="editAlbumUrl"/>--%>
<%--                                <a href="${editAlbumUrl}" class="btn btn-success btn-size mb-1" id="editAlbumBtn">--%>
<%--                                    <i class="fas fa-edit"></i>--%>
<%--                                </a>--%>
                                <c:url value="/admin/album/delete/${album.id}" var="deleteAlbumUrl"/>
                                <a href="#" class="btn btn-danger btn-size mb-1" data-href="${deleteAlbumUrl}" data-toggle="modal" data-target="#confirm-delete">
                                    <i class="far fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
            </div>
            <div class="modal-body"> Do you want to delete this? </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>
                <a href="#" class="btn btn-primary">YES</a> </div>
        </div>
    </div>
</div>
</body>
</html>
