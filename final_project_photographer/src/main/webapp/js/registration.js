function submitRegistrationForm(event) {

    var form = document.getElementById('registrationForm');

    // var registrationForm = $('#registrationForm');
    // registrationForm.bootstrapValidator('validate');
    // if (registrationForm.bootstrapValidator('isValid')) {
    if (form.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
        $('#emailServerFeedback').hide();

        form.classList.add('was-validated');
    } else {
        $.ajax({
            type: "POST",
            url: form.action,
            cache: false,
            data: $('form#registrationForm').serialize(),
            success: function (response) {
                window.location.href = response;
            },
            error: function () {
                $('#inputEmail2').addClass('is-invalid');
                $('#emailServerFeedback').show();
                $('#emailClientFeedback').hide();

                form.classList.remove('was-validated');
            }
        });
    }


    // }

    event.preventDefault();
}