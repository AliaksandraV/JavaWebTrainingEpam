/**
 * Проверка логина и пароля для входа
 * @param login
 * @param password
 * @constructor
 */

function enterToAccount(login, password) {
    if (login == "admin" && password == "admin") {
        //if user entered as admin create cookie with value 1, else 0
        document.cookie = "token=1;";
        window.location.href = "main.html";
    } else if (login == "user" && password == "user") {
        document.cookie = "token=0;";
        window.location.href = "main.html";
    }
}

//проверка куков на странице логина и переход по ней
//использовать только на странице логина
function checkCookieFromLogInPage() {
    if (getCookie("token") == "1") {
        window.location.href = "main.html";
    } else if (getCookie("token") == "0") {
        window.location.href = "main.html";
    }
}

/**
 * выход из акканта
 */
function exitFromAccount() {
    deleteCookie("token");
}


/**
 * возвращает cookie с именем name, если есть, если нет, то undefined
 * @param name имя cookie
 * @returns {any}
 */
function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}

// use this function always, when you entered on page
//использовать на всех страницах кроме логина
function checkCookie() {
    if (getCookie("token") == undefined) {
        //добавила эту строку для проверки нахожусь ли я сейчас на странице логина, и если нет, то перехожу
        // window.location.href = "login.html";
        $(function () {
            $("#header").load("../shared/header.html");
            $("#footer").load("../shared/footer.html");
        });
    } else if (getCookie("token") == "0") {
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



//выполняет проверку логина
function checkLogIn() {
    enterToAccount($('#inputName').val(), $('#inputPassword').val())
}

/**
 * Удаляет cookie вызовом setCookie с датой в прошлом
 * @param name имя cookie
 */
function deleteCookie(name) {
    setCookie(name, "", {
        expires: -1
    })
}

/**
 * функция ставит куки
 * @param name название cookie
 * @param value значение cookie (строка)
 * @param options объект с дополнительными свойствами для установки cookie
 */
function setCookie(name, value, options) {
    options = options || {};

    var expires = options.expires;

    if (typeof expires == "number" && expires) {
        var d = new Date();
        d.setTime(d.getTime() + expires * 1000);
        expires = options.expires = d;
    }
    if (expires && expires.toUTCString) {
        options.expires = expires.toUTCString();
    }

    value = encodeURIComponent(value);

    var updatedCookie = name + "=" + value;

    for (var propName in options) {
        updatedCookie += "; " + propName;
        var propValue = options[propName];
        if (propValue !== true) {
            updatedCookie += "=" + propValue;
        }
    }

    document.cookie = updatedCookie;
}






