var CurrentGameID = 0;



var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);
};

var buttonClickEnterGame = function(e)
{
    var req = new XMLHttpRequest();
    window.name = document.getElementById("IDtextfield").value;
    document.location.href = "/playingGame";

};

document.addEventListener("DOMContentLoaded", main);