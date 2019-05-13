var CurrentGameID = 0;

var main = function(){
//document.getElementById("CurrentUserName").value = window.name;

/*let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);*/

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
     fetch("/game/listPrev", { method: "GET"} )
            .then( function(response) {
                  let el = document.getElementById("watchGames");
                  if( ! response.ok ) {
                      el.innerText = "Error code: " + response.status;
                      el.style.fontWeight = "bold";
                      el.style.color = "red";
                  } else {
                      response.text().then( function(value) {
                          el.innerText = "previous: " + value;
                          el.style.color = "green";
                          el.style.fontWeight = "bold";
                      });
                  }
                });

};

document.addEventListener("DOMContentLoaded", main);
