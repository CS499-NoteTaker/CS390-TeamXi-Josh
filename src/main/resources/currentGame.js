var CurrentGameID = 0;

var main = function(){
let btn = document.getElementById("entergamebtn");
btn.addEventListener("click", buttonClickEnterGame);

let genButton = document.getElementById("genGames");
genButton.addEventListener("click", genGames);
//document.getElementById("CurrentUserName").value = window.name;
//localStorage.gameId = document.getElementById("CurrentUserName").value
};

var buttonClickEnterGame = function(e)
{
    //localStorage.setItem("GAMEID", document.getElementById("IDtextfield").value );
    //var Gameid = document.getElementById("IDtextfield").value;
    window.name = document.getElementById("IDtextfield").value;
    CurrentGameID = Number(document.getElementById("IDtextfield").value);
    //Trying to disable buttons if the field is empty
    //if(Gameid != null){
    document.location.href = "/playingGame";
    //}


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