var main = function(){
    drawBoard();
    addPiecesToBoard();
};



var drawBoard = function(){
    let canvas = document.getElementById("canvas-board");

    let ctx = canvas.getContext("2d");
    let w = canvas.width;
    let h = canvas.height;

    ctx.fillStyle = "rgb(255, 255, 255)";
    ctx.fillRect(0, 0, w, h);

    ctx.fillStyle = "rgb(0,0,0)";
    ctx.beginPath();
    for (x=44;x<=880;x+=44) {
            for (y=44;y<=880;y+=44) {
                ctx.moveTo(x, 44);
                ctx.lineTo(x, h);
                ctx.stroke();
                ctx.moveTo(44, y);
                ctx.lineTo(w, y);
                ctx.stroke();
            }
        }
        ctx.font = "20px Arial";
        ctx.fillText("               1      2      3      4      5      6      7      8      9     10    11    12    13    14    15    16    17    18    19", 0, 30);
        ctx.fillText("1", 22, 88);
        ctx.fillText("2", 22, 132);
        ctx.fillText("3", 22, 176);
        ctx.fillText("4", 22, 220);
        ctx.fillText("5", 22, 264);
        ctx.fillText("6", 22, 308);
        ctx.fillText("7", 22, 352);
        ctx.fillText("8", 22, 396);
        ctx.fillText("9", 22, 440);
        ctx.fillText("10", 15, 484);
        ctx.fillText("11", 15, 528);
        ctx.fillText("12", 15, 572);
        ctx.fillText("13", 15, 616);
        ctx.fillText("14", 15, 660);
        ctx.fillText("15", 15, 704);
        ctx.fillText("16", 15, 748);
        ctx.fillText("17", 15, 792);
        ctx.fillText("18", 15, 836);
        ctx.fillText("19", 15, 880);
    ctx.stroke();


};

var addPiecesToBoard = function(){
GameID = window.name;
//req = new XMLHttpRequest();
//req.open("GET", "/current" + GameID);
var Game = Controller.getGameAtIndex(GameID);
for(startvalue = 0; startvalue < 20; startvalue = startvalue + 1 )
{
    for(secondvalue = 0; secondvalue < 20; secondvalue = secondvalue + 1){

    console.log(Game.board.getPointAtLocation(startvalue,secondvalue))
    }
}


};


document.addEventListener("DOMContentLoaded", main);