// function enterToAccount(login,password){
//     if (login == "admin" && password =="admin"){
//         //if user entered as admin create cookie with value 1, else 0
//         document.cookie = "token=1;";
//         //вставь переход на главную страницу
//         window.location.href = "readers.html";
//     }
//     else if (login == "user" && password == "user"){
//         document.cookie = "token=0;";
//         //вставь переход на главную страницу
//         window.location.href = "main.html";
//     }
// }
// function ExitFromAccount(){
//     deleteCookie("token");
//     //вставь переход на страницу логина
//     window.location.href = "";
// }
//
//
// // возвращает cookie с именем name, если есть, если нет, то undefined
// function getCookie(name) {
//     var matches = document.cookie.match(new RegExp(
//       "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
//     ));
//     return matches ? decodeURIComponent(matches[1]) : undefined;
//   }
//   function deleteCookie(name) {
//     setCookie(name, "", {
//       expires: -1
//     })
//   }
//
//   // use this function always, when you entered on page
// function CheckCookie(){
//     if (getCookie(token)==null ){
//         //тут вставить перенаправление на логин страницу
//         window.location.href = "login.html";
//     }
//     if (getCookie("token")=="1"){
//         //тут вставить значение для АдминХедера
//         $("#header").load("../shared/header.html");
//         $("#footer").load("../shared/footer.html");
//         // $("#header").load("../shared/header-admin.html");
//     }else
//     if(getCookie("token")=="0"){
//         //тут вставить значение для пользовательского хедера
//         $("#header").load("../shared/header-user.html");
//     }
//
// }
//
// function checkCookieFromLogInPage() {
//     if (getCookie("token")=="1"){
//         //тут вставить значение для АдминХедера
//         $("#header").load("../shared/header-admin.html");
//
//         window.location.href = "readers.html";
//     }else
//     if(getCookie("token")=="0"){
//         //тут вставить значение для пользовательского хедера
//         $("#header").load("../shared/header-user.html");
//         window.location.href = "main.html";
//     }
// }
//
// function checkLogIn() {
//     enterToAccount($('#inputName').val(), $('#inputPassword').val())
// }
//
//
//
//
