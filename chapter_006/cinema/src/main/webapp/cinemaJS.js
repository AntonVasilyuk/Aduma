function validatePlace() {
    var result = true;
    var checkChoise = $('input[type=radio][name=place]:checked').val();
    if (checkChoise == '' || checkChoise == null) {
        result = false;
        alert('Make your choice visitor!');
    }
    return result;
}

function validateUser() {
    var message = 'Please enter '
    var name = $('#username').val();
    var phone = $('#phone').val();
    if (name == null || name == "") message += 'name';
    if (phone == null || phone == "") message += 'phone';
    if(message!='Please enter ') {
        alert(message);
        return false;
    }

    return true;
}

function checkPlace() {
    $.ajax({
        url: "/cinema/hall",
        method: "get",
        complete: function(data) {
            var result = "";
            var hall = JSON.parse(data.responseText);
            for(var i = 0; i < hall.length; i++) {
                if (hall[i].place == 1) {
                    result += "<tr><th>" + hall[i].row + "</th>";
                }
                var isRadio = "";
                var classOccupied = " class=\"occupied\" ";
                if(!hall[i].occupied) {
                    isRadio = "<input type=\"radio\" name=\"place\" value=\"" + hall[i].row + hall[i].place + "\">";
                    classOccupied = " class=\"unoccupied\" ";
                }
                result += "<td " + classOccupied + "id=\"r" + hall[i].row + "p" + hall[i].place + "\">" + isRadio +
                    " Ряд " + hall[i].row + ", Место " + hall[i].place + "</td>";
                if (hall[i].place == 3) {
                    result += "</tr>";
                }
            }
            document.getElementById("cinemaHall").innerHTML = result;
        }
    });
}

function addNewOrder() {
    validateUser();
    var tempValuePlace = getValuePlace();
    var name = $('#username').val();
    var phone = $('#phone').val();
    var array = tempValuePlace.split("");
    var row = array[0];
    var place = array[1];
    var newOrder = {
        "row":row,
        "place":place,
        "name":name,
        "phone":phone,
        "occupied":true
    };
    document.location.href = 'index.html';
    $.ajax({
        url: "/cinema/hall",
        method: "post",
        data: JSON.stringify(newOrder),
        contentType: "application/json",
        complete: function () {
            window.location.href = 'index.html';
        }
    })
}

function getValuePlace() {
    var gettingParam = window.location.search.split('=');
    return gettingParam[1];
}

function getPlaceForPayment() {
    var place = getValuePlace();
    var rowAndPlace = place.split("");
    var result = "Вы выбрали ряд " + rowAndPlace[0]+ " место " + rowAndPlace[1] + ", Сумма : 500 рублей.";
    document.getElementById("placePayment").innerHTML = result;

}
/*

setInterval(function () {
    checkPlace();
}, 5000);*/
