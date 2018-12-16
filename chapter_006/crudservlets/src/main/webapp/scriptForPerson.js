function validate() {
    var result = true;
    var message = "Enter your";
    var cName = $('#name').val();
    var cFamily = $('#family').val();
    var cSex = $('#sex').val();
    var cDesc = $('#desc').val();
    if (cName == '' || cName == null) {
        message += " name";
        result = false;
    }
    if (cFamily == '' || cFamily == null) {
        message += " family";
        result = false;
    }
    if (cSex == '' || cSex == null) {
        message += " your gender";
        result = false;
    }
    if (cDesc == '' || cDesc == null) {
        message += " description"
        result = false;
    }
    if (!result) {
        alert(message);
    }
    return result;
}

function addRows() {
    var cName = $('#name').val();
    var cFamily = $('#family').val();
    var cSex = $('input[type=radio][name=sex]:checked').val();
    var cDesc = $('#desc').val();
    $('#currentTable tr:last').after('<tr><td>' +
        + cName   + '</td><td>' +
        + cFamily + '</td><td>' +
        + cSex    + '</td><td>' +
        + cDesc   + '</td></tr>')
    alert(cName + cFamily + cSex + cDesc);
}

function ajaxGetUser() {
    $.ajax({
        url: "json",
        method: "get",

        complete: function (data) {
            var result = "";
            var persons = JSON.parse(data.responseText);
            if (persons.length > 0) {
                for (var i = 0; i < persons.length; i++) {
                    result += "<tr>"
                        + "<td>" + persons[i].name + "</td>"
                        + "<td>" + persons[i].family + "</td>"
                        + "<td>" + persons[i].sex + "</td>"
                        + "<td>" + persons[i].description + "</td>"
                        + "</tr>"
                }
                    var table = document.getElementById("currentTable");
                    table.innerHTML = result;
            }
        }
    });
}

function ajaxCreateUser() {
    var cName = $('#name').val();
    var cFamily = $('#family').val();
    var cSex = $('input[type=radio][name=sex]:checked').val();
    var cDesc = $('#desc').val();
    var person = {
        "name": cName,
        "family": cFamily,
        "sex": cSex,
        "description": cDesc
    };
    $.ajax({
        url: "json",
        method: "post",
        data: JSON.stringify(person),
        contentType: "application/json",
        complete: function () {
            ajaxGetUser()
        }
    })
}

function addRow(id) {
    var checkName = document.forms["dataEntry"]["name"].value;
    var checkFamily = document.forms["dataEntry"]["family"].value;
    var checkSex = document.forms["dataEntry"]["sex"].value;
    var checkDescription = document.forms["dataEntry"]["description"].value;

    var tableBody = document.getElementById(id).getElementsByTagName("TBODY")[0];
    var row = document.createElement("TR")
    var td1 = document.createElement("TD")
    td1.appendChild(document.createTextNode(checkName))
    var td2 = document.createElement("TD")
    td2.appendChild (document.createTextNode(checkFamily))
    var td3 = document.createElement("TD")
    td3.appendChild (document.createTextNode(checkSex))
    var td4 = document.createElement("TD")
    td2.appendChild (document.createTextNode(checkDescription))
    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    row.appendChild(td4);
    tableBody.appendChild(row);
}

$(document).ready(function () {
    ajaxGetUser();
})