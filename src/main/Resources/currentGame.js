var CurrentGameID = 0;

var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);

let genButton = document.getElementById("genGames");
genButton.addEventListener("click", genGames);
document.getElementById("CurrentUserName").value = window.name;
};

var buttonClickEnterGame = function(e)
{
    var Gameid = document.getElementById("IDtextfield").value;
    var req = new XMLHttpRequest();
    window.name = document.getElementById("IDtextfield").value;
    if(Gameid !== null){
    document.location.href = "/playingGame";
    }


};

var genGames = function(e){
     fetch("/game/list", { method: "GET"} )
            .then( function(response) {
                  let el = document.getElementById("currentGames");
                  if( ! response.ok ) {
                      el.innerText = "Error code: " + response.status;
                      el.style.fontWeight = "bold";
                      el.style.color = "red";
                  } else {
                      response.text().then( function(value) {
                          el.innerText = value;
                          el.style.color = "green";
                          el.style.fontWeight = "bold";
                      });
                  }
                });

};

document.addEventListener("DOMContentLoaded", main);