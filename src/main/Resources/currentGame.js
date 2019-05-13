var CurrentGameID = 0;



var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);

let genButton = document.getElementById("genGames");
genButton.addEventListener("click", genGames);
};

var buttonClickEnterGame = function(e)
{
    var req = new XMLHttpRequest();
    window.name = document.getElementById("IDtextfield").value;
    document.location.href = "/playingGame";

};

var genGames = function(e){
     fetch("/game", { method: "GET"} )
            .then( function(response) {
                  let el = document.getElementById("currentGames");
                  if( ! response.ok ) {
                      el.innerText = "Error code: " + response.status;
                      el.style.fontWeight = "bold";
                      el.style.color = "red";
                  } else {
                      response.text().then( function(value) {
                          el.innerText = "Response: " + value;
                          el.style.color = "green";
                          el.style.fontWeight = "bold";
                      });
                  }
                });

};

document.addEventListener("DOMContentLoaded", main);