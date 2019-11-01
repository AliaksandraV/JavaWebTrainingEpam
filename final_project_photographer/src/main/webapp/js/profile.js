function submitEditProfileForm(event) {

    var form = document.getElementById('editProfileForm');

    if (form.checkValidity() === false) {
        event.preventDefault();
        event.stopPropagation();
        $('#emailServerFeedback').hide();

        form.classList.add('was-validated');
    } else {
        var url = form.action;
        $.ajax({
            type: "POST",
            url: url,
            cache: false,
            data: $('form#editProfileForm').serialize(),
            success: function (response) {
                window.location.href = response;
            },
            error: function () {
                $('#inputEmailProfile').addClass('is-invalid');
                $('#emailServerFeedback').show();
                $('#emailClientFeedback').hide();

                form.classList.remove('was-validated');
            }
        });
    }

    event.preventDefault();
}