var main = function(){
    let btn = document.getElementById("create");
    btn.addEventListener("click", buttonClickEvent);
};

/*clicking this button should create the game and automatically lead to a dynamic playingGame page which allows for player one to play
and then player two. */

var buttonClickEvent = function(e){
    console.log("I'm clicked");
    var req = new XMLHttpRequest();
    var play1 = document.getElementById("player1").value;
    var play2 = document.getElementById("player2").value;
    var dat = play1 + " " + play2;
    var data = dat;
    console.log(data);

    req.open("POST", "/game");
    req.send(data);
}

document.addEventListener("DOMContentLoaded", main);
