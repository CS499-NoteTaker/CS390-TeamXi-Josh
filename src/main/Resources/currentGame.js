var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);

let genButton = document.getElementById("genGames");
btn.addEventListener("click", genGames);
};

var buttonClickEnterGame = function(e)
{
    var req = new XMLHttpRequest();
    var gameid = document.getElementById("IDtextfield").value;
    req.open("GET", "/current");
    req.send(gameid);
};

var genGames = function(e){
    console.log("IM CLICKED GEN GAMES HEHEXD");
    fetch("/game", { method: "GET"} )
            .then( function(response) {
            let el = document.getElementById("currentGames");
            if( ! response.ok ) {
                el.innerText = "Error code: " + response.status;
                el.style.fontWeight = "bold";
                el.style.color = "red";
            } else {
                response.json().then(function(data){
                    var displayString = "test";
                    el.value = displayString;
                })

            }
            });
};

document.addEventListener("DOMContentLoaded", main);