var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);

let genButton = document.getElementById("genGames");
genButton.addEventListener("click", genGames);
};

var buttonClickEnterGame = function(e)
{
    document.location.href = "/playingGame"
    /*
    var req = new XMLHttpRequest();
    var gameid = document.getElementById("IDtextfield").value;
    req.open("GET", "/current");
    req.send(gameid);
    */
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