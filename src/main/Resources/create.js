var main = function(){
    let btn = document.getElementById("create");
    btn.addEventListener("click", buttonClickEvent);
};

/*clicking this button should create the game and automatically lead to a dynamic playingGame page which allows for player one to play
and then player two. */

var buttonClickEvent = function(e){
    console.log("I'm clicked");
    var req = new XMLHttpRequest();
    var play2 = document.getElementById("player2").value;
    console.log(play2);

    req.open("POST", "/game");
    req.send(play2);
}

document.addEventListener("DOMContentLoaded", main);
