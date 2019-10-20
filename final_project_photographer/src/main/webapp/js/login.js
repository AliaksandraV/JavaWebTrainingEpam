function submitLoginForm(event){

    var form = document.getElementById('loginForm');

    $.ajax({
        type: "POST",
        url: form.action,
        cache:false,
        data: $('form#loginForm').serialize(),
        success: function(response){
            location.reload();
        },
        error: function(){
            $('#inputEmail').addClass('is-invalid');
            $('#inputPass').addClass('is-invalid');
            $('#loginFeedback').show();
        }
    });

    event.preventDefault();
}

function clearLoginForm() {
    $('#inputEmail').removeClass('is-invalid');
    $('#inputPass').removeClass('is-invalid');
    $('#loginFeedback').hide();
}