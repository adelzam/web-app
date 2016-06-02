$(function ()
{
    var $img = $('.notActive');
    $img.click(function ()
    {
        $img.attr({'src':'../../resources/img/free.png'}).not(this).addClass('notActive').removeClass('Active');
        $(this).toggleClass('notActive Active');
        $(this).hasClass('Active') && (this.src = '../../resources/img/choice.png');
    });
});
var curr = null;
function hide_show(id)
{
    var div=document.getElementById(id).style.display;
    if(div=="none")
    {
        div="block";
    }
    else
    {
        div="none";
    }
    if (curr!=null) {
        document.getElementById(curr).style.display = "none";
    }
    document.getElementById(id).style.display=div;
    curr = id;
}
