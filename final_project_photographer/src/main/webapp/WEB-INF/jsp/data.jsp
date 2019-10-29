<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Love story</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>${categories.get(1).getCoverImagePath()}" alt="Image">
    </div>
</div>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Свадебные</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>/img/wedding.jpg" alt="Image">
    </div>
</div>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Портреты</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>/img/portrait.jpg" alt="Image">
    </div>
</div>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Семейная</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>/img/family.jpg" alt="Image">
    </div>
</div>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Студия</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>/img/studio.jpg" alt="Image">
    </div>
</div>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Дети</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>/img/baby.jpg" alt="Image">
    </div>
</div>
<div class="swiper-slide" style="width: 465px; margin-right: 20px;">
    <div class="image-wrap">
        <div class="image-info">
            <h2 class="mb-3">Беременность</h2>
            <a href="single.html" class="btn btn-outline-white py-2 px-4">More Photos</a>
        </div>
        <img src="<%=request.getContextPath()%>/img/pregnancy.jpg" alt="Image">
    </div>
</div>
</body>
</html>
