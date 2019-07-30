function EnterToAccount(login, password) {
    if (login == "admin" && password == "admin") {
        //if user entered as admin create cookie with value 1, else 0
        document.cookie = "token=1;";
        //вставь переход на главную страницу
        $("#header").load("../shared/header-admin.html");
        $("#footer").load("../shared/footer.html");
        window.location.href = "readers.html";
    } else if (login == "user" && password == "user") {
        document.cookie = "token=0;";
        //вставь переход на главную страницу
        $("#header").load("../shared/header-user.html");
        $("#footer").load("../shared/footer.html");
        window.location.href = "readers.html";
    }
}

function ExitFromAccount() {
    deleteCookie("token");
    //вставь переход на страницу логина
    window.location.href = "login.html";
}


// возвращает cookie с именем name, если есть, если нет, то undefined
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

function deleteCookie(name) {
    setCookie(name, "", {
        expires: -1
    })
}

// use this function always, when you entered on page
//использовать на всех страницах кроме логина
function checkCookie() {
    if (getCookie("token") == undefined) {
        //добавила эту строку для проверки нахожусь ли я сейчас на странице логина, и если нет, то перехожу
        window.location.href = "login.html";
    }else if (getCookie("token") == "0") {
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

//проверка куков на странице логина и переход по ней
//использовать только на странице логина
function CheckCookieFromLogInPage() {
    if (getCookie("token") == "1") {
        //тут вставить значение для АдминХедера
        $("#header").load("../shared/header-admin.html");
        $("#footer").load("../shared/footer.html");
        window.location.href = "readers.html";
    } else if (getCookie("token") == "0") {
        //тут вставить значение для пользовательского хедера
        $("#header").load("../shared/header-user.html");
        $("#footer").load("../shared/footer.html");
        window.location.href = "readers.html";
    }
}


//выполняет проверку логина
function CheckLogIn() {
    EnterToAccount($('#inputName').val(), $('#inputPassword').val())
}






