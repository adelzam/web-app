$(function () {
    var $img = $('.notActive');
    $img.click(function () {
        $img.attr({'src': '../../resources/img/free.png'}).not(this).addClass('notActive').removeClass('Active');
        $(this).toggleClass('notActive Active');
        $(this).hasClass('Active') && (this.src = '../../resources/img/choice.png');
    });
});
var curr = null;
function hide_show(id) {
    var div = document.getElementById(id).style.display;
    if (div == "none") {
        div = "block";
    }
    else {
        div = "none";
    }
    if (curr != null) {
        document.getElementById(curr).style.display = "none";
    }
    document.getElementById(id).style.display = div;
    curr = id;
}
$(document).ready(function () {
//код для обычной работы радиокнопок    
    $('input[type=radio]').click(function (e) {
        e.stopPropagation();
    });
    $('#flights').click(function () {
        var thisRadio = $(this).find('input[type=radio]');// выбираем нужную радиокнопку     
        if (thisRadio.is(':checked')) { // если она отмечена
            thisRadio.removeAttr('checked'); //удаляем отмеченность
        }
        else {// если не отмечена
            thisRadio.prop('checked', 'checked'); // отмечаем
        }
    });
});

function showflight(val1, val2, val3, val4, val5, val6, val7, val8) {
    var div1 = document.getElementById("show").style.display;
    if (div1 == "none") {
        div1 = "block";
    }
    var tax = 0;
    var newval8 = val8.replace(',','.');
    var s = 0;
    var a = 100;
    var t = 0;
    tax = (val4+val5)*val7*parseFloat(newval8);
    s = val6*val7*parseFloat(newval8);
    a = 100*val7;
    t = tax+s+a;
    document.getElementById("dep").innerHTML = val1;
    document.getElementById("arr").innerHTML = val2;
    document.getElementById("info").innerHTML = val3;
    document.getElementById("taxes").innerHTML = tax.toFixed();
    document.getElementById("sum").innerHTML = s.toFixed();
    document.getElementById("assemblies").innerHTML = a;
    document.getElementById("total").innerHTML = t.toFixed();
    document.getElementById("show").style.display = div1;
}