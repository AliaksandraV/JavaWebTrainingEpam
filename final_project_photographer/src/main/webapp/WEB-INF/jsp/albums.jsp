<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<html>
<head>
    <title>Albums</title>
    <!-- Required meta tag -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/common.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/albums-page.css"/>">
    <!-- Java script -->
    <script src="//code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
    <hr>
    тут будут хлебные крошки
    <hr>
</div>

<section class="gallery-block cards-gallery">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <div class="preview img"
                         style="height: 240px; background-image: url(<%=request.getContextPath()%>/img/pregnancy.jpg); background-size: cover; opacity: 1;">
                        <!--  --></div>
<%--                    <a class="lightbox" href="images/F1.jpg"><img src="<%=request.getContextPath()%>/img/pregnancy.jpg"--%>
<%--                                                                  class="card-img-top"></a>--%>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <a class="lightbox" href="images/F2.jpg"><img src="<%=request.getContextPath()%>/img/baby.jpg"
                                                                  class="card-img-top"></a>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <a class="lightbox" href="images/F3.jpg"><img src="<%=request.getContextPath()%>/img/family.jpg"
                                                                  class="card-img-top"></a>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <a class="lightbox" href="images/F4.jpg"><img src="<%=request.getContextPath()%>/img/portrait.jpg"
                                                                  class="card-img-top"></a>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <a class="lightbox" href="images/F5.jpg"><img src="<%=request.getContextPath()%>/img/wedding.jpg"
                                                                  class="card-img-top"></a>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-4">
                <div class="card border-0 transform-on-hover">
                    <a class="lightbox" href="images/F6.jpg"><img src="<%=request.getContextPath()%>/img/studio.jpg"
                                                                  class="card-img-top"></a>
                    <div class="card-body">
                        <h6>Lorem Ipsum</h6>
                        <p class="text-muted card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc
                            quam urna.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script>
    baguetteBox.run('.cards-gallery', {animation: 'slideIn'});
</script>
<%--<h3> Albums information: </h3>--%>
<%--<c:forEach items="${albums}" var="albums">--%>
<%--    &lt;%&ndash;        ${albums.date}<br>&ndash;%&gt;--%>
<%--    ${albums.nameEntity.russian}<br>--%>
<%--    ${albums.descriptionEntity.russian}<br>--%>
<%--    ${albums.photoCategory.localizedName.russian}<br>--%>
<%--</c:forEach>--%>

<%--пример использования тэгов--%>
<%--    <div>--%>
<%--        <ctg:table-revenue rows="${ album_list.size }" head="Revenue">--%>
<%--            ${ album_list.album}--%>
<%--        </ctg:table-revenue>--%>
<%--    </div>--%>
</body>
</html>
