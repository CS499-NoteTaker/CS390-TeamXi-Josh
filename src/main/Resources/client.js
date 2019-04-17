var main = function(){
    drawBoard();
};

var drawBoard = function(){
    let canvas = document.getElementById("canvas-board");

    let ctx = canvas.getContext("2d");
    let w = canvas.width;
    let h = canvas.height;

    ctx.fillStyle = "rgb(255, 255, 255)";
    ctx.fillRect(0, 0, w, h);

    ctx.fillStyle = "black";
    ctx.fillRect(130, 190, 40, 60);


};
document.addEventListener("DOMContentLoaded", main);