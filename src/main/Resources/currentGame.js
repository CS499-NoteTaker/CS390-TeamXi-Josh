var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);

document.addEventListener("DOMContentLoaded", main);

var buttonClickEnterGame = function(e)
{
    var req = new XMLHttpRequest();
    var gameid = document.getElementById("IDtextfield").value;
    req.open("GET", "/current");
    req.send(gameid);
}
