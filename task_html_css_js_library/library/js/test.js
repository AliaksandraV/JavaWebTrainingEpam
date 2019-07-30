function loadHeaderAndFooter() {
    if (getCookie("token") == undefined) {
        //добавила эту строку для проверки нахожусь ли я сейчас на странице логина, и если нет, то перехожу
        window.location.href = "login.html";
    }

    if (getCookie("token") == "0") {
        $(function () {
            $("#header").load("../shared/header-user.html");
            $("#footer").load("../shared/footer.html");
        });
    } else if (getCookie("token") == "1") {
        $(function () {
            $("#header").load("../shared/header-admin.html");
            $("#footer").load("../shared/footer.html");
        });
    }
}


function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}