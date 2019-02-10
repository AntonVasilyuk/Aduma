function validate() {
    var result = true;
    var message = "Enter your";
    var cName = $('#name').val();
    var cLogin = $('#login').val();
    var cPassword = $('#password').val();
    var cEmail = $('#email').val();
    if (cName == '' || cName == null) {
        message += " name";
        result = false;
    }
    if (cLogin == '' || cLogin == null) {
        message += " login";
        result = false;
    }
    if (cPassword == '' || cPassword == null) {
        message += " password";
        result = false;
    }
    if (cEmail == '' || cEmail == null) {
        message += " email";
        result = false;
    }
    if (!result) {
        alert(message);
    }
    return result;
}

function getCountry() {
    $.ajax({
        url: "country",
        method: "get",
        complete: function (data) {
            var result = "<option name=\"country\"></option>";
            var countries = JSON.parse(data.responseText);
            for (var i = 0; i < countries.length; i++) {
                result += "<option value=\"" + countries[i] + "\" name=\"country\">" + countries[i] + "</option>";
            }
            document.getElementById("country").innerHTML = result;
        }
    });
}
function getCity() {
    var country = $('#country').val();
    $.ajax({
        url: "city",
        method: "get",
        data: {"country" : country},
        complete: function (data) {
            var result = "<option name=\"city\"></option>";
            var cities = JSON.parse(data.responseText);
            for (var i = 0; i < cities.length; i++) {
                result += "<option value=\"" + cities[i] + "\" name=\"city\">" + cities[i] + "</option>";
            }
            document.getElementById("city").innerHTML = result;
        }
    });
}